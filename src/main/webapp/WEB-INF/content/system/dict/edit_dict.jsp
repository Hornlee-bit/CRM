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
					<td class="text-title">字典名：</td>
					<td class="text-content">
						<input type="hidden" name="dictVO.id" value="${dictVO.id }"> 
						<input type="text" name="dictVO.dictname" value="${dictVO.dictname }" 
							class="easyui-textbox theme-textbox-radius" data-options="required:true">
					</td>
				</tr>

				<tr>
					<td class="text-title">字典编码：</td>
					<td class="text-content">
						<input type="text" name="dictVO.dictcode" value="${dictVO.dictcode }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true">
					</td>
				</tr>
				<tr>
					<td class="text-title">字典值：</td>
					<td class="text-content">
						<input type="text" name="dictVO.dictvalue" value="${dictVO.dictvalue }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true"></td>
				</tr>
				<tr>
					<td class="text-title">字典类型：</td>
					<td class="text-content">
						<select class="myselect" name="dictVO.dictTypeId" >
						</select>
					</td>
				</tr>
				<tr>
					<td class="text-title">字典备注：</td>
					<td class="text-content">
						<input type="text" name="dictVO.dictnote" value="${dictVO.dictnote }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true">
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
			//给词条类型下拉框填充选项
			$.post(
			  		"system/dict/DictTypeAction_findAll.action",
			  		{
			  			"typecode":"dictType"
			  		},
			  		function(data){
			  			if(data&&data.data){
			  				$.each(data.data,function(index,obj){
			  					var option;
			  					var dtId;
			  					if("${dictVO}"&&"${dictVO.dictTypeId}"){
			  						dtId="${dictVO.dictTypeId}";
			  					}else{
			  						dtId="-1";
			  					}
			  					if(obj.typecode=="allType"){
			  						option=$("<option value='-1'>请选择一个字典类型</option>");
			  					}else if(obj.id==dtId){
			  						option=$("<option value='"+obj.id+"' selected>"+obj.typename+"</option>");
			  					}else{
			  						option=$("<option value='"+obj.id+"'>"+obj.typename+"</option>");
			  					}
				  				$("select[name='dictVO.dictTypeId']").append(option);
			  				})
			  			}
			  		},"json"
			 )
			//重置按钮
			$("#resetBtn").on("click",function(event){
				$("#form").form("reset");
			});
			//保存按钮
			$("#saveBtn").on("click", function(event) {
				var dictTypeIdValue=$("select[name='dictVO.dictTypeId']").val()
				if("-1"==dictTypeIdValue){
					parent.$.messager.alert("提示","请选择一个字典类型");
	  				return false;
				}
				$("#form").form("submit", {
					url : "system/dict/DictAction_saveOrUpdate.action",
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
			$.extend($.fn.validatebox.defaults.rules, {
			    notNull: {
					validator: function(value, param){
						if(value=="-1"){
							return false;
						}
						return true;
					},
					message: '请在下拉框中选择一个词典类型'
			    }
			});


	});
		
	</script>
</body>
</html>
				