<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发送短信</title>
    
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<%@include file="../../script.html" %>
	
	
  </head>
  <body style="width:100%;max-width:500px;padding:30px 60px;">
	<section class="info-section">
		<form id="form" method="post">
			<table>
				<tr>
					<td class="text-title">接收人姓名：</td>
					<td class="text-content">
						<input type="text" name="msgVO.sendtoname" 
							class="easyui-textbox theme-textbox-radius" data-options="required:true,validType:'length[2,50]'">
					</td>
				</tr>
				<tr>
					<td class="text-title">接收人电话：</td>
					<td class="text-content">
						<input type="text" name="msgVO.phone" data-options="required:true" class="easyui-textbox theme-textbox-radius">
					</td>
				</tr>
				<!--  <tr>
					<td class="text-title">信息正文：</td>
					<td class="text-content">
						<textarea id="content" name="msgVO.content" rows="5"  cols="20"></textarea></td>
				</tr>
				-->
				<tr>
					<td colspan="2" style="text-align: center;margin-top: 10px;">
						<a href="javascript:void(0);" id="sendBtn" class="easyui-linkbutton button-primary">发送</a> 
						<a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-danger">重置</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
	<script type="text/javascript">
		
        //为发送按钮绑定单击事件
        $("#sendBtn").on("click",function(){
			//在提交之前调用编辑器的同步方法，这样才能获取到textarea中的内容
			//editor.sync();
			$("#form").form("submit",{

			});
        });
       
	</script>
	<script type="text/javascript">
	 $(function() {
			//重置按钮
			$("#resetBtn").on("click",function(event){
				$("#form").form("reset");
			});
			})
	</script>
</body>
</html>