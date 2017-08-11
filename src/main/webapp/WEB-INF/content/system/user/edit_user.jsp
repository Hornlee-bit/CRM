<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>编辑用户</title>

<meta name="pragma" content="no-cache">
<meta name="cache-control" content="no-cache">
<meta name="expires" content="0">
<%@include file="../../script.html"%>
</head>

<body >
	<section class="info-section">
		<form id="form" method="post">
			<table>
				<tr>
					<td class="text-title">用户名：</td>
					<td class="text-content">
						<input type="hidden" name="userVO.id" value="${userVO.id }">
						<input type="text" name="userVO.username" value="${userVO.username }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true,validType:'length[6,20]'">
					</td>
				</tr>

				<tr style="display:${empty userVO ? 'table-row' : 'none'};">
					<td class="text-title">密码：</td>
					<td class="text-content">
						<input type="password" name="userVO.password" value="${userVO.password }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true,validType:'length[6,20]'">
					</td>
				</tr>

				<tr>
					<td class="text-title">联系电话：</td>
					<td class="text-content">
						<input type="text" name="userVO.phone" value="${userVO.phone }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true">
					</td>
				</tr>
				<tr>
					<td class="text-title">电子邮箱：</td>
					<td class="text-content">
						<input type="text" name="userVO.email" value="${userVO.email }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true,validType:'email'"></td>
				</tr>
				<tr>
					<td class="text-title">排序编号：</td>
					<td class="text-content">
						<input type="text" name="userVO.sortnum" value="${userVO.sortnum }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true">
					</td>
				</tr>
				<tr>
					<td class="text-title">用户状态：</td>
					<td class="text-content">
						<select name="userVO.status" class="easyui-combobox theme-textbox-radius">
							<option value="1" ${userVO.status==1?"selected":"" }>正常</option>
							<option value="0" ${userVO.status==0?"selected":"" }>禁用</option>
							<option value="2" ${userVO.status==2?"selected":"" }>已删除</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="text-title">描述信息：</td>
					<td class="text-content">
						<textarea class="theme-textbox-radius" rows="5"  cols="20" name="userVO.usernote">${userVO.usernote }</textarea></td>
				</tr>
				<!-- 因为用户关联信息不需要修改，但是如果没有把这些信息传递给服务器端，hibernate对数据进行更新时就会把对应条目设置为null值 -->

				<tr style="display: none;">
					<td colspan="2">
						<input type="hidden" name="userVO.roleIds" value="${userVO.roleIds}"> 
						<input type="hidden" name="userVO.createById" value="${userVO.createById}"> 
						<input type="hidden" name="userVO.createTime" value="${userVO.createTime}">
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
			$("#resetBtn").on("click",function(){
				$("#form").form("reset");
			});
			//保存按钮
			$("#saveBtn").on("click", function() {
                $("#form").form("submit", {
                    url : "system/user/UserAction_saveOrUpdate.action",
                    onSubmit : function() {
                        //对表单进行数据校验,如果未通过校验，返回false，阻止表单提交
                        return $(this).form("validate");

                    },
                    success : function(data) {
                        //data未服务器端返回的字符串数据，eval将字符串数据转换为json对象
                        data = eval("(" + data + ")");
                        var id = $("input[name='userVO.id']").val();

                        if (data.success) {
                            if(id == "" || id == undefined || id == null){
                                $.messager.alert("SUCCESS","添加成功！","info",function () {
                                    parent.closeTopWindow();
                                })
							}
							else {
                                $.messager.alert("SUCCESS", "修改成功！", "info", function () {
                                    parent.closeTopWindow();
                                })
                            }
                        }
                    }
                });
			});
		});
	</script>
</body>
</html>
				