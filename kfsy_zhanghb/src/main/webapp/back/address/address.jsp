<%@page contentType="text/html; UTF-8"  pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
        $("#adb").datagrid({
            url:'${pageContext.request.contextPath}/address/queryAll',
            striped:true,
            pagination:true,
            fitColumns:true,
            fit:true,
            pageNumber: 1,
            pageSize: 5,//pageSize的取值必须是pageList数组中的一个元素
            pageList: [5, 10, 15, 20, 500],
            columns:[[
                {field:'id',title:'编号',width:60},
                {field:'address',title:'地址',width:50},
                {field:'name',title:'名字',width:50},
                {field:'sex',title:'性别',width:100},
                {field:'addr',title:'详细地址',width:80},
                {field:'userid',title:'用户编号',width:50},

            ]],
            toolbar: '#atb'
        });

    });



    function qq(value,name){


    }
</script>

<table id="adb"></table>

<%--工具栏--%>
<div id="atb">
    <%--搜索框--%>
    <input class="easyui-searchbox" data-options="searcher:qq,prompt:'请输入查询条件....',menu:'#mmm',width:400"/>
    <div id="mmm">
        <div data-options="name:'name',">姓名</div>
    </div>
</div>




</div>
