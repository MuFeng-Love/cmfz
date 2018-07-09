<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    //自定义下拉框必须有JS来实现
    $(function(){
        $("#fm").datagrid({
            url:"http://localhost:8088/admin/pic/searchAll",
            pagination:true,
            pageList:[5,8,10,15],
            pageSize:5,
            toolbar:"#tb",
            fitColumns:true,
            singleSelect:true,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.picturePath +'" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.picturePath + '</p>' +
                    '<p>Status: ' + rowData.pictureStatus + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });


        $("#add").linkbutton({
            onClick:function(){
                console.log("------come in -----");
                $("#dialog").dialog({
                    title:"新增轮播图",
                    width:450,
                    height:300,
                    collapsible:true,
                    minimizable:true,
                    maximizable:true,
                    resizable:true,

                    toolbar:[{
                        text:"帮助",
                        iconCls:"icon-help",
                        handler:function(){
                            alert("自救吧，亲！！！");
                        }
                    }],

                    buttons:[{
                        text:"提交",
                        iconCls:"icon-ok",
                        handler:function(){
                            $("#formAdd").form("submit",{
                                url:"http://localhost:8088/admin/pic/create",
                                onSubmit:function(){
                                    return true;
                                },
                                success:function(data){
                                    $("#dialog").dialog("close");
                                    $("#fm").datagrid({
                                        url:"http://localhost:8088/admin/pic/searchAll",
                                        toolbar:"#tb",
                                        fitColumns:true,
                                        singleSelect:true,
                                        pagination:true,
                                        pageList:[5,8,10,15]
                                    });
                                }
                            });
                        }
                    },{
                        text:"取消",
                        iconCls:"icon-cancel",
                        handle:function(){
                            $("#dialog").dialog("close");
                        }
                    }],
                    href:"${pageContext.request.contextPath}/main/formForAdd.jsp"
                });
            }
        });

        $("#update").linkbutton({
            onClick:function(){
                console.log("------come in -----");
                var rowData = $("#fm").datagrid("getSelected");
                console.log(rowData);
                $("#dialog").dialog({
                    title:"更新轮播图",
                    width:450,
                    height:300,
                    collapsible:true,
                    minimizable:true,
                    maximizable:true,
                    resizable:true,
                    toolbar:[{
                        text:"帮助",
                        iconCls:"icon-help",
                        handler:function(){
                            alert("自救吧，亲！！！");
                        }
                    }],
                    buttons:[{
                        text:"提交",
                        iconCls:"icon-ok",
                        handler:function(){
                            $("#formOne").form("submit",{
                                url:"http://localhost:8088/admin/pic/change",
                                onSubmit:function(){
                                    return true;
                                },
                                success:function(data){
                                    $("#dialog").dialog("close");
                                    $("#fm").datagrid({
                                        url:"http://localhost:8088/admin/pic/searchAll",
                                        toolbar:"#tb",
                                        fitColumns:true,
                                        singleSelect:true,
                                        pagination:true,
                                        pageList:[5,8,10,15]
                                    });
                                }
                            });
                        }
                    },{
                        text:"取消",
                        iconCls:"icon-cancel",
                        handle:function(){
                            $("#dialog").dialog("close");
                        }
                    }],
                    href:"${pageContext.request.contextPath}/main/formForOne.jsp",
                    onLoad:function(){
                        $("#formOne").form("load",rowData);
                    }
                });
            }
        });

    })
</script>

<table id="fm" style="width:100%;height:100%">
    <thead>
    <tr>
        <th data-options="field:'pictureId',width:115,align:'center'">id</th>
        <th data-options="field:'picturePath',width:50,align:'center'">图片名</th>
        <th data-options="field:'pictureDate',width:100,align:'center'">创建时间</th>
        <th data-options="field:'pictureDescription',width:100,align:'center'">图片描述</th>
        <th data-options="field:'pictureStatus',width:50,align:'center'">图片状态</th>
    </tr>
    </thead>
</table>
<div id="tb" style="display: none">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改'" id="update"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增'" id="add"></a>
</div>

<div id="dialog"></div>