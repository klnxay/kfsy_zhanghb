<%@page contentType="text/html; UTF-8"  pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
        $("#cdb").datagrid({
            url:'${pageContext.request.contextPath}/comment/all',
            striped:true,
            pagination:true,
            fitColumns:true,
            fit:true,
            pageList:[5,10,20,30,50],
            columns:[[
                {field:'id',title:'编号',width:100},
                {field:'name',title:'用户名',width:50},
                {field:'names',title:'服务评价内容',width:100},
                {field:'content',title:'内容',width:100},
                {field:'date',title:'评论时间',width:100},
                {field:'grade',title:'评价星级',width:40},
                {field:'orderid',title:'订单id',width:100},
                {field:'serviceid',title:'服务评价id',width:100},
                {title:'操作',field:"options",width:100,align:"center",
                    formatter:function(value,row,index){
                        return "<a class='del' data-options=\"iconCls:'icon-20130408025545236_easyicon_net_30',plain:true\" onclick=\"deletes('"+row.id+"')\">删除</a>"
                    }
                }
            ]],
            toolbar: '#ctb',
            onLoadSuccess:function(data){
                $(".del").linkbutton();
            }

        });

    });



    function deletes(ids){
        $("#commenti").dialog({
            width:300,
            height:200,
            title:'删除用户评论',
            iconCls:'icon-man',
            href:"/kfsy/back/comment/form.jsp",
            buttons:[{
                text:'是',
                iconCls:'icon-save',
                onClick:function () {
                    $("#cfor").form('submit',{
                        url:"/kfsy/comment/remove?id="+ids,
                        success:function (data) {
                            $.messager.alert('消息','您的删除操作成功');
                            $("#cdb").datagrid('reload');
                            $("#commenti").dialog('close');

                        }
                    });
                }
            },{
                text:'否',
                iconCls:'icon-arrow_redo',
                onClick:function () {
                    $("#commenti").dialog('close');
                }
            }],
        });
    }

    //处理搜索
    function qq(value,name){
        console.log(value)
        console.log(name);


    }
</script>

<table id="cdb"></table>


<div id="ctb">

    <input id="ss" class="easyui-searchbox"
           data-options="searcher:qq,prompt:'请输入查询条件....',menu:'#mm',width:400"/>
    <div id="mm" data-options="">
        <div data-options="name:'name',">id</div>
        <div data-options="name:'bir'">serviceid</div>
    </div>
</div>
