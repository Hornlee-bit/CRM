<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>添加客户</title>

	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="content-type" content="text/html;charset=UTF-8">
	<meta name="expires" content="0">
	<%@include file="../../script.html" %>
	<link href="http://www.easyui-extlib.com/Content/Site.css" rel="stylesheet" />
	<script src="http://www.easyui-extlib.com/Scripts/jquery-extensions/jquery.jdirk.js"></script>
	<link href="http://www.easyui-extlib.com/Scripts/jquery-easyui-extensions/validatebox/jeasyui.extensions.validatebox.css" rel="stylesheet" />
	<script src="http://www.easyui-extlib.com/Scripts/jquery-easyui-extensions/validatebox/jeasyui.extensions.validatebox.rules.js"></script>

</head>
<style>
	*{
		margin-left: 10px;
		padding: 3px;
	}
	.tip{

		height:30px;
		text-align: right;
		background-color: #F5F5F5;
	}
</style>

<body>
<form id="newCustomer" method="post">
	<input type="hidden" name="customerVO.id" value="${customerVO.id }">
	<input type="hidden" name="customerVO.isDeleted" value="${false}">
	<input type="hidden" name="customerVO.isLocked" value="${false }">
	<input type="hidden" name="customerVO.contactId" value="${customerVO.contactId }">
	<input type="hidden" name="customerVO.contactCreateUserId" value="${customerVO.contactCreateUserId }">
	<input type="hidden" name="customerVO.contactCreateTime" value="${customerVO.contactCreateTime }">
	<input type="hidden" name="customerVO.createUserId" value="${customerVO.createUserId }">
	<input type="hidden" name="customerVO.createTime" value="${customerVO.createTime}">
	<table>
		<tr>
			<td colspan="4">主要信息</td>
		</tr>
		<tr>
			<td class="tip">负责人：</td>
			<td><select id="owner" name="customerVO.ownerId" style="width:146px;height:32px" data-options="required:true">
				<option>--请选择--</option>
			</select>&nbsp;<a href="javascript:void(0);" class="easyui-linkbutton button-white">放入客户池</a></span></td>
			<td class="tip">客户名称：</td>
			<td><input name="customerVO.name" value="${customerVO.name }"class="easyui-textbox easyui-validatebox" data-options="validType:['chinese'],required:true"/></td>
		</tr>
		<tr>
			<td class="tip">客户行业：</td>
			<td><input name="customerVO.industry" value="${customerVO.industry }" class="easyui-textbox easyui-validatebox" data-options="required:true"/></td>
			<td class="tip">客户信息来源：</td>
			<td><input name="customerVO.orgin" value="${customerVO.orgin }" class="easyui-textbox easyui-validatebox" data-options="required:true"/></td>
		</tr>
		<tr>
			<td class="tip">公司性质：</td>
			<td><input type="radio" value="合资" ${customerVO.ownerShip=='合资'?'checked':'' } name="customerVO.ownerShip">合资&nbsp;
				<input type="radio" value="国企" ${customerVO.ownerShip=='国企'?'checked':'' } name="customerVO.ownerShip">国企&nbsp;
				<input type="radio" value="民营" ${customerVO.ownerShip=='民营'?'checked':'' } name="customerVO.ownerShip">民营</td>
			<td class="tip">邮编：</td>
			<td><input name="customerVO.zipCode" value="${customerVO.zipCode }" class="easyui-textbox easyui-validatebox" data-options="validType:['zipCode'],required:true"/></td>
		</tr>
		<tr>
			<td class="tip">年营业额：</td>
			<td><select class="easyui-combobox" name="customerVO.annualRevenue" style= "width:146px">
				<option value="-1">-请选择-</option>
				<option ${customerVO.annualRevenue=='1000万-3000万'?'selected':'' }>1000万-3000万</option>
				<option ${customerVO.annualRevenue=='3000万-6000万'?'selected':'' }>3000万-6000万</option>
				<option ${customerVO.annualRevenue=='6000万-9000万'?'selected':'' }>6000万-9000万</option>
			</select></td>
			<td class="tip">评分：</td>
			<td><input type="radio" name="customerVO.rating" value="一星" ${customerVO.rating=='一星'?'checked':'' }>一星&nbsp;
				<input type="radio" value="两星" ${customerVO.rating=='两星'?'checked':'' } name="customerVO.rating">二星&nbsp;
				<input value="三星" ${customerVO.rating=='三星'?'checked':'' } type="radio" name="customerVO.rating">三星</td>
		</tr>
		<tr>
			<td class="tip">客户联系地址：</td>
			<td colspan="3">
				<input id="addr1"class="easyui-textbox easyui-validatebox" style="width:100px" data-options="prompt:'省',required:true">
				<input id="addr2" class="easyui-textbox easyui-validatebox" style="width:100px" data-options="prompt:'市',required:true">
				<input id="addr3" class="easyui-textbox easyui-validatebox" style="width:100px" data-options="prompt:'区',required:true">
				<input id="addr4" class="easyui-textbox easyui-validatebox" data-options="prompt:'具体街道信息',required:true">
				<input id="address" name="customerVO.address" value="${customerVO.address }" type="hidden">
			</td>
		</tr>
		<tr><td colspan="4">首要联系人信息</td></tr>
		<tr>
			<td class="tip">姓名：</td>
			<td><input name="customerVO.contacts" value="${customerVO.contacts }" class="easyui-textbox easyui-validatebox" data-options="required:true"></td>
			<td class="tip">称呼：</td>
			<td><input name="customerVO.saltName" value="${customerVO.saltName }"class="easyui-textbox easyui-validatebox" data-options="required:true"></td>
		</tr>
		<tr>
			<td class="tip">邮箱：</td>
			<td><input name="customerVO.email" value="${customerVO.email }" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:'email'"></td>
			<td class="tip">职位：</td>
			<td><input name="customerVO.post" value="${customerVO.post }" class="easyui-textbox easyui-validatebox" data-options="required:true"></td>
		</tr>
		<tr>
			<td class="tip">QQ：</td>
			<td><input name="customerVO.qq" value="${customerVO.qq }" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:['integer']"></td>
			<td class="tip">手机：</td>
			<td><input name="customerVO.mobile" value="${customerVO.mobile }" class="easyui-textbox easyui-validatebox" data-options="required:true,validType:['mobile']"></td>
		</tr>
		<tr>
			<td class="tip">备注：</td>
			<td colspan="3">
				<textarea name="customerVO.descriptionContact" value="${customerVO.descriptionContact }" class="easyui-textbox" data-options="multiline:true" style="width:579px;height:60px;"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4">附加信息</td>
		</tr>
		<tr>
			<td class="tip">员工数：</td>
			<td colspan="3"><input  class="easyui-textbox" name=""></td>
		</tr>
		<tr>
			<td class="tip">备注：</td>
			<td colspan="3">
				<textarea class="easyui-textbox" name="" data-options="multiline:true" style="width:579px;height:60px;"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" style="text-align: center;">
				<a id="save" href="javascript:void(0);" class="easyui-linkbutton button-purple" >保存</a>
				<a id="submit" href="javascript:void(0);" class="easyui-linkbutton button-pink" >保存并新建</a>
				<input class="easyui-checkbox" type="checkbox" name="" value="">同时创建商机
			</td>
		</tr>
	</table>
</form>
</body>
<script type="text/javascript">
    $(function(){

        //修改回显地址

    })
</script>
</html>
