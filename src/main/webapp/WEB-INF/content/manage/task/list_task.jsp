<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list_task.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="../../script.html" %>
  </head>
  	
  <body>
  	<div>
  		<select  name="taskVo" class="easyui-combobox theme-textbox-radius" style="width:120px">
  			<option value="1">任意字段</option>
  			<option value="taskVo.subject" }>主题</option>
  			<option value="taskVo.creatorUsername" }>创建者</option>
  			<option value="taskVo.ownerUsername">负责人</option>
  			<option value="taskVo.status">任务状态</option>
  			<option value="taskVo.priority">优先级</option>
  			<option value="taskVo.description">描述</option>
  			<option value="taskVo.duedate">截止日期</option>
  			<option value="taskVo.createdate">创建日期</option>
  			<option value="taskVo.updtadate">更行日期</option>
  		</select>
  		<select name="taskVo.creatorUsername" class="easyui-combobox theme-textbox-radius" style="width:100px" >
  			<option value="1" {taskVo.creatorUsername?"selected":""} >包含</option>
  			<option value="2" {taskVo.ownerUsername?"selected":""}>人名</option>
  		</select>
  		<input name="subject" type="text" value="${taskVo.subject}" class="easyui-textbox theme-textbox-radius">
  		<a href="javascript:void(0);" onclick="return searchs()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
  	</div>
 
    <table id="taskList"class="easyui-datagrid">
    	
    </table>
  
    <div id="toolbar">
    	<a href="javascript:void(0);" onclick="return add('manage/task/TaskAction_edit.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新建</a>
    	<a href="javascript:void(0);" onclick="return del('manage/task/TaskAction_del.action')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
    	<a href="javascript:void(0);" onclick="return edit('manage/task/TaskAction_edit.action');" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
    	
    </div>
    
  </body>
  <script type="text/javascript">
  		function add(url){
  			parent.openTopWindow(
  			{
  				width :600,
  				height:620,
  				"title":"新建任务",
  				"url":url,
  				close:function(){
  					$("#taskList").datagrid("reload")
  				}
  				
  			}
  			)
  		}
  		function searchs(){

  		}
        //删除按钮事件处理函数
        function del(url){
            //获取到选中的一行数据
            var rows = $("#taskList").datagrid("getChecked");

            if(!rows.length){
                $.messager.alert("警告","请选择要删除的数据");
                return false;
            }

            $.messager.confirm("警告","数据删除后无法恢复，是否确认删除",function(b){
                if(b){
                    var ids = new Array();
                    $.each(rows,function(index,obj){
                        ids.push(obj.taskid);
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
                                    $("#taskList").datagrid("reload");
                                    $("#taskList").datagrid("clearChecked");
                                });
                                return;
                            }
                            $.messager.alert("警告",data.message);
                        },"json");
                }
            });
        }
  		function edit(url){
  			var rows=$("#taskList").datagrid("getChecked");
  			if(!rows.length){
  				$.messager.alert("提示","请选择要修改的任务");
  				return ;
  			}
  			var taskId=rows[0].taskid;
  			parent.openTopWindow({
                width :600,
                height:620,
  				title:"修改任务",
  				"url":url+"?taskVo.taskid="+taskId,
  				close:function(){
  					$("#taskList").datagrid("reload")
  				}
  			})
  		}
		$(function(){
			$("#taskList").datagrid({
				url:"manage/task/TaskAction_findByPage.action",
				pagination:true,
				toolbar:"#toolbar",
				fitColumns:true,
				idField:"taskid",
				rownumbers:true,
				columns :[[
					{field:"taskid",title:"选择",checkbox:true},
					{field:"subject" ,title:"主题",width:10},
					{field:"aboutUser",title:"相关信息",width:10},
					{field:"ownerUsername",title:"负责人",width:15},
					{field:"status",title:"状态",width:10},
					{field:"priority",title:"优先级",width:15},
					{field:"creatorUsername",title:"创建者",width:15},
					{field:"duedate" ,title:"截止日期",width:15},
				]],
				
				loadFilter:function(data){
				return {"total":data.data.totalRows,"rows":data.data.list}
				}	
				
			})		
		}) 
			
		function see(index){


		}
		function modify(index){

		}
  
  </script>
</html>
