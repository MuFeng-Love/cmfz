<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script type="text/javascript">

    $(function(){
        $("#master").datagrid({
            url:"http://localhost:8088/admin/master/searchAll",
            pagination:true,
            pageList:[5,8,10,15],
            pageSize:5,
            toolbar:"#tbMaster",
            fitColumns:true,
            singleSelect:true,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.masterPhoto +'" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.masterPhoto + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
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
                                        pageList:[5,8,10,15]
                                    });
                                    $.messager.show({
                                        title:'我的信息',
                                        msg:'已增加一位上师信息。',
                                        timeout:2000,
                                        showType:'slide'
                                    });
                                    $("#transaction").datagrid("reload");
                                }
                            });
                        }
                    },{
                        text:"取消",
                        iconCls:"icon-cancel",
                        handler:function(){
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
                if (rowData!=null){
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
                                            pageList:[5,8,10,15]
                                        });
                                        $.messager.show({
                                            title:'我的信息',
                                            msg:'已更新一条记录信息。',
                                            timeout:2000,
                                            showType:'slide'
                                        });
                                        $("#transaction").datagrid("reload");
                                    }
                                });
                            }
                        },{
                            text:"取消",
                            iconCls:"icon-cancel",
                            handler:function(){
                                $("#dialogForMaster").dialog("close");
                            }
                        }],
                        href:"${pageContext.request.contextPath}/master/masterForOne.jsp",
                        onLoad:function(){
                            $("#masterOne").form("load",rowData);
                        }
                    });
                } else {
                    alert('请选择一条记录信息');
                }
            }
        });

        $("#delMaster").linkbutton({
            onClick:function(){
                console.log("------come in -----");
                var rowData = $("#master").datagrid("getSelected");
                if(rowData!= null){
                    $.messager.confirm('确认','您确认要删除这条记录吗？',function (data) {
                        if (data){
                            console.log(data);
                            console.log(rowData);
                            for (var item in rowData){
                                if (item == 'masterId'){
                                    var jValue =rowData[item];
                                    console.log(jValue);
                                    $.post("http://localhost:8088/admin/master/drop",{'masterId':jValue},function (data) {
                                        $("#master").datagrid({
                                            url:"http://localhost:8088/admin/master/searchAll"
                                        });
                                        $.messager.show({
                                            title:'我的信息',
                                            msg:'一条记录信息被删除。',
                                            timeout:5000,
                                            showType:'slide'
                                        });
                                    })
                                }
                            } 
                        }
                    })
                }else{
                    alert('请选择一条记录信息');
                }
            }
        });

        $("#easyPoi").linkbutton({
            iconCls:'icon-add',
            plain:true,
            onClick: function(){
                $('#MasterEasyPoiDiv').dialog({
                    title:'批量插入上师',
                    width:300,
                    height:150,
                    href: '${pageContext.request.contextPath}/master/easyPoiForm.jsp',
                    modal: true,
                });
            }
        });

    });

    //模糊查询
    function qq(value, name) {
        $("#master").datagrid({
            url:"http://localhost:8088/admin/master/searchSome?value="+value+"&name="+name,
            pagination:true,
            pageList:[5,8,10,15],
            pageSize:5,
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
    <shiro:hasPermission name="master:modify">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改'" id="updateMaster"></a>
    </shiro:hasPermission>

    <shiro:hasPermission name="master:add">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增'" id="addMaster"></a>
    </shiro:hasPermission>

    <shiro:hasPermission name="master:drop">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'删除'" id="delMaster"></a>
    </shiro:hasPermission>

    <shiro:hasRole name="root">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'批量上传'" id="easyPoi"></a>
    </shiro:hasRole>
    <input id="ss" class="easyui-searchbox" style="width:300px" data-options="searcher:qq,prompt:'请输入查询内容',menu:'#mm'"></input>
    <div id="mm" style="width:120px">
        <div data-options="name:'masterName',iconCls:'icon-ok'">姓名</div>
    </div>
</div>

<div id="dialogForMaster"></div>
<div id="MasterEasyPoiDiv"></div>