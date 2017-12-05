<%@ page pageEncoding="utf-8"  contentType="text/html; utf-8" isELIgnored="false" %>
<script>
    $(function () {

        $("#dgType").datagrid({
            url:'${pageContext.request.contextPath}/type/queryAll',
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
                {title:'编号',field:'id',width:100,align:'center',resizable:false},
                {title:'分类名称',field:'name',width:200,align:'center',resizable:false},
                {title:'分类图标',field:'image',width:100,align:'center',resizable:false,
                    formatter:function(value,row,index){
                        return " <img style='height: 50px'  src=\"\\kfsy_zhanghb\\back\\type\\image\\"+ row.image +"\"/> ";

                    }
                },
                {title:'操作',field:'o',width:200,align:'center',resizable:false,
                    formatter:function(value,row,index){

                        return "<a class='del' onclick=\"delType('"+row.id+"')\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "<a class='upd' onclick=\"updType('"+row.id+"')\">修改</a>"

                    }
                }
            ]],
            toolbar:'#tbDrug',
            onLoadSuccess:function(data){

                $(".del").linkbutton({
                    iconCls:'icon-remove',
                    plain:true,
                });
                $(".upd").linkbutton({
                    iconCls:'icon-edit',
                    plain:true,
                });
            }


        });



    });

    function addType() {
        $("#addType").dialog({
            title:'添加分类信息',
            width:400,
            height:300,
            draggable:false,
            iconCls:'icon-man',
            href:'${pageContext.request.contextPath}/back/type/addType.jsp',
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                handler:function () {
                    $("#addTypeForm").form('submit',{
                        url:'${pageContext.request.contextPath}/type/addType',
                        onSubmit:function () {
                            return $("#addTypeForm").form("validate");
                        },
                        success:function (data) {

                            $.messager.show({
                                title:'提示',
                                msg:"成功",
                            });

                            $("#addType").dialog('close',true);
                            $("#dgType").datagrid('reload');
                        },

                    })
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function () {
                    $("#dgType").dialog('close');
                }
            }],


        });
    }

    function delType(id) {

        $.messager.confirm('提示','确定要删除吗?',function (r) {
            if(r){
                $.post('${pageContext.request.contextPath}/type/removeOne',{"id":id},function(result){

                    $.messager.show({
                        title:'提示',
                        msg:result.msg,
                    });

                    $("#dgType").datagrid('reload');

                },"JSON");
            }
        })
    }

    function updType(id) {
        $("#updType").dialog({
            title:'修改用户状态',
            iconCls:'icon-man',
            draggable:false,
            width:400,
            height:300,
            href:'${pageContext.request.contextPath}/back/type/editType.jsp?id='+id ,
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                handler:function () {
                    $("#updTypeForm").form('submit',{
                        url:'${pageContext.request.contextPath}/type/modifyOne',
                        onSubmit:function () {
                            return $("#updTypeForm").form("validate");
                        },
                        success:function (data) {
                            $.messager.show({
                                title:'提示',
                                msg:'修改状态成功...',
                            });

                            $("#updType").dialog('close',true);
                            $("#dgType").datagrid('reload');
                        },

                    })
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function () {
                    $("#updType").dialog('close');
                }
            }],

        });
    };

    function ss(value,name) {

        $("#dg").datagrid({
            url:'${pageContext.request.contextPath}/user/queryAll?v='+value+'&'+'cc='+name,
        });
        /*$.post('${pageContext.request.contextPath}/emp/queryAllBy',{"v":value,"cc":name},function (r) {
            console.log(r)

        },"JSON");*/
    }

    function add() {
        $("#add").dialog({
            title:'添加信息',
            width:720,
            height:400,
            href:'${pageContext.request.contextPath}/back/main/kindeditor.jsp',

        });
    }

</script>

    <table id="dgType">


    </table>

    <div id="tbDrug">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true," onclick="addType()">添加</a>
        <%--<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true," onclick="add()">添加信息</a>
--%>
       <%-- <input id="ss" class="easyui-searchbox"
               data-options="searcher:ss,prompt:'请输入查询条件....',menu:'#mm',width:400"/>
        <div id="mm" data-options="">
            <div data-options="name:'username',">用户名</div>
            <div data-options="name:'phone'">手机号</div>
        </div>--%>
    </div>

    <div id="addType"></div>

    <div id="updType"></div>

    <div id="add"></div>
