<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
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
			pictureId：<input class="easyui-textbox" name="pictureId" data-options="required:true" readonly="readonly"><br>
			picturePath：<input class="easyui-textbox" name="picturePath" data-options="required:true"><br>
			pictureDate：<input class="easyui-textbox" name="pictureDate" data-options="required:true" readonly="readonly"><br>
			pictureDescription：<input class="easyui-textbox" name="pictureDescription" data-options="required:true"><br>
			pictureStatus：<input class="easyui-textbox" name="pictureStatus" data-options="required:true"><br>
		</form>
	</div>
</body>
</html>