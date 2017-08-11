
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">

	<title>编辑用户</title>

	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<%@include file="../../script.html" %>
</head>

<style type="text/css">
	.myselect{
		height:30px;
	}
</style>

<body >
<section class="info-section">
	<form id="form" method="post">
		<table>
			<tr>
				<td class="text-title">字典类型名：</td>
				<td class="text-content">
					<input type="hidden" name="dictType.id" value="${dictType.id}">
					<input type="hidden" name="dictType.createById" value="">
					<input type="text" name="dictType.typename" value="${dictType.typename}"
						   class="easyui-textbox theme-textbox-radius" data-options="required:true">
				</td>
			</tr>

			<tr>
				<td class="text-title">字典类型编码：</td>
				<td class="text-content">
					<input type="text" name="dictType.typecode" value="${dictType.typecode}"
						   class="easyui-textbox theme-textbox-radius" data-options="required:true">
				</td>
			</tr>
			<tr>
				<td class="text-title">备注：</td>
				<td class="text-content">
					<input type="text" name="dictType.typenote" value="${dictType.typenote}"
						   class="easyui-textbox theme-textbox-radius" data-options="required:true"></td>
			</tr>

			<tr>
				<td class="text-title">排序编号：</td>
				<td class="text-content">
					<input type="text" name="dictType.sortnum" value="${dictType.sortnum}"
						   class="easyui-textbox theme-textbox-radius" data-options="required:true">
				</td>
			</tr>
			<tr>
				<td class="text-title">状态：</td>
				<td class="text-content">
					<select name="dictType.status" class="easyui-combobox theme-textbox-radius">
						<option value="1" >正常</option>
						<option value="0" >禁用</option>
						<option value="2" >已删除</option>
					</select>
				</td>
			</tr>

			<tr>
				<td colspan="2" style="text-align: center;margin-top: 10px;">
					<a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton button-primary">保存</a>
					<a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-danger">重置</a>
				</td>
			</tr>
		</table>
	</form>
</section>
<script type="text/javascript">
    $(function() {
        //重置按钮
        $("#resetBtn").on("click",function(event){
            $("#form").form("reset");
        });
        //保存按钮
        $("#saveBtn").on("click", function(event) {
            $("#form").form("submit", {
                url : "system/dict/DictTypeAction_saveOrUpdate.action",
                onSubmit : function() {
                    //对表单进行数据校验,如果未通过校验，返回false，阻止表单提交
                    return $(this).form("validate");
                },
                success : function(data) {
                    //data未服务器端返回的字符串数据，eval将字符串数据转换为json对象
                    data = eval("(" + data + ")");
                    if (data.success) {
                        $.messager.alert("提示",data.message,"info",function () {
                            parent.closeTopWindow();
                        })
                    }
                }
            });
        });
    });
</script>
</body>
</html>
				