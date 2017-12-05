<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<form id="addDrugForm"  method="post" enctype="multipart/form-data">

    <div style="text-align: center; margin-top: 20px">
        药房名称:<input class="easyui-textbox" name="name" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        药房图标:<input class="easyui-filebox" name="file" data-options="required:true,buttonText:'选择文件'"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        药房地址:<input class="easyui-textbox" name="address" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        药房简介:<input class="easyui-textbox" name="content" data-options="required:true"/>
    </div>

</form></form>
