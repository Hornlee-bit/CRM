<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

  </head>
  
  <%@include file="../../script.html" %>
  <body>
    <div>
    	<span>客户视图：</span><span onclick="return whole('system/customer/CustomerAction_pagination.action')" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true">全部</span>|
    	<span onclick="return myCustomer('system/customer/CustomerAction_myCustomer.action')" class="easyui-linkbutton" data-options="plain:true">我的客户</span>|
    	<span onclick="return subCustomer('system/customer/CustomerAction_subCustomer.action')" class="easyui-linkbutton" data-options="plain:true">下属客户</span>
    	&nbsp;&nbsp;&nbsp;
    	<span onclick="return todayCreate('system/customer/CustomerAction_todayCreate.action')" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true">今日新建</span>|
    	<span onclick="return weekCreate('system/customer/CustomerAction_weekCreate.action')" class="easyui-linkbutton" data-options="plain:true">本周新建</span>|
    	<span onclick="return monthCreate('system/customer/CustomerAction_monthCreate.action')" class="easyui-linkbutton" data-options="plain:true">本月新建</span>|
    	<span onclick="return followed('system/customer/CustomerAction_followed.action')" class="easyui-linkbutton" data-options="plain:true">我关注的</span>|
    	<span id="shared" class="easyui-linkbutton" data-options="plain:true">我共享的</span>|
    	<span id="sharedTome" class="easyui-linkbutton" data-options="plain:true">共享给我的</span>
    	&nbsp;&nbsp;&nbsp;
    	<span id="recycleBin" class="easyui-linkbutton" data-options="iconCls:'icon-recover_deleted',plain:true">回收站</span>
    	&nbsp;
    	<span id="advancedSearch" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">高级搜索</span>
    </div>
    
    <div id="tool" style="margin-bottom: 20px">
    	<table>
    		<tr>
    			<td>
    				<i class="iconfont"></i>
    				
    			</td>
    			<td>
    				<select id="searchBy" style="width:150px;height:25px;">
    					<option value="-1">--请选择筛选条件--</option>
    					<option value="1">按客户名查询</option>
    					<option value="2">按商机名查询</option>
    					<option value="3">按商机来源查询</option>
    					<option value="4">按下一次联系内容查询</option>
    				<!-- 	<option value="owner.username">按负责人查询</option> -->
    				<!--	<option value="userByCreatoruserid">按创建人查询</option> -->
    				</select>
    				<select name="contain" style="width:60px;height:25px;">
    					<option value="-1">--包含--</option>
    				</select>
    			</td>
    			<td  class="text-content">
    				<input id="searchText" type="text" placeholder="请输入查询关键字" style="border:1px solid black;height:25px;">
					<span id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</span>
					<span id="reset" class="easyui-linkbutton" data-options="iconCls:'icon-update',plain:true">重置</span> 				
    			</td>
    			<td>
    				<span id="chat" class="easyui-linkbutton" data-options="iconCls:'icon-cut',plain:true">发送短信</span>				
					<span id="email" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true">发送邮件</span> 				    				
    			</td>  
    			
    			<td>
    				<span id="addBtn" onclick="return add('manage/business/BusinessAction_edit.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加商机</span> 				
    				<span id="tool" class="easyui-linkbutton" data-options="iconCls:'icon-cog',plain:true">商机工具</span>				    				
    			</td>  			
    		</tr>
    	</table>
    </div>
    <div id="businessList"></div>
  </body>
  
  <script type="text/javascript">
  $("#search").bind("click",function(){
	  $("#businessList").datagrid("load",{
          "conditionOne":$("select:eq(0)").val(),
          "searchText":$("#searchText").val()
      });
  })
  $("#reset").on("click",function(event){
      $("select:eq(0)").val('-1');
      $("#searchText").val("");
      $("#businessList").datagrid("load",{
          "conditionOne":$("select:eq(0)").val(),
          "searchText":$("#searchText").val()
      });
  })


  function add(url){
      parent.parent.openTopWindow({
          width:900,
          height:600,
          title:"添加商机信息",
          "url": url,
          close:function(){
              $("#businessList").datagrid("reload");
          }

      });
  }
  
  	$(function(){
  		//分页展示客户列表
		$("#businessList").datagrid({
			url:"manage/business/BusinessAction_findByPage.action",
			fitColumns:true,
			checkOnSelect:false,
			idField:"name",
			pagination:true,
			sortName:"name",
			columns:[[
				{field:"选择",checkbox:true},
				{field:"id",hidden:true},
				{field:"customerName",title:"客户"},
				{field:"name",title:"商机名"},
				{field:"origin",title:"商机来源"},
				{field:"nextsteptime",title:"下一次联系时间"},
				{field:"nextstep",title:"下一次联系内容"},
				{field:"ownerName",title:"负责人"},
				{field:"createByName",title:"创建人"},
				{field:"createtime",title:"创建时间"},
				{field:"updatetime",title:"更新时间"},
				/*{field:"operation",title:"操作",width:20,formatter:function(value,row,index){
		  			return "<a href='javascript:void(0)' onclick='return see("+index+")'>查看</a>"+
		  			" <a href='javascript:void(0)' onclick='return modify("+index+")'>修改</a>";
  				}}*/
			]],
			loadFilter:function(data){
				return {total : data.data.totalRows,rows:data.data.list}
			}		
		})	
	})
	function see(index){

	}
	function modify(index){

	}
	
	

	
	
	
	
	
  </script>
</html>
