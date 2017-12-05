<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){

      $("#updateUserForm").form('load','${pageContext.request.contextPath}/user/queryOne?id=${param.id}');


    });


</script>
<div style="text-align: center">
    <form id="updateUserForm" method="post">
        <input type="hidden" name="id">
        <div style="margin-top: 20px"><input name= "state" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'状态'" /></div>
        <div style="margin-top: 20px"><input type="hidden" name= "phone" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'状态'" /></div>
        <div style="margin-top: 20px"><input type="hidden" name= "username" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'状态'" /></div>
        <div style="margin-top: 20px"><input type="hidden" name= "password" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'状态'" /></div>
        <div style="margin-top: 20px"><input type="hidden" name= "salt" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'状态'" /></div>
        <div style="margin-top: 20px"><input type="hidden" name= "date" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'状态'" /></div>

    </form>

</div>
