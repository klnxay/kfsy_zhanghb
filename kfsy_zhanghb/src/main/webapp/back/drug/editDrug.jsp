<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<script>
    $(function () {
        $("#updDrugForm").form('load','/kfsy_zhanghb/drug/queryOneById?id=${param.id}');
    });
</script>

<form id="updDrugForm" method="post">
    <div style="text-align: center; margin-top: 20px">
        <input name="id" hidden/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        药房名称:<input class="easyui-textbox" name="name" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        药房图标:<input class="easyui-filebox" name="logo" data-options="required:true" hidden/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        药房地址:<input class="easyui-textbox" name="address" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        药房简介:<input class="easyui-textbox" name="content" data-options="required:true"/>
    </div>
</form>
