<%@ page pageEncoding="utf-8"  contentType="text/html; utf-8" isELIgnored="false" %>
<script>
    $(function () {

        $("#dgThems").datagrid({
            url:'${pageContext.request.contextPath}/thems/queryAll',
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
                {title:'主题名称',field:'name',width:200,align:'center',resizable:false},
                {title:'主题描述',field:'description',width:100,align:'center',resizable:false},
                {title:'主题图片',field:'image',width:200,align:'center',resizable:false,
                    formatter:function(value,row,index){
                        return " <img style='height: 50px'  src=\"\\kfsy_zhanghb\\back\\thems\\image\\"+ row.image +"\"/> ";

                    }
                },
                {title:'操作',field:'o',width:200,align:'center',resizable:false,
                    formatter:function(value,row,index){

                        return "<a class='del' onclick=\"delThems('"+row.id+"')\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "<a class='upd' onclick=\"updThems('"+row.id+"')\">修改</a>"

                    }
                }
            ]],
            toolbar:'#tbThems',
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

    function addThems() {
        $("#addThems").dialog({
            title:'添加信息',
            width:400,
            height:300,
            draggable:false,
            iconCls:'icon-man',
            href:'${pageContext.request.contextPath}/back/thems/addThems.jsp',
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                handler:function () {
                    $("#addThemsForm").form('submit',{
                        url:'${pageContext.request.contextPath}/thems/addThems',
                        onSubmit:function () {
                            return $("#addThemsForm").form("validate");
                        },
                        success:function (data) {

                            $.messager.show({
                                title:'提示',
                                msg:"成功",
                            });

                            $("#addThems").dialog('close',true);
                            $("#dgThems").datagrid('reload');
                        },

                    })
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function () {
                    $("#dgThems").dialog('close');
                }
            }],


        });
    }

    function delThems(id) {

        $.messager.confirm('提示','确定要删除吗?',function (r) {
            if(r){
                $.post('${pageContext.request.contextPath}/thems/removeOne',{"id":id},function(result){

                    $.messager.show({
                        title:'提示',
                        msg:result.msg,
                    });

                    $("#dgThems").datagrid('reload');

                },"JSON");
            }
        })
    }

    function updThems(id) {
        $("#updThems").dialog({
            title:'修改',
            iconCls:'icon-man',
            draggable:false,
            width:400,
            height:300,
            href:'${pageContext.request.contextPath}/back/thems/editThems.jsp?id='+id ,
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                handler:function () {
                    $("#updThemsForm").form('submit',{
                        url:'${pageContext.request.contextPath}/thems/modifyOne',
                        onSubmit:function () {
                            return $("#updThemsForm").form("validate");
                        },
                        success:function (data) {
                            $.messager.show({
                                title:'提示',
                                msg:'修改成功...',
                            });

                            $("#updThems").dialog('close',true);
                            $("#dgThems").datagrid('reload');
                        },

                    })
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function () {
                    $("#updThems").dialog('close');
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

    <table id="dgThems">


    </table>

    <div id="tbThems">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true," onclick="addThems()">添加</a>
        <%--<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true," onclick="add()">添加信息</a>
--%>
       <%-- <input id="ss" class="easyui-searchbox"
               data-options="searcher:ss,prompt:'请输入查询条件....',menu:'#mm',width:400"/>
        <div id="mm" data-options="">
            <div data-options="name:'username',">用户名</div>
            <div data-options="name:'phone'">手机号</div>
        </div>--%>
    </div>

    <div id="addThems"></div>

    <div id="updThems"></div>

    <div id="add"></div>
