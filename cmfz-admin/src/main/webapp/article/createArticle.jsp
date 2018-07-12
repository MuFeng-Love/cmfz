<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
       $("#articleTitle").textbox({
           required : true,
           validateOnCreate : false,
           validateOnBlur : true,
           prompt : "请输入文章标题"
       });

       $("#articleAuthor").combobox({
           url : '${pageContext.request.contextPath}/article/author',
           valueField : 'masterName',
           textField : 'masterName'
       });

       $("#Submit").linkbutton({
           text:"创建文章",
           onClick : function () {
               $("#articleForm").form("submit",{
                   url : '${pageContext.request.contextPath}/article/create',
                   onSubmit : function (param) {
                       console.log("正在提交");
                       param.introduction = editor.txt.html();
                       return $("#articleForm").form("validate");
                   },
                   success : function (data) {
                       if (data == "success" ){
                           $.messager.show({
                               title:'我的信息',
                               msg:'一篇文章创建成功。',
                               timeout:2000,
                               showType:'slide'
                           });
                           editor.txt.clear();
                           document.getElementById("articleForm").reset();
                           $("#transaction").datagrid("reload");
                       } else {
                           $.messager.show({
                               title:'我的信息',
                               msg:'一篇文章创建失败。',
                               timeout:2000,
                               showType:'slide'
                           });
                           editor.txt.clear();
                           document.getElementById("articleForm").reset();
                           $("#transaction").datagrid("reload");
                       }
                   }
               });
           }
       });

       $("#Reboot").linkbutton({
           text : "重置内容",
           onClick : function () {
               editor.txt.clear();
               document.getElementById("articleForm").reset();
           }
       });
    });

    var edit = window.wangEditor;

    var editor = new edit("#articleEditor");
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload';
    editor.customConfig.uploadImgMaxSize=5*1024*1024;
    editor.customConfig.uploadFileName = 'files';
    editor.create();
</script>


<form id="articleForm" method="post">
    <table>
        <tr>
            <td>文章标题：</td>
            <td><input id="articleTitle" name="articleName"></td>
        </tr>
        <tr>
            <td>文章作者:</td>
            <td><input id="articleAuthor" name="masterName"></td>
        </tr>
    </table>
    <div id="articleEditor"></div>
    <table>
        <tr>
            <td><a id="Submit"></a></td>
            <td><a id="Reboot"></a></td>
        </tr>
    </table>
</form>
