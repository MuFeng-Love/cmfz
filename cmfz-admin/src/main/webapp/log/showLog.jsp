<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    //自定义下拉框必须有JS来实现
    $(function(){
        $("#transaction").datagrid({
            url:"http://localhost:8088/admin/log/searchAll",
            pagination:true,
            pageList:[5,8,10,15],
            pageSize:5,
            fitColumns:true,
            singleSelect:true
        });
    });
</script>

<table id="transaction" style="width:100%;height:100%">
    <thead>
    <tr>
        <th data-options="field:'logId',width:115,align:'center'">id</th>
        <th data-options="field:'user',width:40,align:'center'">user</th>
        <th data-options="field:'time',width:75,align:'center'">time</th>
        <th data-options="field:'resource',width:60,align:'center'">resource</th>
        <th data-options="field:'action',width:40,align:'center'">action</th>
        <th data-options="field:'message',width:160,align:'center'">message</th>
        <th data-options="field:'result',width:40,align:'center'">result</th>
    </tr>
    </thead>
</table>