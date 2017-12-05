<%@page contentType="text/html; UTF-8"  pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
        $("#udb").datagrid({
            url:'${pageContext.request.contextPath}/userAtten/all',
            striped:true,
            pagination:true,
            fitColumns:true,
            fit:true,
            pageList:[5,10,20,30,50],
            columns:[[
                {field:'id',title:'编号',width:100},
                {field:'uid',title:'用户id',width:100},
                {field:'pid',title:'商品id',width:100},
                {title:'操作',field:"options",width:200,align:"center",
                    formatter:function(value,row,index){
                        return "<a class='del' data-options=\"iconCls:'icon-20130408025545236_easyicon_net_30',plain:true\" onclick=\"deletes('"+row.id+"')\">删除</a>";
                    }
                }
            ]],
            toolbar: '#utb',
            onLoadSuccess:function(data){
                $(".del").linkbutton();
            }

        });

    });


    function deletes(ids){

        $("#userattenn").dialog({

            width:300,
            height:200,
            title:'删除关注信息',
            iconCls:'icon-man',
            href:"/kfsy/back/useratten/form.jsp",
            buttons:[{
                text:'是',
                iconCls:'icon-save',
                onClick:function () {
                    $("#ufor").form('submit',{
                        url:"${pageContext.request.contextPath}/userAtten/remove?id="+ids,
                        success:function (data) {
                            $.messager.alert('消息','您的删除操作成功');
                            $("#udb").datagrid('reload');
                            $("#userattenn").dialog('close');
                        }
                    });
                }
            },{
                text:'否',
                iconCls:'icon-arrow_redo',
                onClick:function () {
                    $("#userattenn").dialog('close');
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

<table id="udb"></table>


<div id="utb">
    <%--搜索框--%>
    <input id="ss" class="easyui-searchbox"
           data-options="searcher:qq,prompt:'请输入查询条件....',menu:'#mm',width:400"/>
    <div id="mm" data-options="">
        <div data-options="name:'name',">id</div>
        <div data-options="name:'bir'">userid</div>
    </div>
</div>
