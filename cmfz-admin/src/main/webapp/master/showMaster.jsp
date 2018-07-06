<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">

    $(function(){
        $("#master").datagrid({
            url:"http://localhost:8088/admin/master/searchAll",
            pagination:true,
            pageList:[2,4,5,8,10],
            pageSize:2,
            toolbar:"#tbMaster",
            fitColumns:true,
            singleSelect:true
        });

        $("#addMaster").linkbutton({
            onClick:function(){
                console.log("------come in -----");
                $("#dialogForMaster").dialog({
                    title:"新增员工",
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
                            $("#masterAdd").form("submit",{
                                url:"http://localhost:8088/admin/master/create",
                                onSubmit:function(){
                                    return true;
                                },
                                success:function(data){
                                    $("#dialogForMaster").dialog("close");
                                    $("#master").datagrid({
                                        url:"http://localhost:8088/admin/master/searchAll",
                                        toolbar:"#tbMaster",
                                        fitColumns:true,
                                        singleSelect:true,
                                        pagination:true,
                                        pageList:[2,4,5,8,10]
                                    });
                                }
                            });
                        }
                    },{
                        text:"取消",
                        iconCls:"icon-cancel",
                        handle:function(){
                            $("#dialogForMaster").dialog("close");
                        }
                    }],
                    href:"${pageContext.request.contextPath}/master/masterForAdd.jsp"
                });
            }
        });

        $("#updateMaster").linkbutton({
            onClick:function(){
                console.log("------come in -----");
                var rowData = $("#master").datagrid("getSelected");
                $("#dialogForMaster").dialog({
                    title:"更新员工",
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
                            $("#masterOne").form("submit",{
                                url:"http://localhost:8088/admin/master/change",
                                onSubmit:function(){
                                    return true;
                                },
                                success:function(data){
                                    $("#dialogForMaster").dialog("close");
                                    $("#master").datagrid({
                                        url:"http://localhost:8088/admin/master/searchAll",
                                        toolbar:"#tbMaster",
                                        fitColumns:true,
                                        singleSelect:true,
                                        pagination:true,
                                        pageList:[2,4,5,8,10]
                                    });
                                }
                            });
                        }
                    },{
                        text:"取消",
                        iconCls:"icon-cancel",
                        handle:function(){
                            $("#dialogForMaster").dialog("close");
                        }
                    }],
                    href:"${pageContext.request.contextPath}/master/masterForOne.jsp",
                    onLoad:function(){
                        $("#masterOne").form("load",rowData);
                    }
                });
            }
        });

        $("#delMaster").linkbutton({
            onClick:function(){
                console.log("------come in -----");
                var rowData = $("#master").datagrid("getSelected");
                $("#dialogForMaster").dialog({
                    title:"删除用户",
                    width:100,
                    height:100,
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
                            $("#masterDel").form("submit",{
                                url:"http://localhost:8088/admin/master/drop",
                                onSubmit:function(){
                                    return true;
                                },
                                success:function(data){
                                    $("#dialogForMaster").dialog("close");
                                    $("#master").datagrid({
                                        url:"http://localhost:8088/admin/master/searchAll",
                                        toolbar:"#tbMaster",
                                        fitColumns:true,
                                        singleSelect:true,
                                        pagination:true,
                                        pageList:[2,4,5,8,10]
                                    });
                                }
                            });
                        }
                    },{
                        text:"取消",
                        iconCls:"icon-cancel",
                        handle:function(){
                            $("#dialogForMaster").dialog("close");
                        }
                    }],
                    href:"${pageContext.request.contextPath}/master/formForDel.jsp",
                    onLoad:function(){
                        $("#masterDel").form("load",rowData);
                    }
                });
            }
        });

    });

    //模糊查询
    function qq(value, name) {
        $("#master").datagrid({
            url:"http://localhost:8088/admin/master/searchSome?value="+value+"&name="+name,
            pagination:true,
            pageList:[2,4,5,8,10],
            pageSize:2,
            toolbar:"#tbMaster",
            fitColumns:true,
            singleSelect:true
        });
    }
</script>
<table id="master" style="width:100%;height:100%">
    <thead>
    <tr>
        <th data-options="field:'masterId',width:50,align:'center'">id</th>
        <th data-options="field:'masterName',width:100,align:'center'">上师法名</th>
        <th data-options="field:'masterPhoto',width:100,align:'center'">上师照片地址</th>
        <th data-options="field:'masterSummary',width:100,align:'center'">上师简述</th>
    </tr>
    </thead>
</table>
<div id="tbMaster" style="display: none">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改'" id="updateMaster"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增'" id="addMaster"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'删除'" id="delMaster"></a>
    <input id="ss" class="easyui-searchbox" style="width:300px" data-options="searcher:qq,prompt:'请输入查询内容',menu:'#mm'"></input>
    <div id="mm" style="width:120px">
        <div data-options="name:'masterName',iconCls:'icon-ok'">姓名</div>
    </div>
</div>

<div id="dialogForMaster"></div>
