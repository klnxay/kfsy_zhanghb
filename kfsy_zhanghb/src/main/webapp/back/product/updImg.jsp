<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<form id="updImgForm"  method="post" enctype="multipart/form-data">
    <div style="text-align: center; margin-top: 40px">
        修改商品图片:<input class="easyui-filebox" name="file" data-options="required:true,buttonText:'选择文件',buttonAlign:'left'"/>
    </div>
    <input type="text" name="id" hidden value="${param.id}">
</form>
