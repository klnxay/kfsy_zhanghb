<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<form id="addBrandForm"  method="post" enctype="multipart/form-data">

    <div style="text-align: center; margin-top: 20px">
        品牌名称:<input class="easyui-textbox" name="name" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        品牌图标:<input class="easyui-filebox" name="small" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        品牌图片:<input class="easyui-filebox" name="big" data-options="required:true"/>
    </div>

</form>
