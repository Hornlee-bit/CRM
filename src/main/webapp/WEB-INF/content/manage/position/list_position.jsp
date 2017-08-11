<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户列表</title>
    
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<%@include file="../../script.html" %>

  </head>
  
  <body >
   	<table id="positionList" class="easyui-datagrid"></table>
    <div id="toolbar">
    	<span>岗位名称:</span>
		<input id="positionName" style="line-height:26px;border:1px solid #ccc">
		<a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
    	<a href="javascript:void(0);" onclick="return add('manage/position/PositionAction_edit.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新建</a>
    	<a href="javascript:void(0);" onclick="return del('manage/position/PositionAction_delete.action')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
    	<a href="javascript:void(0);" onclick="return edit('manage/position/PositionAction_edit.action');" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>   	
	</div>
    </div>
    <script type="text/javascript">
        //条件查询
        function doSearch(){
            $('#positionList').datagrid('load',{
                "positionName":$('#positionName').val()
            });
        }
        //添加用户
        function add(url){
            parent.openTopWindow({
                width:700,
                height:500,
                title:"添加岗位",
                "url": url,
                close:function(){
                    $("#positionList").datagrid("reload");
                }

            });
        }
        //修改部门
        function edit(url){
            var rows = $("#positionList").datagrid("getChecked");
            if(!rows.length){
                $.messager.alert("警告","请选择要修改的数据");
                return false;
            }
            var id=rows[0].positionid;
            parent.openTopWindow({
                width:700,
                height:500,
                title:"修改岗位信息",
                "url": url+"?positionVO.positionid="+id,
                close:function(){
                    $("#positionList").datagrid("reload");
                }

            });
        }


        //删除部门
        function del(url){
            //获取到选中的一行数据
            var rows = $("#positionList").datagrid("getChecked");
            if(!rows.length){
                $.messager.alert("警告","请选择要删除的数据");
                return;
            }

            $.messager.confirm("警告","数据删除后无法恢复，是否确认删除",function(b){
                if(b){
                    var ids = new Array();
                    $.each(rows,function(index,obj){
                        ids.push(obj.positionid);
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
                                    $("#positionList").datagrid("reload");
                                    $("#positionList").datagrid("clearChecked");
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
    		$("#positionList").datagrid({
    			url : "manage/position/PositionAction_findByCondition.action",
    			//queryParams:{"positionName":$("#positionName").val()},
    			pagination : true,
    			toolbar : "#toolbar",
    			fitColumns : true,
    			idField : "positionid",
    			rownumbers : true,
    			//singleSelect:true,
    			columns : [[
    				{field:"positionid",title:"选择岗位",checkbox:true},
    				{field:"name",title:"岗位名称",width:10},
    				{field:"departmentName",title:"所属部门",width:10},
    				{field:"positionName",title:"岗位管理上级",width:10},
    				{field:"description",title:"岗位描述",sortable:true,width:10},
    				
    				
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
