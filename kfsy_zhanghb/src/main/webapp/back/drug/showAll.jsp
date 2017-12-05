<%@ page pageEncoding="utf-8"  contentType="text/html; utf-8" isELIgnored="false" %>
<script>
    $(function () {

        $("#dgDrug").datagrid({
            url:'${pageContext.request.contextPath}/drug/queryAll',
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
                {title:'药房名称',field:'name',width:200,align:'center',resizable:false},
                {title:'药房图标',field:'logo',width:100,align:'center',resizable:false,
                    formatter:function(value,row,index){
                        return " <img style='height: 50px'  src=\"\\kfsy_zhanghb\\back\\drug\\image\\"+ row.logo +"\"/> ";

                    }
                },
                {title:'药房地址',field:'address',width:200,align:'center',resizable:false},
                {title:'药房简介',field:'content',width:200,align:'center',resizable:false},
                {title:'操作',field:'o',width:200,align:'center',resizable:false,
                    formatter:function(value,row,index){

                        return "<a class='del' onclick=\"delDrug('"+row.id+"')\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "<a class='upd' onclick=\"updDrug('"+row.id+"')\">修改</a>"

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

    function addDrug() {
        $("#addDrug").dialog({
            title:'添加信息',
            width:400,
            height:300,
            draggable:false,
            iconCls:'icon-man',
            href:'${pageContext.request.contextPath}/back/drug/addDrug.jsp',
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                handler:function () {
                    $("#addDrugForm").form('submit',{
                        url:'${pageContext.request.contextPath}/drug/addDrug',
                        onSubmit:function () {
                            return $("#addDrugForm").form("validate");
                        },
                        success:function (data) {

                            $.messager.show({
                                title:'提示',
                                msg:"成功",
                            });

                            $("#addDrug").dialog('close',true);
                            $("#dgDrug").datagrid('reload');
                        },

                    })
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function () {
                    $("#dgDrug").dialog('close');
                }
            }],


        });
    }

    function delDrug(id) {

        $.messager.confirm('提示','确定要删除吗?',function (r) {
            if(r){
                $.post('${pageContext.request.contextPath}/drug/removeOne',{"id":id},function(result){

                    $.messager.show({
                        title:'提示',
                        msg:result.msg,
                    });

                    $("#dgDrug").datagrid('reload');

                },"JSON");
            }
        })
    }

    function updDrug(id) {
        $("#updDrug").dialog({
            title:'修改用户状态',
            iconCls:'icon-man',
            draggable:false,
            width:400,
            height:300,
            href:'${pageContext.request.contextPath}/back/drug/editDrug.jsp?id='+id ,
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                handler:function () {
                    $("#updDrugForm").form('submit',{
                        url:'${pageContext.request.contextPath}/drug/modifyOne',
                        onSubmit:function () {
                            return $("#updDrugForm").form("validate");
                        },
                        success:function (data) {
                            $.messager.show({
                                title:'提示',
                                msg:'修改状态成功...',
                            });

                            $("#updDrug").dialog('close',true);
                            $("#dgDrug").datagrid('reload');
                        },

                    })
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function () {
                    $("#updDrug").dialog('close');
                }
            }],

        });
    };

</script>

    <table id="dgDrug">


    </table>

    <div id="tbDrug">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true," onclick="addDrug()">添加</a>

    </div>

    <div id="addDrug"></div>

    <div id="updDrug"></div>

    <div id="add"></div>
