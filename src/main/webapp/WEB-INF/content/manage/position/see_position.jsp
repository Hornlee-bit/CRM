<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>岗位管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="../../script.html" %>

  </head>
  
  <body> 
    <div>
    	<form  method="post" id="form">
    		<table>
    			<tr>
    				<td>岗位名称:</td>
    				<td>
    					<input type="hidden" name="positionVO.positionid" value="${positionVO.positionid }">
    					<input type="text" name="positionVO.name" value="${positionVO.name }">
    				</td>
    			</tr>
    			<tr>
    				<td>所属部门:</td>
    				<td>
    					<select name="positionVO.departmentParentId" id="select2">
    						<option value="-1">请选择所属部门</option>				
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>上级岗位:</td>
    				<td>
    					<select id="select1" name="positionVO.positionParentId">
    						<option value="-1">请选择岗位上级</option>				
    					</select>    					
    				</td>
    			</tr>
    			<tr>
    				<td>岗位描述:</td>
    				<td><textarea  name="positionVO.description">${positionVO.description}</textarea></td>
    			</tr>
    			<tr>
    				<td colspan="2" style="text-align: center;margin-top: 10px;">
						<a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton button-primary">保存</a> 
						<a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-danger">重置</a>
					</td>
    			</tr>    			
    		</table>
    	</form>
    </div>
  </body>
  <script type="text/javascript">
	//重置按钮

	//保存按钮

  </script>
</html>
