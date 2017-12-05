<%@page contentType="text/html; UTF-8"  pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){

        $("#pforss").form('load','/kfsy/priviu/byid?id=${param.id}');
        //$("#updateUserForm").form('load','/easyui_day3/datagrid/queryOne.json');

    });
</script>


<div style="margin-top: 16%">
    <form method="post" id="pforss">

        <div align="center">
            <div style="width:35%;float:left" align="right">编号：</div>
            <div style="width:65%;float:left" align="left">
                <input class="easyui-textbox" name="id" data-options="readonly:true">
            </div>

        </div>
        <div align="center">
            <div style="width:35%;float:left" align="right">打折优惠：</div>
            <div style="width:65%;float:left" align="left">
                <input class="easyui-textbox" name="name" data-options="readonly:true">
            </div>

        </div>
        <div align="center">
            <div style="width:35%;float:left" align="right">优惠券：</div>
            <div style="width:65%;float:left" align="left">
                <input class="easyui-textbox" name="price" data-options="readonly:true">
            </div>

        </div>
        <div align="center">
            <div style="width:35%;float:left" align="right">数量：</div>
            <div style="width:65%;float:left" align="left">
                <input class="easyui-textbox" name="num" data-options="required:true">
            </div>

        </div>
        <div align="center">
            <div style="width:35%;float:left" align="right">状态：</div>
            <div style="width:65%;float:left" align="left">
                <select id="cc" class="easyui-combobox" name="state" data-options="required:true"  style="width:162px;">

                <option>激活</option>
                    <option>冻结</option>
                </select>
            </div>

        </div>

    </form>
</div>