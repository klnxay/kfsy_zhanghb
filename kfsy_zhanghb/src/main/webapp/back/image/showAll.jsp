<%@ page pageEncoding="utf-8"  contentType="text/html; utf-8" isELIgnored="false" %>
<script>
    $(function () {

        $("#dgImage").datagrid({
            url:'${pageContext.request.contextPath}/image/queryAll',
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
                {title:'药房图片',field:'image',width:200,align:'center',resizable:false,
                    formatter:function(value,row,index){
                        return " <img style='height: 50px'  src=\"\\kfsy_zhanghb\\back\\image\\image\\"+ row.image +"\"/> ";

                    }
                },
                {title:'药房编号',field:'drugid',width:100,align:'center',resizable:false},
                {title:'状态',field:'state',width:200,align:'center',resizable:false},
                {title:'类型',field:'type',width:200,align:'center',resizable:false},
                {title:'操作',field:'o',width:200,align:'center',resizable:false,
                    formatter:function(value,row,index){

                        return "<a class='del' onclick=\"delImage('"+row.id+"')\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "<a class='upd' onclick=\"updImage('"+row.id+"')\">修改</a>"

                    }
                }
            ]],
            toolbar:'#tbImage',
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

    function addImage() {
        $("#addImage").dialog({
            title:'添加品牌信息',
            width:400,
            height:300,
            draggable:false,
            iconCls:'icon-man',
            href:'${pageContext.request.contextPath}/back/image/addImage.jsp',
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                handler:function () {
                    $("#addImageForm").form('submit',{
                        url:'${pageContext.request.contextPath}/image/addImage',
                        onSubmit:function () {
                            return $("#addImageForm").form("validate");
                        },
                        success:function (data) {
                            var d = eval("("+data+")");
                            $.messager.show({
                                title:'提示',
                                msg:d.msg,
                            });

                            $("#addImage").dialog('close',true);
                            $("#dgImage").datagrid('reload');
                        },

                    })
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function () {
                    $("#addImage").dialog('close');
                }
            }],


        });
    }

    function delImage(id) {

        $.messager.confirm('提示','确定要删除吗?',function (r) {
            if(r){
                $.post('${pageContext.request.contextPath}/image/removeOne',{"id":id},function(result){

                    $.messager.show({
                        title:'提示',
                        msg:result.msg,
                    });

                    $("#dgImage").datagrid('reload');

                },"JSON");
            }
        })
    }

    function updImage(id) {
        $("#updImage").dialog({
            title:'修改用户状态',
            iconCls:'icon-man',
            draggable:false,
            width:400,
            height:300,
            href:'${pageContext.request.contextPath}/back/image/editImage.jsp?id='+id ,
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                handler:function () {
                    $("#updImageForm").form('submit',{
                        url:'${pageContext.request.contextPath}/image/modifyOne',
                        onSubmit:function () {
                            return $("#updImageForm").form("validate");
                        },
                        success:function (data) {
                            $.messager.show({
                                title:'提示',
                                msg:'修改状态成功...',
                            });

                            $("#updImage").dialog('close',true);
                            $("#dgImage").datagrid('reload');
                        },

                    })
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function () {
                    $("#updImage").dialog('close');
                }
            }],

        });
    };


</script>

    <table id="dgImage">


    </table>

    <div id="tbImage">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true," onclick="addImage()">添加</a>

    </div>

    <div id="addImage"></div>

    <div id="updImage"></div>

    <div id="add"></div>
