<%@page contentType="text/html; UTF-8"  pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
        $("#udb").datagrid({
            url:'${pageContext.request.contextPath}/user/queryAll',
            striped:true,
            pagination:true,
            fitColumns:true,
            fit:true,
            pageNumber: 1,
            pageSize: 5,//pageSize的取值必须是pageList数组中的一个元素
            pageList: [5, 10, 15, 20, 500],
            columns:[[
                {field:'id',title:'编号',width:60},
                {field:'phone',title:'电话',width:50},
                {field:'username',title:'名字',width:50},
                {field:'password',title:'密码',width:100},
                {field:'salt',title:'私盐',width:80},
                {field:'state',title:'状态',width:50},
                {field:'date',title:'注册日期',width:80},
                {title:'操作',field:"options",width:80,align:"center",
                    formatter:function(value,row,index){
                        return "<a class='del' data-options=\"iconCls:'icon-20130408025545236_easyicon_net_30',plain:true\" onclick=\"delUser('"+row.id+"')\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;"+"<a class='del' data-options=\"iconCls:'icon-edit',plain:true\" onclick=\"updUser('"+row.id+"')\">修改状态</a>";
                    }
                }
            ]],
            toolbar: '#utb',
            onLoadSuccess:function(data){
                $(".del").linkbutton();
            }

        });

    });

    //修改一个用户，传递过来一个id,这是应该把获取的用户的信息加载到当前的对话框中

    function updUser(id){
        //打开一个修改的对话框
        $("#updateUserDialog").dialog({
            title:"冻结/解冻用户信息",
            iconCls:'icon-edit',
            width:300,
            height:300,
            href:'${pageContext.request.contextPath}/back/user/editUser.jsp?id='+id,
            buttons:[{
                text:'修改用户状态',
                iconCls:'icon-edit',
                handler:updateUser,
            }]
        });
    }
    //修改用户的方法
    function updateUser(id){

        $("#updateUserForm").form('submit',{
            url:'${pageContext.request.contextPath}/user/update',
            onSubmit:function(){
                return  $("#updateUserForm").form('validate');
            },
            success:function(){
                $.messager.alert({
                    title:'修改用户状态',
                    msg:'冻结/解冻用户成功~~~'

                });
                //关闭对话框
                $("#updateUserDialog").dialog('close',true);
                //刷新数据表格
                $("#udb").datagrid('reload');

            }

        });
    }

    function uploadUser(){
        location.href='/kfsy_zhanghb/user/copy';
    }
    //注销用户
    function delUser(id){
        // console.log(id);
        $.messager.confirm('提示','您确定要注销该用户吗?',function(r){
            if(r){
                //发送ajax请求用户删除数据
                $.post('${pageContext.request.contextPath}/user/delete',{"id":id},function(){
                    $.messager.show({
                        title:"提示",
                        msg:'注销用户成功~~~',
                    });
                    //刷新页面
                    // $("#dg").datagrid('load');//始终保持展示在第一页
                    $("#udb").datagrid('reload');//保持在当前页展示

                });
            }
        });

    }

    function qq(value,name){


    }
</script>

<table id="udb"></table>

<%--工具栏--%>
<div id="utb">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true," onclick="uploadUser()">导出信息</a>
    <%--搜索框--%>
    <input class="easyui-searchbox" data-options="searcher:qq,prompt:'请输入查询条件....',menu:'#mmm',width:400"/>
    <div id="mmm">
        <div data-options="name:'username',">姓名</div>
        <div data-options="name:'phone'">电话</div>
    </div>
</div>



<%--用于修改的对话框--%>
<div id="updateUserDialog"></div>

</div>
