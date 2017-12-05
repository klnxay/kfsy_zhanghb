<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<form id="addPimgForm"  method="post" enctype="multipart/form-data">
    <div style="text-align: center; margin-top: 40px">
        添加商品轮播图:<input class="easyui-filebox" name="file" data-options="required:true,buttonText:'选择文件',buttonAlign:'left'"/>
    </div>
    <input type="text" name="proid" hidden value="${param.id}">
</form>
