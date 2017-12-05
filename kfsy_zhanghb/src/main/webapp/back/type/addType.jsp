<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<form id="addTypeForm"  method="post" enctype="multipart/form-data">

    <div style="text-align: center; margin-top: 20px">
        分类名称:<input class="easyui-textbox" name="name" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        分类图标:<input class="easyui-filebox" name="file" data-options="required:true,buttonText:'选择文件'"/>
    </div>


</form>
