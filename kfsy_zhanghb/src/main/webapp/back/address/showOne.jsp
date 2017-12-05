<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<script>
    $(function () {
        $("#queryAddress").form('load','/kfsy_zhanghb/address/queryOneById?id=${param.id}');
    });
</script>

<form id="queryAddress" method="post">

    <div style="text-align: center; margin-top: 20px">
        地址:<input class="easyui-textbox" name="address" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        姓名:<input class="easyui-textbox" name="name" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        性别:<input class="easyui-textbox" name="sex" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        小区:<input class="easyui-textbox" name="addr" data-options="required:true"/>
    </div>

</form>
