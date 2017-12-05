<%@page contentType="text/html; UTF-8"  pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){
        $("#sforss").form('load','/kfsy/services/sel?id=${param.id}');
        //$("#updateUserForm").form('load','/easyui_day3/datagrid/queryOne.json');

    });
</script>


<div style="margin-top: 16%">
    <form method="post" id="sforss">
        <div align="center">
            <div style="width:35%;float:left" align="right">编号：</div>
            <div style="width:65%;float:left" align="left">
                <input class="easyui-textbox" name="id" data-options="readonly:true">
            </div>

        </div>
        <div align="center" style="margin-top: 20px">
            <div style="width:35%;float:left" align="right">服务评价标签：</div>
            <div style="width:65%;float:left" align="left" >
                <input class="easyui-textbox" name="name" data-options="required:true">
            </div>
        </div>
    </form>
</div>