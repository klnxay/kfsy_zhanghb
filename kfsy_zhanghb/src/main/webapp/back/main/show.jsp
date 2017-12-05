<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


    <style type="text/css">
		body{
			text-align: center;
		}
		
		select{
			width:150px;
		}
		
    </style>
<script type="text/javascript" src="/kfsy_zhanghb/js/echarts.min.js"></script>
<script type="text/javascript">
	$(function(){
		//基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'));
		
		// 指定图表的配置项和数据
		myChart.setOption({
		    title: {
		        text: '用户注册时间综合展示'
		    },
		    tooltip: {},
		    legend: {
		        data:['人数']
		    },
		    xAxis: {
		        data: []
		    },
		    yAxis: {},
		    series: [{
		        name: '人数',
		        type: 'bar',
		        data: [],
		        itemStyle:{
                    normal:{
                        color:function(params) { 
                        	var colorList = [ 
                        	'#C33531','#EFE42A','#64BD3D','#EE9201','#29AAE3', 
                        	'#B74AE5','#0AAF9F','#E89589' 
                        	]; 
                        	return colorList[params.dataIndex] ;
                    }
                    }
                },
                label:{ 
                    normal:{ 
                        show: true, 
                        position: 'insideTop'} 
                        }
		    }]
		});
		$.get("${pageContext.request.contextPath}/user/echar").done(function(data){
			myChart.setOption({
				xAxis: {
			        data:data.a
			    },
			    series: [{
			        name: '人数',
			        data: data.b
			    }]
				
			});
		});
	
		
		
	});
</script>

<div id="main" style="width: 400px;height:400px;"></div>



