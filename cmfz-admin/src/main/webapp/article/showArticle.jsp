<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    //自定义下拉框必须有JS来实现
    $(function(){
        $("#formArticle").datagrid({
            url:"http://localhost:8088/admin/article/showAll",
            pagination:true,
            pageList:[2,4,5,8,10],
            pageSize:2,
            fitColumns:true,
            singleSelect:true,
            columns:[[
                {field:'articleId',title:'id',align:'right',width:50,sortable:true},
                {field:'articleName',title:'文章名',width:100,sortable:true},
                {field:'masterName',title:'作者名',width:50,sortable:true},
                {field:'date',title:'文章创建日期',width:100,sortable:true},
                {
                    field:' ',
                    title:'文章操作',
                    formatter:function (articleId,row,index) {
                        return "<a class='loan_ct_article_details_button' onclick=\"articleDesc('" + row.articleId + "') \"></a>";
                    }
                }
            ]],
            onLoadSuccess:function (data) {
                $(".loan_ct_article_details_button").linkbutton({
                    text:'详情',
                    plain:false,
                    width:50,
                    iconCls:'icon-user_green'
                })
            }
        });
    });

    function articleDesc(articleId) {
        $("#articleDesc").dialog({
            title:'文章详情',
            maximizable:true,
            width:250,
            height:550,
            resizable:true,
            onLoad:function () {
                $.get("${pageContext.request.contextPath}/article/getIntroduction",{articleId:articleId},
                    function (data) {
                        $("#showArticleDesc").html(data);
                    });
            },
            href:'${pageContext.request.contextPath}/article/articleDesc.jsp'
        });
    }
</script>

<table id="formArticle" style="width:100%;height:100%"></table>
<div id="articleDesc"></div>