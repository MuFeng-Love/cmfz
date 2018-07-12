<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $("#MasterEasyPoiFb").filebox({
            buttonText: '选择文件',
            buttonAlign: 'right',
            accept:"application/vnd.ms-excel,application/x-xls,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
        });
        $("#MasterEasyPoiSub").linkbutton({
            text : "提交",
            onClick : function() {
                $("#MasterEasyPoiForm").form("submit",{
                    url : '${pageContext.request.contextPath}/masPoi/excelImport',
                    onSubmit : function() {
                        console.log("提交前执行");
                        return $("#MasterEasyPoiForm").form("validate");
                    },
                    success : function(data) {
                        if(data=="success"){
                            $.messager.alert("提示","添加成功！");
                        } else {
                            $.messager.alert("提示","添加失败！");
                        }
                        $("#MasterEasyPoiDiv").dialog("close",true);
                        $("#master").datagrid('reload');
                        $("#transaction").datagrid("reload");
                    }
                });
            }
        });
        $("#MasterCanaleEasyPoiSub").linkbutton({
            text : "取消",
            onClick: function () {
                $("#MasterEasyPoiDiv").dialog("close",true);
            }
        })
    });
</script>
<form id="MasterEasyPoiForm" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>批量插入文件：</td>
            <td><input id="MasterEasyPoiFb" name="file" type="text"></td>
        </tr>
        <tr style="align-items: center;">
            <td><a id="MasterEasyPoiSub"></a></td>
            <td><a id="MasterCanaleEasyPoiSub"></a></td>
        </tr>
    </table>
</form>
