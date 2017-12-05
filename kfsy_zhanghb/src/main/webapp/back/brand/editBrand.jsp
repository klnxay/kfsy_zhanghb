<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<script>
    $(function () {
        $("#updBrandForm").form('load','${pageContext.request.contextPath}/brand/queryOneById?id=${param.id}');
    });
</script>

<form id="updBrandForm" method="post">
    <div style="text-align: center; margin-top: 20px">
        <input name="id" hidden/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        品牌名称:<input class="easyui-textbox" name="name" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        品牌图标:<input class="easyui-textbox" name="image" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        品牌图片:<input class="easyui-textbox" name="urlImage" data-options="required:true"/>
    </div>
</form>
