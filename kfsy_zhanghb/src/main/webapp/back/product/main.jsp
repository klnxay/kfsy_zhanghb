<%@ page pageEncoding="utf-8"  contentType="text/html; utf-8" isELIgnored="false" %>
<script>
    $(function () {

        $("#dgPro").datagrid({
            url:'${pageContext.request.contextPath}/product/queryAll',
            fitColumns:true,
            striped:true,
            fit:true,
            nowrap:true,
            ctrlSelect:true,
            pagination:true,
            pageSize:5,
            pageList:[1,2,3,5],
            columns:[[
                {title:'编号',field:'id',align:'center',resizable:false,width:40},
                {title:'商品名称',field:'name',align:'center',resizable:false,width:40},
                {title:'规格',field:'standerd',align:'center',resizable:false,width:40},
                {title:'描述',field:'comment',align:'center',resizable:false,width:40},
                {title:'原价',field:'oldprice',align:'center',resizable:false,width:40},
                {title:'现价',field:'newprice',align:'center',resizable:false,width:40},
                {title:'说明书',field:'description',align:'center',resizable:false,width:40},
                {title:'打折',field:'discount',align:'center',resizable:false,width:40},
                {title:'特价',field:'offer',align:'center',resizable:false,width:40},
                {title:'销量',field:'sum',align:'center',resizable:false,width:40},
                {title:'库存',field:'count',align:'center',resizable:false,width:40},
                {title:'图片',field:'image',align:'center',resizable:false,width:40,
                    formatter:function(value,row,index){
                        return " <img style='height: 50px'  src=\"\\kfsy_zhanghb\\back\\product\\image\\"+ row.image +"\"/> ";

                    }
                },
                {title:'上架时间',field:'olddate',align:'center',resizable:false,width:60},
                {title:'下架时间',field:'newdate',align:'center',resizable:false,width:60},
                {title:'状态',field:'state',align:'center',resizable:false,width:40},
                {title:'分类',field:'type',align:'center',resizable:false,formatter: function(value,row,index){
                    return row.type.name;},width:40},
                {title:'公司',field:'brandTopics',align:'center',resizable:false,formatter: function(value,row,index){
                    return row.brandTopics.name;},width:40},
                {title:'主题',field:'thems',align:'center',resizable:false,formatter: function(value,row,index){
                    return row.thems.name;},width:40},
                {title:'药房',field:'drug',align:'center',resizable:false,formatter: function(value,row,index){
                    return row.drug.name;},width:40},
                {title:'操作',field:'o',align:'center',width:300,resizable:false,
                    formatter:function(value,row,index){

                        return "<a class='del' onclick=\"addPimg('"+row.id+"')\">添加轮播图</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "<a class='del' onclick=\"updImg('"+row.id+"')\">修改商品图片</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "<a class='del' onclick=\"delPro('"+row.id+"')\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "<a class='upd' onclick=\"updPro('"+row.id+"')\">修改</a>"

                    }
                }
            ]],
            toolbar:'#tbPro',
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

    function addPimg(id) {
        $("#addPimg").dialog({
            title:'添加轮播图',
            width:400,
            height:300,
            draggable:false,
            iconCls:'icon-man',
            href:'${pageContext.request.contextPath}/back/product/addPimg.jsp?id='+id,
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                handler:function () {
                    $("#addPimgForm").form('submit',{
                        url:'${pageContext.request.contextPath}/pimage/addPimage',
                        onSubmit:function () {
                            return $("#addPimgForm").form("validate");
                        },
                        success:function (data) {

                            $.messager.show({
                                title:'提示',
                                msg:"成功",
                            });

                            $("#addPimg").dialog('close',true);
                        },

                    })
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function () {
                    $("#addPro").dialog('close');
                }
            }],
        })
    }


    function updImg(id) {
        $("#updImg").dialog({
            title:'修改图片',
            width:400,
            height:300,
            draggable:false,
            iconCls:'icon-man',
            href:'${pageContext.request.contextPath}/back/product/updImg.jsp?id='+id,
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                handler:function () {
                    $("#updImgForm").form('submit',{
                        url:'${pageContext.request.contextPath}/product/editPimg',
                        onSubmit:function () {
                            return $("#updImgForm").form("validate");
                        },
                        success:function (data) {

                            $.messager.show({
                                title:'提示',
                                msg:"成功",
                            });

                            $("#updImg").dialog('close',true);
                            $("#dgPro").datagrid('reload');
                        },

                    })
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function () {
                    $("#addPro").dialog('close');
                }
            }],


        });
    }

    function addPro() {
        $("#addPro").dialog({
            title:'添加商品',
            width:400,
            height:300,
            draggable:false,
            iconCls:'icon-man',
            href:'${pageContext.request.contextPath}/back/product/addPro.jsp',
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                handler:function () {
                    $("#addProForm").form('submit',{
                        url:'${pageContext.request.contextPath}/product/addProduct',
                        onSubmit:function () {
                            return $("#addProForm").form("validate");
                        },
                        success:function (data) {

                            $.messager.show({
                                title:'提示',
                                msg:"成功",
                            });

                            $("#addPro").dialog('close',true);
                            $("#dgPro").datagrid('reload');
                        },

                    })
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function () {
                    $("#addPro").dialog('close');
                }
            }],


        });
    }


    function delPro(id) {

        $.messager.confirm('提示','确定要删除吗?',function (r) {
            if(r){
                $.post('${pageContext.request.contextPath}/product/removeOne',{"id":id},function(result){

                    $.messager.show({
                        title:'提示',
                        msg:result.msg,
                    });

                    $("#dgPro").datagrid('reload');

                },"JSON");
            }
        })
    }

    function updPro(id) {
        $("#updPro").dialog({
            title:'修改用户状态',
            iconCls:'icon-man',
            draggable:false,
            width:400,
            height:300,
            href:'${pageContext.request.contextPath}/back/product/editPro.jsp?id='+id ,
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                handler:function () {
                    $("#updProForm").form('submit',{
                        url:'${pageContext.request.contextPath}/product/modifyOne',
                        onSubmit:function () {
                            return $("#updProForm").form("validate");
                        },
                        success:function (data) {
                            $.messager.show({
                                title:'提示',
                                msg:'修改状态成功...',
                            });

                            $("#updPro").dialog('close',true);
                            $("#dgPro").datagrid('reload');
                        },

                    })
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function () {
                    $("#updPro").dialog('close');
                }
            }],

        });
    };

</script>

<table id="dgPro">


</table>

<div id="tbPro">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true," onclick="addPro()">添加</a>
    <input id="ss" class="easyui-searchbox"
           data-options="searcher:ss,Prompt:'请输入查询条件....',menu:'#mm',width:400"/>
    <div id="mm" data-options="">
        <div data-options="name:'name',">药品名</div>
        <div data-options="name:'state'">状态</div>
    </div>
</div>

<div id="addPro"></div>

<div id="updPro"></div>

<div id="add"></div>

<div id="addPimg"></div>

<div id="updImg"></div>