
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <meta name="viewport" content="width=device-width"/>

        <link rel="stylesheet" type="text/css" href="/kfsy_zhanghb/back/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="/kfsy_zhanghb/back/easyui/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="/kfsy_zhanghb/back/easyui/themes/IconExtension.css">
        <link rel="stylesheet" type="text/css" href="/kfsy_zhanghb/back/kindeditor/themes/default/default.css" />
        <link rel="stylesheet" type="text/css" href="/kfsy_zhanghb/back/kindeditor/plugins/code/prettify.css" />
        <script type="text/javascript" src="/kfsy_zhanghb/back/easyui/js/jquery.min.js"></script>
        <script type="text/javascript" src="/kfsy_zhanghb/back/easyui/js/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="/kfsy_zhanghb/back/easyui/js/easyui-lang-zh_CN.js"></script>
        <script type="text/javascript" src="/kfsy_zhanghb/back/easyui/js/jquery-easyui-validater.js"></script>
        <script type="text/javascript" src="/kfsy_zhanghb/back/kindeditor/kindeditor-all.js"></script>
        <script type="text/javascript" src="/kfsy_zhanghb/back/kindeditor/zh-CN.js"></script>
        <script type="text/javascript" src="/kfsy_zhanghb/back/kindeditor/plugins/code/prettify.js"></script>
        <script>
            var $menus,$tt;
            $(function(){
                $menus = $("#menus");
                $tt = $("#tt");
                $.get('/kfsy_zhanghb/back/main/menu1.json',function(result){
                    $.each(result,function(idx,menu){
                        var content = "<div style='text-align: center'>";
                        $.each(menu.children,function(idx,child){
                            var con = child.name +"#"+child.iconCls+"#"+child.href;
                            content += "<div onclick=\"addTags('"+con+"')\" style='width: 90%;margin:5px 0px 5px 0px; border:1px #95B8E7 solid;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\" >"+child.name+"</div><br/>";
                        });
                        content += "<div/>";

                        $menus.accordion('add',{
                            title:menu.name,
                            iconCls:menu.iconCls,
                            content:content,
                        });
                    });
                });

            });
            function addTags(result){
                var con = result.split("#");

                var title = con[0];
                var iconCls = con[1];
                var href = con[2];
                if(!$tt.tabs('exists',title)){
                    $tt.tabs('add',{
                        title:title,
                        iconCls:iconCls,
                        closable:true,
                        href:href,
                        tools:[{
                            iconCls:'icon-reload',
                            handler:function(){
                                var tab = $tt.tabs('getSelected');
                                tab.panel('refresh');
                            }
                        }]
                    });
                }else{
                    $tt.tabs('select',title)
                }
            }

        </script>
    </head>
    <body id="cc" class="easyui-layout">
    <%--头部--%>
    <div id = "hea" data-options="region:'north',split:true,href:'/kfsy_zhanghb/back/main/head.jsp'" style="height:100px;">
    </div>
    <%--尾部--%>
    <div data-options="region:'south',split:true,href:'/kfsy_zhanghb/back/main/foot.jsp'" style="height:100px;"></div>
    <%--左栏--%>
    <div data-options="region:'west',title:'系统菜单',split:true" style="width:200px;">
        <%--用来产生菜单--%>
        <div id="menus" class="easyui-accordion" data-options="fit:true"></div>
    </div>
    <%--中间--%>
    <div id="center" data-options="region:'center',">

        <%--选项卡容器--%>
        <div id="tt" class="easyui-tabs" data-options="fit:true,href:'/kfsy_zhanghb/back/main/show.jsp'"></div>

    </div>

    </body>

</html>
