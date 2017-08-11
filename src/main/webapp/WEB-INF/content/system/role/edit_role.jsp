<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>添加角色</title>
    
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="content-type" content="text/html;charset=UTF-8">
	<meta name="expires" content="0">    
	<%@ include file="../../script.html" %>
	
  </head>
  
  <body style="width:100%;max-width:600px;padding:30px 60px;">
	<section class="info-section">
		<form id="form" method="post">
			<table>
				<tr>
					<td class="text-title">角色名称：</td>
					<td class="text-content">
						<input type="hidden" name="roleVO.id" value="${roleVO.id }"> 
						<input type="text" name="roleVO.rolename" value="${roleVO.rolename }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true,validType:'length[3,10]'">
					</td>
				</tr>
				<tr>
					<td class="text-title">排序编号：</td>
					<td class="text-content">
						<input type="text" name="roleVO.sortnum" value="${roleVO.sortnum }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true">
					</td>
				</tr>
				<tr>
					<td class="text-title">角色状态：</td>
					<td class="text-content">
						<select name="roleVO.status" class="easyui-combobox theme-textbox-radius">
							<option value="1" ${roleVO.status==1?"selected":"" }>正常</option>
							<option value="0" ${roleVO.status==0?"selected":"" }>禁用</option>
							<option value="2" ${roleVO.status==2?"selected":"" }>已删除</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="text-title">描述信息：</td>
					<td class="text-content">
						<textarea class="theme-textbox-radius" rows="5"  cols="20" name="roleVO.rolenote">${roleVO.rolenote }</textarea></td>
				</tr>

				<tr style="display: none;">
					<td colspan="2">
						<input type="hidden" name="roleVO.funcIds" value="${roleVO.funcIds}"> 
						<input type="hidden" name="roleVO.createById" value="${roleVO.createById}"> 
						<input type="hidden" name="roleVO.createTime" value="${roleVO.createTime}">
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
            $("#resetBtn").on("click",function(event){
                $("#form").form("reset");
            });

            //为保存按钮添加事件
            $("#saveBtn").on("click",function(event){
                $("#form").form("submit",{
                    url:"system/role/RoleAction_saveOrUpdate.action",
                    onSumbit : function(){
                        //调用easyui中form对象的validate方法对表单中数据进行校验，该方法返回boolean值，如果为false会阻止表单提交
                        return $("#form").form("validate");
                    },
                    success : function(data){
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
</body>
</html>
				
