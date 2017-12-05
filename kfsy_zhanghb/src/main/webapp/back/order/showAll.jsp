<%@ page pageEncoding="utf-8"  contentType="text/html; utf-8" isELIgnored="false" %>
<script>
    $(function () {

        $("#dgOrder").datagrid({
            url:'/kfsy_zhanghb/order/queryAll',
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
                {title:'编号',field:'id',width:100,align:'center',resizable:false,
                    formatter:function(value,row,index){
                        return "<a class='orderItem' onclick=\"queryOrderItem('"+value+"')\">"+value+"</a>";

                    }},
                {title:'地址编号',field:'addressid',width:200,align:'center',resizable:false,
                    formatter:function(value,row,index){
                        return "<a class='address' onclick=\"queryAddress('"+value+"')\">"+value+"</a>";

                    }},
                {title:'订单描述',field:'content',width:100,align:'center',resizable:false},
                {title:'用户编号',field:'userid',width:200,align:'center',resizable:false,
                    formatter:function(value,row,index){
                        return "<a class='user' onclick=\"queryUser('"+value+"')\">"+value+"</a>";

                    }},
                {title:'付款方式',field:'buy',width:200,align:'center',resizable:false},
                {title:'付款时间',field:'date',width:200,align:'center',resizable:false},
                {title:'创建时间',field:'newdate',width:200,align:'center',resizable:false},
                {title:'订单状态',field:'state',width:200,align:'center',resizable:false},
            ]],
            onLoadSuccess:function(data){
                $(".orderItem").linkbutton({
                    plain:true,
                });
                $(".address").linkbutton({
                    plain:true,
                });
                $(".user").linkbutton({
                    plain:true,
                });
            }
        });

    });
    function queryOrderItem(id) {
        $("#queryOrderItem").dialog({
            title: '查看订单项',
            iconCls: 'icon-man',
            draggable: false,
            width: 400,
            height: 300,
            href: '/kfsy_zhanghb/back/orderItem/showAll.jsp?id=' + id,
            buttons: [{
                text: '关闭',
                iconCls: 'icon-cancel',
                handler: function () {
                    $("#queryOrderItem").dialog('close');
                }
            }],

        });
    }

    function queryAddress(id) {
        $("#queryAddress").dialog({
            title: '查看地址',
            iconCls: 'icon-man',
            draggable: false,
            width: 400,
            height: 300,
            href: '/kfsy_zhanghb/back/address/showOne.jsp?id=' + id,
            buttons: [{
                text: '关闭',
                iconCls: 'icon-cancel',
                handler: function () {
                    $("#queryAddress").dialog('close');
                }
            }],

        });
    }
    function queryUser(id) {
        $("#queryUser").dialog({
            title: '查看用户',
            iconCls: 'icon-man',
            draggable: false,
            width: 400,
            height: 300,
            href: '/kfsy_zhanghb/back/user/showOne.jsp?id=' + id,
            buttons: [{
                text: '关闭',
                iconCls: 'icon-cancel',
                handler: function () {
                    $("#queryUser").dialog('close');
                }
            }],

        });
    }

</script>

    <table id="dgOrder">


    </table>

    <div id="queryOrderItem"></div>

    <div id="queryAddress"></div>

    <div id="queryUser"></div>
