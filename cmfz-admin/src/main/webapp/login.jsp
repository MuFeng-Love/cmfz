<html xmlns="http://www.w3.org/1999/xhtml">
<%@page language="java" contentType="text/html;charset=utf-8" isELIgnored="false" pageEncoding="UTF-8" %>
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"></link>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/common.js"></script>
	<script type="text/javascript">
		var submitForm = false;

		function indexBoxChecked() {
			var box = $("#mgrName").val();
			if (box!=""){
			    $("#isRememberUsername").prop("checked",true);
			}
        }

        function changeIndexBox() {
            var box = $("#mgrName").val();
            if (box=="${mgrName}"){
                $("#isRememberUsername").prop("checked",true);
            }
        }

		function checkCode(){
			var code = $("#enCode").val();
			$.post("<%=request.getContextPath()%>/mgr/checkCode",{code:code},
				function (data) {
					if (data=='success'){
					    submitForm = true;
					    $("#buttonCheck").attr("value","请登录");
					} else {
					    submitForm = false;
                        $("#buttonCheck").attr("value","验证失败");
					}
			});
		}
	
		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
				$("#captchaImage").attr("src","<%=request.getContextPath()%>/vcode?flag="+Math.random());
			});
			
			//  form 表单提交
			$("#loginForm").bind("submit",function(){
				checkCode();
				return submitForm;
			});
		});
	</script>
</head>
<body onload="indexBoxChecked()">
	
		<div class="login">
			<form id="loginForm" action="<%=request.getContextPath()%>/mgr/queryMgr" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="${pageContext.request.contextPath   }/img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text" id="mgrName" name="mgrName" class="text" value="${mgrName}" maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" name="mgrPwd" class="text" value="" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="<%=request.getContextPath()%>/vcode" title="点击更换验证码"/>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
						<td>
							<label>
								<input type="checkbox" id="isRememberUsername" name="remember" value="true" onchange="changeIndexBox()"/> 记住用户名
							</label>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input id="buttonCheck" type="submit" class="loginButton" value="请验证">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>