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
   	<table id="deptList" class="easyui-datagrid"></table>
    <div id="toolbar">
    	<span> 部门名称:</span>
		<input id="departmentName" style="line-height:26px;border:1px solid #ccc">
		<span> 上级部门:</span>
		<input id="departmentParentName" style="line-height:26px;border:1px solid #ccc">
		<a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
    	<a href="javascript:void(0);" onclick="return add('manage/position/DepartmentAction_edit.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新建</a>
    	<a href="javascript:void(0);" onclick="return del('manage/position/DepartmentAction_delete.action')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
    	<a href="javascript:void(0);" onclick="return edit('manage/position/DepartmentAction_edit.action');" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
	</div>
    </div>
    <script type="text/javascript">
        function doSearch(){
            $('#deptList').datagrid('load',{
                "name":$('#departmentName').val(),
                "parentName":$("#departmentParentName").val()
            });
        }

        //添加用户
        function add(url){
            parent.openTopWindow({
                width:700,
                height:500,
                title:"添加部门",
                "url": url,
                close:function(){
                    $("#deptList").datagrid("reload");
                }

            });
        }
        //修改部门
        function edit(url){
            var rows = $("#deptList").datagrid("getChecked");
            if(!rows.length){
                $.messager.alert("警告","请选择要修改的数据");
                return false;
            }
            if(rows.length>1){
                $.messager.alert("警告","请选择单条数据进行修改");
                return false;
            }
            var id=rows[0].departmentid;
            parent.openTopWindow({
                width:700,
                height:500,
                title:"修改部门信息",
                "url": url+"?deptVO.departmentid="+id,
                close:function(){
                    $("#deptList").datagrid("reload");
                }

            });
        }


        //删除部门
        function del(url){
            //获取到选中的一行数据
            var rows = $("#deptList").datagrid("getChecked");
            if(!rows.length){
                $.messager.alert("警告","请选择要删除的数据");
                return;
            }

            $.messager.confirm("警告","数据删除后无法恢复，是否确认删除",function(b){
                if(b){
                    var ids = new Array();
                    $.each(rows,function(index,obj){
                        ids.push(obj.departmentid);
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
                                    $("#deptList").datagrid("reload");
                                    $("#deptList").datagrid("clearChecked");
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
    		$("#deptList").datagrid({
    			url : "manage/position/DepartmentAction_findByPage.action",
    			pagination : true,
    			toolbar : "#toolbar",
    			fitColumns : true,//设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
    			idField : "departmentid",
    			rownumbers : true,
    			//singleSelect:true,
    			columns : [[
    				{field:"departmentid",title:"选择",checkbox:true,width:10},
    				{field:"name",title:"部门名称",width:10},
    				{field:"parentName",title:"上级部门",width:10},
    				{field:"description",title:"部门描述",width:10},	
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
