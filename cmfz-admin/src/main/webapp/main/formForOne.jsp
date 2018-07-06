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
		<form id="formOne" method="post">
			<input class="easyui-textbox" name="pictureId" data-options="label:'pictureId：',required:true" readonly="readonly"><br>
			<input class="easyui-textbox" name="picturePath" data-options="label:'picturePath：',required:true"><br>
			<input class="easyui-textbox" name="pictureDate" data-options="label:'pictureDate：',required:true" readonly="readonly"><br>
			<input class="easyui-textbox" name="pictureDescription" data-options="label:'pictureDescription：',required:true"><br>
			<input class="easyui-textbox" name="pictureStatus" data-options="label:'pictureStatus：',required:true"><br>
		</form>
	</div>
</body>
</html>