<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list_message.jsp' starting page</title>
    
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
    	<table id="messageList" class="easyui-datagrid"></table>
    	<div id="toolbar">
    		<a href="javascript:void(0)" onclick="return edit('system/message/MessageAction_edit.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add'">写信</a>
    	</div>
  </body>
  <script type="text/javascript">
  	function edit(url){
  		parent.openTopWindow({
  		     width:500,
			 height:600,
			 title:"写信",
  		     url:url,
			 close:function(){
  			   $("#messageList").datagrid("reload")
		     }
  		});
  	}
  	$(function(){
		$("#messageList").datagrid({
			url:"system/message/MessageAction_findByPage.action",
			pagination:true,
			toolbar:"#toolbar",
			fitColumns:true,
			idField:"messageid",
			rownumbers:true,
			columns:[[
			{field:"messageid",title:"选择",checkbox:true},
			{field:"userByTousername",title:"收件人",width:15},
			{field:"userByFromusername",title:"发件人",width:10},
			{field:"content",title:"内容",width:10},
			{field:"readtime",title:"读取时间",width:15},
			{field:"sendtime",title:"发送时间",width:15},
			{field:"status",title:"状态",width:10}
			]],
			loadFilter:function(data){
				return {"total":data.data.totalRows,"rows":data.data.list}
			}
		})  	
  	})
  </script>
</html>
