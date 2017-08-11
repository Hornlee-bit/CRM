<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'debug.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
 <style type="text/css">
	body{
		text-align:center;
		vertical-align:middle;
		background:white;
	}
	#info{
		margin-top:100px;
	}
	h1{
		color:red;
		font-size:50px;
	}
	a{
		color:#FFB6C1;
	}
	a:hover{
		color:yellow;
	}
</style>
<body>
<div id="info">
  <img src="/static/images/nothispage.png"/>
  <h1>您好像没有权限访问链接呢，<a href="javascript:void(0)" onclick="return hisback()">请回吧</a></h1>
  </div>
  <script type="text/javascript">
  	function hisback(){
  		 history.back();
  	}
  </script>
</body>
</html>
