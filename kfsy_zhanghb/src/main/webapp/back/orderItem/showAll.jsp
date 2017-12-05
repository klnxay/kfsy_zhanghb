<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<script>
    $(function(){
        var id = ${param.id}
        $("#dgOrderItem").datagrid({
            url:'/kfsy_zhanghb/orderItem/queryAll?orderId='+id,
            fitColumns:true,
            striped:true,
            fit:true,
            nowrap:true,
            ctrlSelect:true,
            pagination:true,
            pageSize:5,
            pageList:[1,2,3,5],
            columns:[[
                {title:'cks',field:'cks',width:100,align:'center',resizable:false,checkbox:true},
                {title:'订单项编号',field:'id',width:100,align:'center',resizable:false},
                {title:'商品编号',field:'proid',width:200,align:'center',resizable:false,
                    formatter:function(value,row,index){
                        return "<a class='pro' onclick=\"queryPro('"+value+"')\">"+value+"</a>";

                    }},
                {title:'商品数量',field:'num',width:100,align:'center',resizable:false},
                {title:'商品价格',field:'price',width:200,align:'center',resizable:false},
            ]],
            onLoadSuccess:function(data){

                $(".pro").linkbutton({
                    plain:true,
                });
            }


        });
    });

</script>

<table id="dgOrderItem">


</table>
