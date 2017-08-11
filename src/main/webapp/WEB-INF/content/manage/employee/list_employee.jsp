<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>员工信息表</title>
    <meta name="pragma" content="no-cache">
    <meta name="cache-control" content="no-cache">
    <meta name="expires" content="0">
    <%@include file="../../script.html" %>

</head>
<style type="text/css">
    body{
        font-size:14px
    }
</style>
<body >
<div id="toolbar" style="padding:0 30px;">
    <b>员工姓名: </b><input class="easyui-textbox" id="empName" type="text" name="name" style="width:166px;height:35px;line-height:35px;"/>
    <a href="javascript:void(0);" id="searchBtn" class="easyui-linkbutton" iconCls="icon-search" data-options="selected:true" style="background-color:#00aa00;color:white">查询</a>
    <a href="javascript:void(0);" id="setBtn" class="easyui-linkbutton" iconCls="icon-reload" style="background-color:#00aa00;color:white;margin-left:10px">重置</a>
    <a href="javascript:void(0);" onclick="return add('manage/employee/add.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="background-color:#00aa00;color:white;margin-left:10px">添加</a>
    <a href="javascript:void(0);" onclick="return remove('manage/employee/remove.action')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" style="background-color:#f00;color:white;margin-left:10px">删除</a>
    <a href="javascript:void(0);" onclick="return edit('manage/employee/edit.action')" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" style="background-color:#00aa00;color:white;margin-left:10px">修改</a>
</div>
<table id="empList" class="easyui-datagrid" style="font-size:14px"></table>
<script type="text/javascript">
    //为查询按钮添加处理函数
    $("#searchBtn").on("click",function(){
//	        带参数的查询
        $('#empList').datagrid({
            queryParams: {
                name: $("#empName").val()
            }
        });
    })
    //为添加按钮添加事件处理函数
    function add(url) {
        parent.openTopWindow({
            width: 500,
            height: 600,
            title: "添加员工",
            "url": url,
            close: function () {
                $("#empList").datagrid("reload");
                $("#empList").datagrid("clearChecked");
            }
        })
    }
    //为重置按钮添加事件处理函数
    $("#setBtn").bind("click",function () {
        $("input").val('');
        $("#empList").datagrid("load",{
            name: $("#empName").val()
        });
    })

    //修改按钮事件处理函数
    function edit(url) {
        var rows = $("#empList").datagrid("getChecked");
        if(!rows.length){
            $.messager.alert("提示", "请选择要修改的员工");
            return;
        }
        if(rows.length > 1){
            $.messager.alert("提示","一次请修改一条");
            return;
        }
        var empid = rows[0].empid;
        parent.openTopWindow({
            width: 500,
            height: 600,
            title: "修改任务",
            "url": url + "?emp.empid=" + empid,
            close: function () {
                $("#empList").datagrid("reload");
                $("#empList").datagrid("clearChecked");
            }
        })
    }

    //删除按钮事件处理函数
    function remove(url) {
        var rows = $("#empList").datagrid("getChecked");
        if(!rows.length){
            $.messager.alert("警告","请选择要删除的数据");
            return false;
        }

        $.messager.confirm("警告","数据删除后无法恢复，是否确认删除",function(b){
            if(b){
                var ids = new Array();
                $.each(rows,function(index,obj){
                    ids.push(obj.empid);
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
                                $("#empList").datagrid("reload");
                                $("#empList").datagrid("clearChecked");
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
        $("#empList").datagrid({
            url : "manage/employee/listByPage.action",
            pagination : true,
            toolbar : "#toolbar",
            fitColumns : true,
            idField : "empid",
            rownumbers : true,
            //singleSelect:true,
            columns : [[
                {field:"empid",title:"选择",checkbox:true},
                {field:"name",title:"员工姓名",sortable:true,width:10},
                {field:"telephone",title:"联系电话",sortable:true,width:10},
                {field:"email",title:"邮箱",sortable:true,width:10},
                {field:"address",title:"地址",width:10},
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
