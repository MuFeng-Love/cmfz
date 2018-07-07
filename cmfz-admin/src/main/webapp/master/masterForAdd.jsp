<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<script type="application/javascript">
    $(function () {
        $("#getMaster").filebox({
            buttonText:'选择文件',
            accept:"image/jpeg, image/png"
        })
    });
</script>
<div style="text-align:center;">
	<form id="masterAdd" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>大师法号：</td>
				<td><input class="easyui-textbox" name="masterName" data-options="required:true"></td>
			</tr>
			<tr>
				<td>法师照片：</td>
				<td><input id="getMaster" name="myFile" data-options="buttonAlign:'right'"></td>
			</tr>
			<tr>
				<td>大师简介：</td>
				<td><input class="easyui-textbox" name="masterSummary" data-options="required:true"></td>
			</tr>
		</table>
	</form>
</div>