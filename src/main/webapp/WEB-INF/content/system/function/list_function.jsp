<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>权限列表</title>
    
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	
	<%@include file="../../script.html" %>

  </head>
  
  <body>
    <!-- 表格中展示所有的权限 -->
    <table id="funcList"></table>
    <div id="toolbar">
    	<a href="javascript:void(0);" onclick="return add('system/function/FunctionAction_edit.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新建</a>
    	<a href="javascript:void(0);" onclick="return del('system/function/FunctionAction_remove.action')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
    	<a href="javascript:void(0);" onclick="return edit('system/function/FunctionAction_edit.action');" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
    </div>
  
    <script type="text/javascript">
        //添加按钮点击事件
        function add(url){
            parent.openTopWindow({
                title:"添加权限",
                width:700,
                height:600,
                "url" : url,
                close : function(){
                    $("#funcList").treegrid("reload");
                }
            });
        }
        //修改按钮点击事件
        function edit(url){
            var rows = $("#funcList").treegrid("getCheckedNodes");
            if(!rows.length){
                $.messager.alert("警告","请选择需要修改的权限信息");
                return false;
            }
            if(rows.length>1){
                $.messager.alert("警告","请选择单条数据进行修改");
                return false;
            }
            var funcId = rows[0].id;
            parent.openTopWindow({
                title:"修改权限",
                width:700,
                height:600,
                "url" : url+"?funcVO.id="+funcId,
                close : function(){
                    $("#funcList").treegrid("reload");
                }
            });
        }
        //删除按钮事件处理函数
        function del(url){
            //获取到选中的一行数据
            var rows = $("#funcList").treegrid("getCheckedNodes");

            if(!rows.length){
                $.messager.alert("警告","请选择要删除的数据");
                return;
            }

            $.messager.confirm("警告","数据删除后无法恢复，是否确认删除",function(b){
                if(b){
                    var ids = new Array();
                    $.each(rows,function(index,obj){
                        ids.push(obj.id);
                    });
                    ids = ids.join(",");
                    $.post(url,
                        {
                            "ids" : ids
                        },
                        function(data){
                            if(data && data.success){
                                $.messager.alert("提示",data.message);
                                $("#funcList").treegrid("reload");
                                $("#funcList").datagrid("clearChecked");
                                return;
                            }
                            $.messager.alert("警告",data.message);

                        },"json");
                }
            });
        }

        
    	$(function(){
    		//加载所有权限
    		$("#funcList").treegrid({
    			url : "system/function/FunctionAction_findAll.action",
    			fitColumns : true,
    			idField : "id",
    			treeField: "funcName",
    			rownumbers : true,
    			toolbar : "#toolbar",
    			checkbox : true,
    			singleSelect : false,
    			cascadeCheck : false,
                animate:true,
    			columns : [[
    				
    				{field:"funcName",title:"权限名称",sortable:true,width:10},
    				{field:"funcType",title:"权限类型",width:5,formatter:function(value,rowData,index){
    					if(value == 1){
    						return "菜单";
    					}else if(value == 0){
    						return "按钮";
    					}else{
    						return "其他";
    					}
    				}},
    				{field:"funcURL",title:"权限URL",width:10},
    				{field:"funcNote",title:"权限描述",width:10},
    				{field:"createBy",title:"创建者",width:5},
    				{field:"createTime",title:"创建时间",width:10},
    				{field:"updateBy",title:"修改者",width:5},
    				{field:"updateTime",title:"修改时间",width:10},
    				{field:"status",title:"权限状态",formatter:function(value,rowData,index){
    					if(value == 1){
    						return "可用";
    					}else if(value == 0){
    						return "禁用";
    					}else if(value == 2){
    						return "已删除";
    					}else{
    						return "";
    					}
    				}}
    				
    			]],
    			loadFilter:function(data){//"_parentId"
    				
    				if(data && data.data){
    					$.each(data.data ,function(index,obj){
    						if(obj.parentId){
    							data.data[index]._parentId = obj.parentId; 
    						}else{
                                obj.state = "closed";
                            }
    						
    					});
    					return {"rows":data.data};
    				}
    				return null;
    			}
    		});
    	});
    </script>
  </body>
</html>
