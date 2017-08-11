<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发送邮件</title>
    
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<%@include file="../../script.html" %>
	
	
  </head>
  <body style="width:100%;max-width:1000px;padding:30px 60px;">
	<section class="info-section">
		<form id="form" method="post">
			<table>
				<tr>
					<td class="text-title">收件人：</td>
					<td class="text-content">
						<input type="text" name="email.to" 
							class="easyui-textbox theme-textbox-radius" data-options="required:true,validType:'length[2,50]'">
					</td>
				</tr>
				<tr>
					<td class="text-title">邮件主题：</td>
					<td class="text-content">
						<input type="text" name="email.subject" data-options="required:true" class="easyui-textbox theme-textbox-radius">
					</td>
				</tr>
				<tr>
					<td class="text-title">邮件正文：</td>
					<td class="text-content">
						<textarea id="content" name="email.content" rows="5"  cols="20"></textarea></td>
				</tr>
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
		//当页面加载完毕之后初始化在线编辑器
		KindEditor.ready(function(K) {
				//在编辑器初始化成功之后赋值editor变量
                window.editor = K.create("#content",{
                	items:[
				        'source', '|', 'code', 'cut', 'copy', 'paste',
				        'plainpaste', 'wordpaste', '|', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
				         'quickformat', 'selectall', '|',
				        'formatblock', 'fontname', 'fontsize', '|', 'forecolor',  'bold',
				         'underline', '|', 'image', 'multiimage',
				        'flash', 'media','hr', 'emoticons', 'baidumap', 'pagebreak',
				         'link'
						]
                });
        });
        
        //为发送按钮绑定单击事件
        $("#sendBtn").on("click",function(){
        	
        	//在提交之前调用编辑器的同步方法，这样才能获取到textarea中的内容
        	editor.sync();
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