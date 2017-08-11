<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>添加公告</title>
    
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="content-type" content="text/html;charset=UTF-8">
	<meta name="expires" content="0">    
	<%@ include file="../../script.html" %>
	
  </head>
  
  <style type="text/css">
.myselect{
	height:30px;
	width:80%;
	
}
</style>
  
  <body style="width:100%;max-width:600px;padding:10px 30px;">
  <form id="form" method="post">
	<strong>基本信息</strong>
	
	<section class="info-section">
		
			<table id="tb">
				<tr>
				<td class="text-title"> 标题：</td>
					<td>					
					    <input type="text" style="width:80%;" name="announcementVO.title" value="${announcementVO.title}" class="easyui-textbox theme-textbox-radius" >
					    <input type="hidden" name="announcementVO.announcementid" value="${announcementVO.announcementid }">
						<input type="hidden" name="announcementVO.userid" value="${announcementVO.userid }">
						<input type="hidden" name="announcementVO.updatetime"  value="${announcementVO.updatetime }" >
						<input type="hidden" name="announcementVO.createtime"  value="${announcementVO.createtime }" >	 
							 
					</td>
			     </tr>			     
				<tr>
				    <td class="text-title"> 颜色：</td>
					<td>					
					    <input type="text" style="width:80%;" name="announcementVO.color" value="${announcementVO.color}" class="easyui-textbox theme-textbox-radius" >
					   
					</td>
			     </tr>
			     <tr>
				    <td class="text-title"> 排序编号：</td>
					<td>					
					    
					   <input type="text" style="width:80%;" name="announcementVO.orderid"  value="${announcementVO.orderid }" class="easyui-textbox theme-textbox-radius" >
					</td>
			     </tr>			 			         
			     <tr>
					 <td class="text-title"> 是否显示：</td>
					 <td>

						<input type="radio" name="announcementVO.isshow"  checked value="${announcementVO.isshow}" />是
					    <input type="radio" name="announcementVO.isshow"  value="${announcementVO.isshow}" />否
					 </td>
				 </tr>
				 <tr>
					<td class="text-title">  是否发布：</td>
					<td>        
					    <input type="radio" name="announcementVO.status" checked value="${announcementVO.status}" />是
					    <input type="radio" name="announcementVO.status" value="${announcementVO.status}" />否
					</td>
				</tr>
				<tr>
					<td class="text-title">通知部门：</td>
					<td class="text-content">
						<select  class="myselect" name="announcementVO.departmentid">
							<option value="-1">请选择部门</option>
							<c:forEach items="${list}" var="dept" >
								<option value="${dept.departmentid}"
										<c:if test="${announcementVO.departmentid eq dept.departmentid}">selected</c:if>
								>${dept.name}</option>
							</c:forEach>
						</select>
					</td>
					
				</tr>
                <tr>
					<td class="text-title">内容</td>
					<td class="text-content">
						<textarea name="announcementVO.content" rows="10" style="width:80%;">${announcementVO.content}</textarea>
					</td>
				</tr>
				
				
				<tr>
					<td colspan="2" style="text-align: center;margin-top: 10px;">
						<a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton button-primary">保存</a> 
						<a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-danger">重置</a>
					</td>
				</tr>
				
			</table>
	  </section>
   </form>

	<script type="text/javascript">
        $(function() {
            //重置按钮
            $("#resetBtn").on("click",function(event){
                $("#form").form("reset");
            });

            //为保存按钮添加事件
            $("#saveBtn").on("click",function(event){
                $("#form").form("submit",{
                    url:"manage/announcement/AnnouncementAction_saveOrUpdate.action",
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
        //给部门添加下拉框选项

	</script>
</body>
</html>
				
