<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<script>
    $(function () {
        $("#type").combobox({
            valueField: 'id',
            textField: 'name',
            url:'${pageContext.request.contextPath}/type/query',
            onLoadSuccess:function(){
                var val = $(this).combobox('getData');

                for (var item in val[0]) {
                    if (item == 'id') {
                        $(this).combobox('select', val[0][item]);
                    }
                }
            }
        })

        $("#drug").combobox({
            valueField: 'id',
            textField: 'name',
            url:'${pageContext.request.contextPath}/drug/query',
            onLoadSuccess:function(){
                var val = $(this).combobox('getData');

                for (var item in val[0]) {
                    if (item == 'id') {
                        $(this).combobox('select', val[0][item]);
                    }
                }
            }
        })

        $("#brand").combobox({
            valueField: 'id',
            textField: 'name',
            url:'${pageContext.request.contextPath}/brand/query',
            onLoadSuccess:function(){
                var val = $(this).combobox('getData');

                for (var item in val[0]) {
                    if (item == 'id') {
                        $(this).combobox('select', val[0][item]);
                    }
                }
            }
        })

        $("#thems").combobox({
            valueField: 'id',
            textField: 'name',
            url:'${pageContext.request.contextPath}/thems/query',
            onLoadSuccess:function(){
                var val = $(this).combobox('getData');

                for (var item in val[0]) {
                    if (item == 'id') {
                        $(this).combobox('select', val[0][item]);
                    }
                }
            }
        })
        $("#updProForm").form('load','${pageContext.request.contextPath}/product/queryOneById?id=${param.id}');
    });
</script>

<form id="updProForm" method="post">

        <input class="easyui-textbox" type="hidden" name="id" data-options="required:true"/>

    <div style="text-align: center; margin-top: 40px">
        名称 :<input class="easyui-textbox" name="name" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        规格 :<input class="easyui-textbox" name="standerd" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        描述 :<input class="easyui-textbox" name="comment" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        原价 :<input class="easyui-textbox" name="oldprice" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        现价 :<input class="easyui-textbox" name="newprice" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        说明书 :<input class="easyui-textbox" name="description" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        折扣 :<input class="easyui-textbox" name="discount" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        特价 :<input class="easyui-textbox" name="offer" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        库存 :<input class="easyui-textbox" name="sum" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        销量 :<input class="easyui-textbox" name="count" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        上架时间 :<input class="easyui-datebox" name="olddate" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        下架时间 :<input class="easyui-datebox" name="newdate" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        状态 :<input class="easyui-textbox" name="state" data-options="required:true"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        <input id="type" name="typeid" class="easyui-combobox" prompt="分类" style="width:115px;height:33px;padding:10px"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        <input id="brand" name="bratoid" class="easyui-combobox" prompt="厂家" style="width:115px;height:33px;padding:10px"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        <input id="thems" name="themsid" class="easyui-combobox" prompt="主题" style="width:115px;height:33px;padding:10px"/>
    </div>

    <div style="text-align: center; margin-top: 20px">
        <input id="drug" name="drugid" class="easyui-combobox" prompt="药店" style="width:115px;height:33px;padding:10px"/>
    </div>
</form>
