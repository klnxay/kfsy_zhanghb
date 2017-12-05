<%@page contentType="text/html; UTF-8"  pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
        $("#pdb").datagrid({
            url:'${pageContext.request.contextPath}/priviu/all',
            striped:true,
            pagination:true,
            fitColumns:true,
            fit:true,
            pageList:[5,10,20,30,50],
            columns:[[
                {field:'id',title:'编号',width:100},
                {field:'privi_id',title:'优惠券id',width:100},
                {field:'userid',title:'用户id',width:100},
                {field:'num',title:'数量',width:40},
                {field:'state',title:'状态',width:50},
                {field:'price',title:'优惠券价值',width:100},
                {field:'name',title:'优惠券折扣',width:100},
                {field:'odate',title:'生效时期',width:100},
                {field:'ndate',title:'失效时期',width:100},
                {title:'操作',field:"options",width:100,align:"center",
                    formatter:function(value,row,index){
                        return "<a class='del' data-options=\"iconCls:'icon-20130408025545236_easyicon_net_30',plain:true\" onclick=\"deletes('"+row.id+"')\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;"+
                            "<a class='del' data-options=\"iconCls:'icon-edit',plain:true\" onclick=\"update('"+row.id+"')\">修改</a>";
                    }
                }
            ]],
            toolbar: '#ptb',
            onLoadSuccess:function(data){
                $(".del").linkbutton();
            }

        });

    });



    function deletes(ids){
        $("#priviun").dialog({
            width:300,
            height:200,
            title:'删除用户优惠券',
            iconCls:'icon-man',
            href:"/kfsy/back/priviu/form.jsp",
            buttons:[{
                text:'是',
                iconCls:'icon-save',
                onClick:function () {
                    $("#pfor").form('submit',{
                        url:"/kfsy/priviu/remove?id="+ids,
                        success:function (data) {
                            $.messager.alert('消息','您的删除操作成功');
                            $("#pdb").datagrid('reload');
                            $("#priviun").dialog('close');

                        }
                    });
                }
            },{
                text:'否',
                iconCls:'icon-arrow_redo',
                onClick:function () {
                    $("#priviun").dialog('close');
                }
            }],
        });
    }
    function update(ids){
        $("#priviun").dialog({

            width:400,
            height:300,
            title:'修改优惠券信息',
            iconCls:'icon-man',
            href:"/kfsy/back/priviu/forms.jsp?id="+ids,
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                onClick:function () {
                    $("#pforss").form('submit',{
                        url:"/kfsy/priviu/modifi",
                        success:function (data) {
                            $.messager.alert('消息','您的修改操作成功');
                            $("#pdb").datagrid('reload');
                            $("#priviun").dialog('close');

                        }
                    });
                }
            },{
                text:'关闭',
                iconCls:'icon-arrow_redo',
                onClick:function () {
                    $("#priviun").dialog('close');
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

<table id="pdb"></table>


<div id="ptb">

    <input id="ss" class="easyui-searchbox"
           data-options="searcher:qq,prompt:'请输入查询条件....',menu:'#mm',width:400"/>
    <div id="mm" data-options="">
        <div data-options="name:'name',">id</div>
        <div data-options="name:'bir'">userid</div>
    </div>
</div>
