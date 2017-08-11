<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>添加员工</title>
	<head>
		<base href="<%=basePath%>">
		<%@include file="../../script.html" %>
		<title>修改员工信息</title>
		<style type="text/css">
			.tl{
				width:100px;
				text-align: right;
				background-color: #ddd
			}
			.tc{
				width: 50px
			}

			input{
				width: 170px;
				height: 32px
			}
			td{
				height: 30px;
				font-size: 14px
			}

		</style>

	</head>

<body>
<div style="padding-left: 30px">
	<form id="form" method="post">
		<br><p style="color:#0a0;font-size: 16px;margin-left: 150px;margin-top: 10px">添加员工信息</p><br>
		<hr style="margin-right: 30px"><br>
		<table cellspacing="10" cellpadding="0" style="margin-left: 70px">
			<tr>
				<td class="tl">员工姓名:</td>
				<td><input type="text" name="emp.name" value="${empVo.name }" class="easyui-textbox theme-textbox-radius"  data-options="required:true"></td>
			</tr>
			<tr>
				<td class="tl">员工性别:</td>
				<td>
					<select name="emp.sex" class="easyui-combobox theme-textbox-radius" style="width:120px">
						<option value="0">请选择性别</option>
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="tl">联系电话:</td>
				<td><input type="text" class="easyui-textbox theme-textbox-radius" value="${empVo.telephone }" data-options="required:true" name="emp.telephone"></td>
			</tr>
			<tr>
				<td class="tl">邮箱:</td>
				<td><input type="text" name="emp.email" value="${empVo.email }"  class="easyui-textbox theme-textbox-radius"></td>
			</tr>
			<tr>
				<td class="tl">地址:</td>
				<td><input name="emp.address" value="${empVo.address }" class="easyui-textbox theme-textbox-radius"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="emp.empid" value="${empVo.empid }"></td>
			</tr>
			<tr>
				<td colspan="2px" style="text-align: center">
					<a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton button-primary">保存</a>&nbsp; &nbsp;&nbsp;&nbsp;
					<a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-danger">重置</a>
				</td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript">
    $(function() {
        //重置按钮
        $("#resetBtn").on("click", function () {
            $("#form").form("reset")
        });
        //为保存按钮添加事件
        $("#saveBtn").on("click",function () {
            $("#form").form("submit", {
                url: "manage/employee/upDateOrSave.action",
                onSubmit: function () {
                    return $("#form").form("validate");
                },

                success: function (data) {
                    var obj = eval("(" + data + ")");
                    if (obj.success) {
                        $.messager.alert("提示", obj.message, "info",function () {
                            parent.closeTopWindow();
                        });
                    }
                }
            });
        });
    });

</script>
</body>
</html>
