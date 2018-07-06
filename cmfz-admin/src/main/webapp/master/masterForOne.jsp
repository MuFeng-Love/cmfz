<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<div style="text-align:center;">
		<form id="masterOne" method="post">
			masterId：<input class="easyui-textbox" name="masterId" data-options="required:true" readonly="readonly"><br>
			masterName：<input class="easyui-textbox" name="masterName" data-options="required:true"><br>
			masterPhoto：<input class="easyui-textbox" name="masterPhoto" data-options="required:true"><br>
			masterSummary：<input class="easyui-textbox" name="masterSummary" data-options="required:true"><br>
		</form>
	</div>
</body>
</html>