<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<div style="text-align:center;">
	<form id="formOne" method="post">
		<table>
			<tr>
				<td>轮播图编号：</td>
				<td><input class="easyui-textbox" name="pictureId" data-options="required:true" readonly="readonly"></td>
			</tr>
			<tr>
				<td>轮播图名：</td>
				<td><input class="easyui-textbox" name="picturePath" data-options="required:true"></td>
			</tr>
			<tr>
				<td>创建时间：</td>
				<td><input class="easyui-textbox" name="pictureDate" data-options="required:true" readonly="readonly"></td>
			</tr>
			<tr>
				<td>轮播图描述：</td>
				<td><input class="easyui-textbox" name="pictureDescription" data-options="required:true"></td>
			</tr>
			<tr>
				<td>轮播图状态：</td>
				<td><input class="easyui-textbox" name="pictureStatus" data-options="required:true" readonly="readonly"></td>
			</tr>
		</table>
	</form>
</div>