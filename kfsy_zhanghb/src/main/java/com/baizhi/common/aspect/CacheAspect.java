package com.baizhi.common.aspect;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.DigestUtils;
import redis.clients.jedis.Jedis;

@Configuration
@Aspect
public class CacheAspect {
    @Autowired
    private Jedis jedis ;
    /**
     * 环绕方法  用来纳入缓存
     * @return
     *
     * 切入点表达式: execution(* com.baizhi.service.*.*(..))
     * 注解的切入点表达式:@annotation(注解全限定名)
     */
    @Around("@annotation(com.baizhi.common.annotation.RedisCache)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object proceed = null;
        //先去redis中获取看看是否存在这个key
        //key 如何生成 string hash
        String mapkey = proceedingJoinPoint.getTarget().getClass().getName();
        //获取目标方法的返回值类型
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        //方法key
        String methodKey = getMethodKey(proceedingJoinPoint);
        if(jedis.hexists(mapkey,methodKey)){//存在
            String json = jedis.hget(mapkey, methodKey);
            // 对象类型json  转为对象    集合类型json   转为集合
            proceed = JSONObject.parseObject(json, signature.getMethod().getGenericReturnType());
        }else{//不存在
            proceed = proceedingJoinPoint.proceed();
            //存入redis中
            String json = JSONObject.toJSONStringWithDateFormat(proceed, "yyyy-MM-dd");
            jedis.hset(mapkey,methodKey, json);
            proceed = JSONObject.parseObject(json,  signature.getMethod().getGenericReturnType());
        }
        return proceed;
    }
    /**
     * 用来生成key的方法
     */
    public String  getMethodKey(ProceedingJoinPoint proceedingJoinPoint){
        //methodkey
        String methodkey  = proceedingJoinPoint.getSignature().toString();
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            methodkey+=arg;
        }
        return DigestUtils.md5DigestAsHex(methodkey.getBytes());
    }
    /**
     * 什么时候清除缓存   一定目标方法执行完成之后之后清除缓存
     */
    @After("@annotation(com.baizhi.common.annotation.FlushCache)")
    public void after(JoinPoint joinPoint){
        //清除缓存  业务层整个map  mapkey
        String mapkey = joinPoint.getTarget().getClass().getName();
        jedis.del(mapkey);
    }
}