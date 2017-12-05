<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
  <head>
    <title>index.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=GBK">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    <style type="text/css">
		body{
			text-align: center;
		}
		
		select{
			width:150px;
		}
		
    </style>
<script type="text/javascript" src="/kfsy_zhanghb/back/easyui/js/jquery.min.js"></script>
<script type="text/javascript" src="/kfsy_zhanghb/back/js/echarts.min.js"></script>

<script type="text/javascript">
	$(function(){
		//基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'));
		
		// 指定图表的配置项和数据
		myChart.setOption({
			 backgroundColor: '#7EC0EE',

			    title: {
			        text: 'Customized Pie',
			        left: 'center',
			        top: 20,
			        textStyle: {
			            color: '#ccc'
			        }
			    },

			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },

			    visualMap: {
			        show: false,
			        min: 80,
			        max: 600,
			        inRange: {
			            colorLightness: [0, 1]
			        }
			    },
			    series : [
			        {
			            name:'访问来源',
			            type:'pie',
			            radius : '55%',
			            center: ['50%', '50%'],
			            data:[
			                {value:335, name:'直接访问'},
			                {value:310, name:'邮件营销'},
			                {value:274, name:'联盟广告'},
			                {value:235, name:'视频广告'},
			                {value:400, name:'搜索引擎'}
			            ].sort(function (a, b) { return a.value - b.value; }),
			            roseType: 'radius',
			            label: {
			                normal: {
			                    textStyle: {
			                        color: 'rgba(255, 255, 255, 0.3)'
			                    }
			                }
			            }
			        }]
		})
		
});
		
		

</script>
  </head>
  
  <body >
  	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 400px;height:400px;"></div>
    
  </body>
</html>

