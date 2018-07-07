<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="application/javascript">
    $(function () {
        $("#getPic").filebox({
            buttonText:'选择文件',
            accept:"image/jpeg, image/png"
        })
    });
</script>
<div>
	<form id="formAdd" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>上传轮播图：</td>
				<td><input id="getPic" name="myFile" data-options="buttonAlign:'right'"></td>
			</tr>
			<tr>
				<td>轮播图描述：</td>
				<td><input class="easyui-textbox" name="pictureDescription" data-options="required:true"></td>
			</tr>
			<tr>
				<td>轮播图状态：</td>
				<td>
					<select id="addStatu" class="easyui-combobox" name="pictureStatus">
						<option value="已展示">已展示</option>
						<option value="不展示">不展示</option>
					</select>
				</td>
			</tr>
		</table>
	</form>
</div>