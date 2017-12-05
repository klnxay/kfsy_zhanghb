<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<form id="addThemsForm"  method="post" enctype="multipart/form-data">

    <div style="text-align: center; margin-top: 20px">
        主题名称:<input class="easyui-textbox" name="name" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        主题描述:<input class="easyui-textbox" name="description" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        主题图片:<input class="easyui-filebox" name="file" data-options="required:true,buttonText:'选择文件'"/>
    </div>

</form>