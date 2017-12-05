<%@page contentType="text/html; UTF-8"  pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
        $("#sdb").datagrid({
            url:'${pageContext.request.contextPath}/services/all',
            striped:true,
            pagination:true,
            fitColumns:true,
            fit:true,
            pageList:[5,10,20,30,50],
            columns:[[
                {field:'id',title:'编号',width:100},
                {field:'name',title:'评价等级',width:100},
                {field:'count',title:'此评价人数',width:100},
                {title:'操作',field:"options",width:80,align:"center",
                    formatter:function(value,row,index){
                        return "<a class='del' data-options=\"iconCls:'icon-20130408025545236_easyicon_net_30',plain:true\" onclick=\"deletes('"+row.id+"')\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;"+
                            "<a class='del' data-options=\"iconCls:'icon-edit',plain:true\" onclick=\"update('"+row.id+"')\">修改</a>";
                    }
                }
            ]],
            toolbar: '#stb',
            onLoadSuccess:function(data){
                $(".del").linkbutton();
            }

        });

    });


    function opens(){
        $("#servicesi").dialog({

            width:400,
            height:250,
            title:'添加服务评价信息',
            iconCls:'icon-man',
            href:"/kfsy/back/services/form.jsp",
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                onClick:add,
            },{
                text:'关闭',
                iconCls:'icon-arrow_redo',
                onClick:function () {
                    $("#servicesi").dialog('close');
                }
            }],


        });

    }
    function add(){
        $("#sfor").form('submit',{
            url:"/kfsy/services/add",
            success:function (data) {
                $.messager.alert('消息','您的添加操作成功');
                $("#sdb").datagrid('reload');
                $("#servicesi").dialog('close');


            }
        });
    }
    function deletes(ids){
        $("#servicesd").dialog({
            width:300,
            height:200,
            title:'删除服务评价',
            iconCls:'icon-man',
            href:"/kfsy/back/services/formd.jsp",
            buttons:[{
                text:'是',
                iconCls:'icon-save',
                onClick:function () {
                    $("#stfor").form('submit',{
                        url:"/kfsy/services/remove?id="+ids,
                        success:function (data) {
                            $.messager.alert('消息','您的删除操作成功');
                            $("#sdb").datagrid('reload');
                            $("#servicesd").dialog('close');

                        }
                    });
                }
            },{
                text:'否',
                iconCls:'icon-arrow_redo',
                onClick:function () {
                    $("#servicesd").dialog('close');
                }
            }],
        });
    }
    function update(ids){
        $("#servicesn").dialog({

            width:400,
            height:300,
            title:'修改服务评价',
            iconCls:'icon-man',
            href:"/kfsy/back/services/forms.jsp?id="+ids,
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                onClick:function () {
                    $("#sforss").form('submit',{
                        url:"/kfsy/services/modifi",
                        success:function (data) {
                            $.messager.alert('消息','您的修改操作成功');
                            $("#sdb").datagrid('reload');
                            $("#servicesn").dialog('close');

                        }
                    });
                }
            },{
                text:'关闭',
                iconCls:'icon-arrow_redo',
                onClick:function () {
                    $("#servicesn").dialog('close');
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

<table id="sdb"></table>


<div id="stb">
    <a href="#" class="easyui-linkbutton" onclick="opens();" data-options="iconCls:'icon-add',plain:true">添加</a>
    <%--搜索框--%>
    <input id="ss" class="easyui-searchbox"
           data-options="searcher:qq,prompt:'请输入查询条件....',menu:'#mm',width:400"/>
    <div id="mm" data-options="">
        <div data-options="name:'name',">id</div>
        <div data-options="name:'bir'">name</div>
    </div>
</div>
