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
    
    <title>合同编辑</title>
    
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
		td:nth-child(1){
			text-align:right;			
		}
		td:nth-child(4){
			text-align:right;			
		}
		table{
			margin:auto;
		}
		input[type="text"]{
			width:72.5%;
			height:30px;
			border:0.5px solid gray;
		}
		#select{
			width:72.5%;
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
    				<td>合同编号：</td>
    				<td>
						<input type="hidden" name="contractVO.contractid" value="${contractVO.contractid }">	    				
    					<input type="text" name="contractVO.contractnumber" value="${contractVO.contractnumber }" id="contractNumber" >
    				</td>
    				<td></td>
    				<td>签约时间：</td>
    				<td>
    					<input class="easyui-datetimebox" name="contractVO.duetime" value="${contractVO.duetime }">
    				</td>
    			</tr>
    			<tr>
    				<td>来源商机：(单击选择)</td>
    				<td>
    					<select id="select" name="contractVO.businessid">
    						<option value="-1">请选择商机</option>
    					</select>
    				</td>
    				<td></td>
    				<td>联系人：</td>
    				<td>
    					<input type="text" name="contractVO.businessConnectionName" value="${contractVO.businessConnectionName}" id="businessConnectionName" >
    				</td>
    			</tr>
    			<tr>
    				<td>来源客户：</td>
    				<td><input type="text" name="contractVO.businessCustomerName" id="businessCustomerName" value="${contractVO.businessCustomerName }"></td>
    				<td></td>
    				<td></td>
    				<td></td>
    			</tr>
    			<tr>
    				<td>负责人：
						<input type="hidden" name="contractVO.createUserId" value="${contractVO.createUserId}">
						<input type="hidden" name="contractVO.ownerUserId" id="ownerUserId"></td>
    				<td><input type="text" value="${contractVO.ownerUserName}" id="ownerUserName"></td>
    				<td></td>
    				<td>合同金额：</td>
    				<td>
    					<input name="contractVO.price" value="${contractVO.price }" type="text">
    				</td>
    			</tr>
    			<tr>
    				<td class="text-title">合同生效日期：</td>
    				<td class="text-content">
    					<input name="contractVO.startdate" value="${contractVO.startdate }" class="easyui-datetimebox">
    				</td>
    				<td></td>
    				<td>合同到期时间：</td>
    				<td>
						<input type="hidden" name="contractVO.createtime" value="${contractVO.createtime }">
    					<input name="contractVO.enddate" value="${contractVO.enddate }"class="easyui-datetimebox">
    				</td>
    			</tr>
    			<tr>
    				<td>状态：</td>
    				<td><input type="text" name="contractVO.status" value="${contractVO.status}"></td>
    				<td></td>
    				<td></td>
    				<td></td>
    			</tr>
    			<tr>
    				<td>条件和条款：</td>
    				<td colspan="4"><textarea rows="8" cols="100%" name="contractVO.contractcontent" id="wysiwyg">${contractVO.contractcontent }</textarea></td>
    			</tr>
    			<tr>
    				<td>合同描述：</td>
    				<td colspan="4"><textarea rows="4" cols="100%" name="contractVO.description">${contractVO.description }</textarea></td>
    			</tr>
    			<tr>
    				<td colspan="5">
						<a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton button-primary">保存</a> 
						<a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-return">重置</a>
					</td>
    			</tr>    			
    		</table>
    	</form>
    </div>
  </body>
  <script type="text/javascript">
  	$(function() {
  		document.getElementById("businessCustomerName").style.backgroundColor = "#FFF8DC";
		document.getElementById("ownerUserName").style.backgroundColor = "#FFF8DC";
		document.getElementById("businessConnectionName").style.backgroundColor = "#FFF8DC";
		document.getElementById("contractNumber").style.backgroundColor = "#FFF8DC";
  		var alerNumber=document.getElementById('contractNumber').value;
  		if(!alerNumber){
  			document.getElementById('contractNumber').value=new Date().getTime();
  		}
  		//导入编辑器
		KindEditor.ready(function(K) {
				//在编辑器初始化成功之后赋值editor变量
                window.editor = K.create("#wysiwyg",{
                	minWidth : '300px',
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
		

  		document.getElementById("select").onchange=function (){
	  		$.post(
	  		"manage/business/BusinessAction_findAll.action",
	  		function(data){
	  			var selectValue=$("#select").val();
	  			if(data){
	  				$.each(data.data,function(index,obj){
	  					if(selectValue==obj.businessid){
	  						document.getElementById('businessConnectionName').value=obj.contactsName;
	  						document.getElementById('businessCustomerName').value=obj.customerName;
	  						document.getElementById('ownerUserName').value=obj.ownerName;
	  						document.getElementById('ownerUserId').value=obj.ownerId;
	  						document.getElementById('contractNumber').readOnly=true;
							document.getElementById('businessConnectionName').readOnly=true;
							document.getElementById('ownerUserName').readOnly=true;
							document.getElementById('businessCustomerName').readOnly=true;
							document.getElementById("ownerUserName").style.backgroundColor = "#D3D3D3";
							document.getElementById("businessConnectionName").style.backgroundColor = "#D3D3D3";
							document.getElementById("businessCustomerName").style.backgroundColor = "#D3D3D3";
	  						
	  					}
	  					
	  				})
	  			}
	  		},"json"
	  	);
		  
		};		  	
  	
  		$.post(
	  		"manage/business/BusinessAction_findAll.action",
	  		function(data){
	  			if(data){
	  				var businessId = "${contractVO.businessid}";	
	  				$.each(data.data,function(index,obj){
	  					var option = $("<option"+" "+ "value="+obj.businessid+">"+obj.name+"</option>");
	  					if(businessId && businessId == obj.businessid){
	  						option.attr("selected",true);
	  					}
	  					$("#select").append(option);
	  				})
	  			}
	  		},"json"
	  	);
  	
  	
			//重置按钮
			$("#resetBtn").on("click",function(event){
				$("#form").form("reset");
			});
			//保存按钮
			$("#saveBtn").on("click", function(event) {
				editor.sync();
				$("#form").form("submit", {
					url : "manage/contract/ContractAction_saveOrUpdate.action",
					onSubmit : function() {
						//对表单进行数据校验,如果未通过校验，返回false，阻止表单提交
						return $(this).form("validate");
					
					},
					success : function(data) {
						var obj = eval("("+data+")");
						if(obj.success){
							$.messager.alert("提示",obj.message,"info",function () {
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
