<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>合同列表</title>
    
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<%@include file="../../script.html" %>

  </head>
  
  <body >
  	<div>
  		<select class="easyui-combobox theme-textbox-radius" style="width:120px" id="contractOne">
  			<option value="1">客户</option>
  			<option value="2">联系人</option>
  			<option value="3">负责人</option>
  		</select>
  		<select class="easyui-combobox theme-textbox-radius" style="width:100px" id="contractTwo">
  			<option value="1">包含字段</option>
  			<option value="2">精确查询</option>
  		</select>
  		<span>查询:</span>
		<input id="contract" style="line-height:26px;border:1px solid #ccc">
		<a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
  	</div>
   	<table id="contractList" class="easyui-datagrid"></table>
    <div id="toolbar">
    	<a href="javascript:void(0);" onclick="return add('manage/contract/ContractAction_edit.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新建</a>
    	<a href="javascript:void(0);" onclick="return del('manage/contract/ContractAction_delete.action')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
    	<a href="javascript:void(0);" onclick="return edit('manage/contract/ContractAction_edit.action');" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
	</div>
    </div>
    <script type="text/javascript">
        function doSearch(){

            $("#contractList").datagrid("load",{
                "conditionOne":$("select:eq(0)").val(),
                "conditionTwo":$("select:eq(1)").val(),
				"contractCondition":$("#contract").val()
            });
        }
        //修改按钮事件处理函数
        function edit(url){
            var rows = $("#contractList").datagrid("getChecked");

            if(!rows.length){
                $.messager.alert("警告","请选择要修改的数据");
                return false;
            }
            if(rows.length>1){
                $.messager.alert("警告","请选择单条数据进行修改");
                return false;
            }
            var contractid = rows[0].contractid;
            parent.openTopWindow({
                width:800,
                height:600,
                title:"修改公告信息",
                "url":url+"?contractVO.contractid="+contractid,

                close:function(){
                    $("#contractList").datagrid("reload");
                }

            });
        }
        //添加按钮事件处理函数
        function add(url){
            parent.openTopWindow({
                width:800,
                height:600,
                title:"添加公告信息",
                "url": url,
                close:function(){
                    $("#contractList").datagrid("reload");
                }

            });
        }
        //删除按钮事件处理函数
        function del(url){
            //获取到选中的一行数据
            var rows = $("#contractList").datagrid("getChecked");

            if(!rows.length){
                $.messager.alert("警告","请选择要删除的数据");
                return false;
            }

            $.messager.confirm("警告","数据删除后无法恢复，是否确认删除",function(b){
                if(b){
                    var ids = new Array();
                    $.each(rows,function(index,obj){
                        ids.push(obj.contractid);
                    });
                    //将数组中元素使用,分割拼接为一个字符串
                    ids = ids.join(",");
                    $.post(url,
                        {
                            "ids" : ids
                        },
                        function(data){
                            if(data && data.success){
                                $.messager.alert("提示",data.message,"info",function () {
                                    $("#contractList").datagrid("reload");
                                    $("#contractList").datagrid("clearChecked");
                                });
                                return;
                            }
                            $.messager.alert("警告",data.message);
                        },"json");
                }
            });
        }
    
    	//加载用户数据
    	$(function(){
    		$("#contractList").datagrid({
    			url : "manage/contract/ContractAction_findByPage.action",
    			//queryParams:{"positionName":$("#positionName").val()},
    			pagination : true,
    			toolbar : "#toolbar",
    			fitColumns : true,
    			idField : "contractid",
    			rownumbers : true,
    			//singleSelect:true,
    			showHeader:true,//定义是否显示头部
    			columns : [[
    				{field:"contractid",title:"选择合同",checkbox:true},
    				{field:"contractnumber",title:"合同编号"},
    				{field:"businessCustomerName",title:"客户"},
    				{field:"ownerUserName",title:"负责人"},//ownerUserName
    				{field:"businessConnectionName",title:"联系人"},
    				{field:"duetime",title:"签约日期"},
    				{field:"price",title:"合同金额"},
    				{field:"status",title:"状态"},
    				{field:"enddate",title:"距离到期时间"}
				]],
    			loadFilter:function(data){
    				//data是服务器返回的数据,将服务器端返回的数据转换为datagrid需要的格式
    				return {"total":data.data.totalRows,"rows":data.data.list};
    			}
    		
    		});
    	});
    </script>
  </body>
</html>
