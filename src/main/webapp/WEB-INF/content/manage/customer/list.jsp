<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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

<%@include file="/WEB-INF/content/script.html" %>
<body>
<div>
	<span>客户视图：</span><span onclick="return whole('manage/customer/CustomerAction_pagination.action')"
							class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true">全部</span>|
	<span onclick="return myCustomer('manage/customer/CustomerAction_myCustomer.action')" class="easyui-linkbutton"
		  data-options="plain:true">我的客户</span>|
	<span onclick="return subCustomer('manage/customer/CustomerAction_subCustomer.action')" class="easyui-linkbutton"
		  data-options="plain:true">下属客户</span>
	&nbsp;&nbsp;&nbsp;
	<span onclick="return todayCreate('manage/customer/CustomerAction_todayCreate.action')" class="easyui-linkbutton"
		  data-options="iconCls:'icon-ok',plain:true">今日新建</span>|
	<span onclick="return weekCreate('manage/customer/CustomerAction_weekCreate.action')" class="easyui-linkbutton"
		  data-options="plain:true">本周新建</span>|
	<span onclick="return monthCreate('manage/customer/CustomerAction_monthCreate.action')" class="easyui-linkbutton"
		  data-options="plain:true">本月新建</span>|
	<span onclick="return followed('manage/customer/CustomerAction_followed.action')" class="easyui-linkbutton"
		  data-options="plain:true">我关注的</span>|
	<span onclick="shared" class="easyui-linkbutton" data-options="plain:true">我共享的</span>|
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
				<select name="batchOperate" style="width:100px;height:25px;">
					<option value="-1">批量操作</option>
					<option value="0">批量放入客户池</option>
					<option value="1">批量关注</option>
					<option value="2">批量共享</option>
					<option value="3">取消关注</option>
					<option value="4">取消共享</option>
				</select>
			</td>
			<td>
				<select name="filterSearch" id="searchParam" style="width:100px;height:25px;">
					<option value="-1">--请选择筛选条件--</option>
					<option value="0">按客户名查询</option>
					<option value="1">按地址查询</option>
					<option value="2">按创建时间起查询</option>
					<option value="3">按行业查询</option>
				</select>
				<select name="contain" style="width:60px;height:25px;">
					<option value="-1">--包含--</option>
				</select>
			</td>
			<td class="text-content">
				<input name="search" id="param" type="text" placeholder="请输入查询关键字">
				<span id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</span>
			</td>
			<td>
				<span id="chat" class="easyui-linkbutton" data-options="iconCls:'icon-cut',plain:true">发送短信</span>
				<span id="email" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true">发送邮件</span>
			</td>

			<td>
                <span onclick="return add('manage/customer/CustomerAction_showAdd.action')" class="easyui-linkbutton"
					  data-options="iconCls:'icon-add',plain:true">新建客户</span>
				<span id="tool" class="easyui-linkbutton" data-options="iconCls:'icon-cog',plain:true">客户工具</span>
			</td>
		</tr>
	</table>
</div>
<div id="customerLs"></div>
</body>

<script type="text/javascript">
    $(function () {

        //分页展示客户列表
        $("#customerLs").datagrid({
            url: "manage/customer/listByPage.action",
            checkOnSelect: false,
            idField: "customerid",
            pagination: true,
            sortName: "customerid",
            columns: [[
                {field: "选择", checkbox: true},
                {field: "customerid", hidden: true},
                {
                    field: "islocked", title: "关注",
                    formatter: function (value, row, index) {
                        var islocked = false;

                        $.ajax({
                            type: "post",
                            url: "manage/customer/islocked.action",
                            data: {"customerid": row.customerid},
                            dataType: "json",
                            async: false,
                            success: function (data) {
                                if (data && data.success) {
                                    islocked = true;
                                    return;
                                }
                            }
                        });


                        if (!islocked) {
                            return "<img onclick='javascript:follow(" + '"' + row.customerid + '"' + "," + index + ")' src='static/easyui/themes/icons/stark.png'/>";
                        } else {
                            return "<img onclick='javascript:unfollow(" + '"' + row.customerid + '"' + "," + index + ")' src='static/easyui/themes/icons/star.png'/>";
                        }
                    }
                },
                {field: "name", title: "客户名称"},
                {field: "industry", title: "客户行业"},
                {field: "rating", title: "评分"},
                {
                    field: "address", title: "客户联系地址", formatter: function (value) {
                    return "<span title='" + value + "'>" + value + "</span>"
                }
                },
                {field: "userByOwnerusername", title: "负责人"},
                {field: "userByCreatorusername", title: "创建人"},
                {
                    field: "createtime", title: "创建时间", width: 50, formatter: function (value) {
                    return "<span title='" + value + "'>" + value + "</span>"
                }
                },
                {
                    field: "updatetime", title: "更新时间", width: 100, formatter: function (value) {
                    if (value) {
                        return "<span title='" + value + "'>" + value + "</span>";
                    }
                    return "";
                }
                },
                {field: "days", title: "距离到期天数"},
                {
                    field: "operation", title: "操作", formatter: function (value, rowData, index) {
                    return "<a href='javascript:void(0);' onclick=\"return see(\'manage/customer/CustomerAction_showSee.action\',\'" + rowData.id + "\')\">查看</a>" +
                        " <a href='javascript:void(0);' onclick=\"return modify(\'manage/customer/CustomerAction_showAdd.action\',\'" + rowData.id + "\')\">编辑</a>"
                }
                }

            ]],
            loadFilter: function (data) {
                return {total: data.data.totalRows, rows: data.data.list}
            }

        })
    })
    //为搜索按钮添加点击事件
    $("#search").on("click", function () {
//        下拉框选中的值
        var searchParam = $("#searchParam").val();
//        判断查询的条件
//        按名字查询
        if (searchParam == "0" || searchParam == "-1") {
            $('#customerLs').datagrid({
                queryParams: {
                    name: $("#param").val()
                }
            });
        }
//        按地址查询
        if (searchParam == "1") {
            $('#customerLs').datagrid({
                queryParams: {
                    address: $("#param").val()
                }
            });
        }
//       按创建时间始查询
        if(searchParam == "2"){
            $('#customerLs').datagrid({
                queryParams: {
                    createtimeStart: $("#param").val()
                }
            });
        }
//        按行业名称查询
        if (searchParam == "3"){
            $('#customerLs').datagrid({
                queryParams: {
                    industryName: $("#param").val()
                }
            });
        }
    })

    //关注客户事件
    function follow(id, index) {
        $.post("manage/customer/CustomerAction_follow.action", {
            "customerid": id
        }, function (data) {
            if (data && data.success) {
                $("#customerLs").datagrid("reload", {
                    "index": index,
                    "row": {
                        "follow": "<img src='static/easyui/themes/icons/star.png'/>"
                    }
                })
            }
        }, "json")

    }
    //取消关注客户
    function unfollow(id, index) {
        $.post("manage/customer/CustomerAction_unfollow.action", {
            "customerid": id,
        }, function (data) {
            if (data && data.success) {
                $("#customerLs").datagrid("reload", {
                    "index": index,
                    "row": {
                        "follow": "<img src='static/easyui/themes/icons/stark.png'/>"
                    }
                })
            }
        }, "json")
    }
    //查询全部客户
    function whole(url) {
        $("#customerLs").datagrid({
            "url": url
        })
    }
    //查询我的客户
    function myCustomer(url) {
        $("#customerLs").datagrid({
            "url": url
        })
    }
    //查询当前员工下属创建的客户
    function subCustomer(url) {
        $("#customerLs").datagrid({
            "url": url
        })
    }
    //查询今天创建的客户
    function todayCreate(url) {
        $("#customerLs").datagrid({
            "url": url + "?type=day"
        })
    }
    //查询周创建的客户
    function weekCreate(url) {
        $("#customerLs").datagrid({
            "url": url + "?type=week"
        })
    }
    //查询月创建的客户
    function monthCreate(url) {
        $("#customerLs").datagrid({
            "url": url
        })
    }
    //查询当前用户关注的客户
    function followed(url) {
        $("#customerLs").datagrid({
            "url": url
        })
    }

    //页面添加客户
    function add(url) {
        parent.parent.openTopWindow({
            "url": url,
            "width": 800,
            "height": 700,
            "title": "新建客户",
            close: function () {
                $("#customerLs").datagrid("reload");
            }
        })
    }
    //修改客户
    function modify(url, id) {
        parent.parent.openTopWindow({
            "url": url + "?customerVO.id=" + id,
            "width": 800,
            "height": 700,
            "title": "新建客户",
            close: function () {
                $("#customerLs").datagrid("reload");
            }
        })
    }

    //查看客户
    function see(url, id) {
        parent.parent.openTopWindow({
            "url": url + "?customerVO.id=" + id,
            "width": 800,
            "height": 700,
            "title": "客户信息",
            close: function () {
                $("#customerLs").datagrid("reload");
            }
        })
    }
</script>
<script type="text/javascript">
    $(function () {
        //邮件发送
        $("#email").on("click", function (e) {
            var rows = $("#customerLs").datagrid("getSelections");
            if (!rows || rows.length == 0) {
                $.messager.alert("警告", "请选中要发送邮件的客户");
                return;
            }

        })
    })

</script>
</html>
