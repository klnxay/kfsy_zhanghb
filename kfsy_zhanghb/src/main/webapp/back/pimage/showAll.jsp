<%@ page pageEncoding="utf-8"  contentType="text/html; utf-8" isELIgnored="false" %>
<script>
    $(function () {

        $("#dgPimage").datagrid({
            url:'${pageContext.request.contextPath}/pimage/queryAll',
            striped:true,
            pagination:true,
            fitColumns:true,
            fit:true,
            pageNumber: 1,
            pageSize: 10,//pageSize的取值必须是pageList数组中的一个元素
            pageList: [5, 10, 15, 20, 500],
            columns:[[
                {title:'编号',field:'id',align:'center',resizable:false,width:40},
                {title:'图片名',field:'image',align:'center',resizable:false,width:40,
                    formatter:function(value,row,index){
                        return " <img style='height: 50px'  src=\"\\kfsy_zhanghb\\back\\pimage\\image\\"+ row.image +"\"/> ";

                    }
                },
                {title:'商品编号',field:'proid',align:'center',resizable:false,width:40},
                {title:'状态',field:'state',align:'center',resizable:false,width:40},
                {title:'操作',field:'oject',align:'center',resizable:false,width:100,
                    formatter:function(value,row,index){

                        return "<a class='del' onclick=\"delPimage('"+row.id+"')\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "<a class='upd' onclick=\"updPimage('"+row.id+"')\">修改状态</a>"

                    }
                }
            ]],
            toolbar:'#tbPimage',
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

    function delPimage(id) {

        $.messager.confirm('提示','确定要删除吗?',function (r) {
            if(r){
                $.post('${pageContext.request.contextPath}/pimage/removeOne',{"id":id},function(result){

                    $.messager.show({
                        title:'提示',
                        msg:result.msg,
                    });

                    $("#dgPimage").datagrid('reload');

                },"JSON");
            }
        })
    }

    function updPimage(id) {
        $("#updPimage").dialog({
            title:'修改用户状态',
            iconCls:'icon-man',
            draggable:false,
            width:400,
            height:300,
            href:'${pageContext.request.contextPath}/back/pimage/editPimage.jsp?id='+id ,
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                handler:function () {
                    $("#uptPimageForm").form('submit',{
                        url:'${pageContext.request.contextPath}/pimage/update',
                        onSubmit:function () {
                            return $("#updPimageForm").form("validate");
                        },
                        success:function (data) {
                            $.messager.show({
                                title:'提示',
                                msg:'修改状态成功...',
                            });

                            $("#updPimage").dialog('close',true);
                            $("#dgPimage").datagrid('reload');
                        },

                    })
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function () {
                    $("#updPimage").dialog('close');
                }
            }],

        });
    };

</script>

    <table id="dgPimage">


    </table>

    <div id="tbPimage"></div>

    <div id="updPimage"></div>



