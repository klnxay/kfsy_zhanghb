package com.baizhi.front.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.baizhi.common.entity.Result;
import com.baizhi.common.entity.User;
import com.baizhi.common.util.Ali;
import com.baizhi.front.service.FUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/fuser")
public class FUserController {
    @Autowired
    private FUserService fUserService;

    @RequestMapping("/login")
    public Result login(User user,String code){
        Result result = new Result();
        try {

            Jedis jedis = new Jedis("192.168.233.128",6379);
            String code1 = jedis.get("code");
            if(!code.equals(code1)){
                throw new RuntimeException("验证码错误或已过期");
            }
            fUserService.addUser(user);
            result.setSuccess(true);
            result.setMassage("登录成功");
        } catch (RuntimeException e) {
            result.setSuccess(false);
            result.setMassage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/login1")
    public Result login1(User user){
        Result result = new Result();
        try {
            User user1 = fUserService.queryOne(user.getPhone());
            if(user1==null){
                throw new RuntimeException("手机号尚未注册");
            }

            if(!user1.getPassword().equals(DigestUtils.md5DigestAsHex((user.getPassword() + user1.getSalt()).getBytes()))){
                throw new RuntimeException("密码错误");
            }
            if(user1.getState()!="激活"){
                throw new RuntimeException("账号被冻结");
            }
            result.setSuccess(true);
            result.setMassage("登录成功");
        } catch (RuntimeException e) {
            result.setSuccess(false);
            result.setMassage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/valid")
    public Result valid(String phone) throws Exception{
        Result result = new Result();
        /*Result result = new Result();
        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化ascClient需要的几个参数
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
        //替换成你的AK
        final String accessKeyId = "LTAIia0ypoHtPV9H";//你的accessKeyId,参考本文档步骤2
        final String accessKeySecret = "eSMzpjylYk4s6JSpEwq13fP00ouVOo";//你的accessKeySecret，参考本文档步骤2
        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
        request.setPhoneNumbers("15003885060");
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("雪klnxay");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_109465120");
        String a = Ali.a(6);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        request.setTemplateParam("{\"code\":\""+a+"\"}");
        //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");
        //请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            //请求成功

        }*/
        fUserService.va(phone);
        return result;
    }

    @RequestMapping("/register")
    public Result register(User user,String code){
        Result result = new Result();
        try {
            User user1 = fUserService.queryOne(user.getPhone());
            if(user1!=null){
                throw new RuntimeException("手机号已注册");
            }
            Jedis jedis = new Jedis("192.168.233.128",6379);
            String code1 = jedis.get("code");
            if(!code.equals(code1)){
                throw new RuntimeException("验证码错误或已过期");
            }
            fUserService.addUser(user);
            result.setSuccess(true);
            result.setMassage("注册成功");
        } catch (RuntimeException e) {
            result.setSuccess(false);
            result.setMassage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
