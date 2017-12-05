<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<script>
    $(function () {
        $("#updThemsForm").form('load','${pageContext.request.contextPath}/thems/queryOneById?id=${param.id}');
    });
</script>

<form id="updThemsForm" method="post">
    <div style="text-align: center; margin-top: 20px">
        <input name="id" hidden/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        主题名称:<input class="easyui-textbox" name="name" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        主题描述:<input class="easyui-textbox" name="description" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        主题图片:<input class="easyui-textbox" name="file" data-options="required:true"/>
    </div>
</form>
