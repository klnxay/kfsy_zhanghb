<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<script>
    $(function () {
        $("#updImageForm").form('load','/kfsy_zhanghb/image/queryOneById?id=${param.id}');
    });
</script>

<form id="updImageForm" method="post" enctype="multipart/form-data">
    <div style="text-align: center; margin-top: 20px">
        <input name="id" hidden/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        药房图片:<input class="easyui-textbox" name="image" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        药房名称:<input class="easyui-textbox" name="drugId" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        图片状态:<input class="easyui-textbox" name="state" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        图片类型:<input class="easyui-textbox" name="type" data-options="required:true"/>
    </div>
</form>
