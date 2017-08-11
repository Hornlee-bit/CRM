<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add_dept.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="../../script.html" %>
	<style type="text/css">
		table{
			margin:auto;
		}
		input[type="text"]{
			width:85%;
			height:30px;
			border:0.5px solid gray;
		}
		#select{
			width:85%;
			height:30px;
			border:0.5px solid gray;
		}
	
		td:only-child{
			text-align:center;
			
		}
	</style>

  </head>
  
  <body> 
    <div id="div1">
    	<form  method="post" id="form">
    		<table>
    			<tr>
    				<td>部门名称:</td>
    				<td>
    					<input type="text" name="deptVO.name" value="${deptVO.name}">
    					<input type="hidden" value="${deptVO.departmentid}" name="deptVO.departmentid">
    				</td>
    			</tr>
    			<tr>
    				<td>上级部门:</td>
    				<td>
    					<select name="deptVO.deptParentId" id="select">
    						<option value="-1">请选择上级部门</option>
							<c:forEach items="${list}" var="dept" >
								<option value="${dept.departmentid}"
										<c:if test="${deptVO.deptParentId eq dept.departmentid}">selected</c:if>
								>${dept.name}</option>
							</c:forEach>
    					</select>    					
    				</td>
    			</tr>
    			<tr>
    				<td>部门描述:</td>
    				<td><textarea  cols="50" rows="5" name="deptVO.description">${deptVO.description}</textarea></td>
    			</tr>
    			<tr>
    				<td colspan="2" style="text-align: center;margin-top: 10px;">
						<a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton button-save">保存</a> 
						<a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-reset">重置</a>
					</td>
    			</tr>    			
    		</table>
    	</form>
    </div>
  </body>
  <script type="text/javascript">
  	$(function() {
		//重置按钮
		$("#resetBtn").on("click",function(event){
            $("#form").form("reset");
		});
		//保存按钮
		$("#saveBtn").on("click", function(event) {

            $("#form").form("submit", {
                url : "manage/position/DepartmentAction_saveOrUpdate.action",
                onSubmit : function() {
                    //对表单进行数据校验,如果未通过校验，返回false，阻止表单提交
                    return $(this).form("validate");
                },
                success : function(data) {
                    var obj = eval("("+data+")");
                    if(obj.success){
                        $.messager.alert("SUCCESS",obj.message,"info",function () {
                            parent.closeTopWindow();
                        });
                    }else{
                        $.messager.alert("警告",obj.message);
                    }
                }
            });
		});
	});
  </script>
</html>
