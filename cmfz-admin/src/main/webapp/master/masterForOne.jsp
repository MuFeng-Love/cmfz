<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<div style="text-align:center;">
	<form id="masterOne" method="post">
		<table>
			<tr>
				<td>大师编号：</td>
				<td><input class="easyui-textbox" name="masterId" data-options="required:true" readonly="readonly"></td>
			</tr>
			<tr>
				<td>大师法号：</td>
				<td><input class="easyui-textbox" name="masterName" data-options="required:true"></td>
			</tr>
			<tr>
				<td>法师照片：</td>
				<td><input class="easyui-textbox" name="masterPhoto" data-options="required:true"></td>
			</tr>
			<tr>
				<td>大师简介：</td>
				<td><input class="easyui-textbox" name="masterSummary" data-options="required:true"></td>
			</tr>
		</table>
	</form>
</div>