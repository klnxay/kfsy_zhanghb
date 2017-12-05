<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<script>
    $(function () {
        $("#updImageForm").form('load','/kfsy_zhanghb/image/queryOneById?id=${param.id}');
    });
</script>

<form id="updImageForm" method="post">
    <div style="text-align: center; margin-top: 20px">
        <input name="id" hidden/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        药房图片:<input class="easyui-filebox" name="file" data-options="required:true,buttonText:'选择文件'" hidden/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        药房编号:<input class="easyui-textbox" name="drugid" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        状态:<input class="easyui-textbox" name="state" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        类型:<input class="easyui-textbox" name="type" data-options="required:true"/>
    </div>
</form>
