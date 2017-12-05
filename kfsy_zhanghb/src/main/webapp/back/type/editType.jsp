<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<script>
    $(function () {
        $("#updTypeForm").form('load','${pageContext.request.contextPath}/type/queryOneById?id=${param.id}');
    });
</script>

<form id="updTypeForm" method="post">
    <div style="text-align: center; margin-top: 20px">
        <input name="id" hidden/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        分类名称:<input class="easyui-textbox" name="name" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        分类图标:<input class="easyui-textbox" name="image" data-options="required:true"/>
    </div>
</form>
