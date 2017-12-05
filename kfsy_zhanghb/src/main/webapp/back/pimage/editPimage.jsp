<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<form id="uptPimageForm"  method="post" enctype="multipart/form-data">
    <div style="text-align: center; margin-top: 20px">
        <input class="easyui-textbox" type="hidden" name="id" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        <input class="easyui-textbox" type="hidden" name="image" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        <input class="easyui-textbox" type="hidden" name="proid" data-options="required:true"/>
    </div>
    <div style="text-align: center; margin-top: 20px">
        状态 :<input class="easyui-textbox" name="state" data-options="required:true"/>
    </div>
    <input type="text" name="id" hidden>
</form>
