<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>编辑权限</title>

<meta name="pragma" content="no-cache">
<meta name="cache-control" content="no-cache">
<meta name="expires" content="0">
<%@include file="../../script.html"%>
</head>
<style type="text/css">
.myselect{
	height:30px;
}
</style>

<body style="width:100%;max-width:100%;padding:10px 30px;">
<form id="form" method="post">
<strong>主要信息</strong>
	<section class="info-section">
		
			<table id="tb">
				<tr>
					<td class="text-title">负责人</td>
					<td class="text-content">
						<input type="hidden" name="busiVO.id" value="${busiVO.id }">
						<input type="hidden" name="busiVO.createtime" value="${busiVO.createtime }">
						<input type="hidden" name="busiVO.createById" value="${busiVO.createById }">
						<select class="myselect" name="busiVO.ownerId">
							<option value="-1">请选择负责人</option>
						</select>
					</td>
					<td class="text-title">客户</td>
					<td class="text-content">
						<select class="myselect" name="busiVO.customerId">
							<option value="-1">请选择客户</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="text-title">商机金额</td>
					<td class="text-content">
						<input type="text" name="busiVO.salesprice" value="${busiVO.salesprice }" 
							class="easyui-textbox theme-textbox-radius" data-options="required:false">
					</td>
					<td class="text-title">商机名</td>
					<td class="text-content">
						<input type="text" name="busiVO.name" value="${busiVO.name }" 
							class="easyui-textbox theme-textbox-radius" data-options="required:false">
					</td>
				</tr>
				<tr>
					<td class="text-title">联系人</td>
					<td class="text-content">
						<select class="myselect" name="busiVO.contactsId">
						</select>
							<a href="javascript:void(0)" class="text-title" style="color:blue;">新建</a>
					</td>
					
				</tr>
				<tr>
					<td class="text-title" >合同签订地址</td>
					<td class="text-content" colspan="3">
						<input type="text" style="width:550px;" name="busiVO.contractaddress" value="${busiVO.contractaddress }" 
							class="easyui-textbox theme-textbox-radius" data-options="required:false">
					</td>
				</tr>
				<tr>
					<td class="text-title">商机类型</td>
					<td class="text-content">
						<select class="myselect" name="busiVO.type">
						</select>
					</td>
					<td class="text-title">状态</td>
					<td class="text-content">
						<select class="myselect" name="busiVO.businessStatusId">
						</select>
					</td>
				</tr>
				<tr>
					<td class="text-title">商机来源</td>
					<td class="text-content">
						<select class="myselect" name="busiVO.origin">
						</select>
					</td>
					<td class="text-title">赢单率</td>
					<td class="text-content">
						<input type="text" name="busiVO.gainrate" value="${busiVO.gainrate }" 
							class="easyui-textbox theme-textbox-radius" data-options="required:false">
					</td>
				</tr>
				<tr>
					<td class="text-title">预定成交价</td>
					<td class="text-content">
						<input type="text" name="busiVO.estimateprice" value="${busiVO.estimateprice }" 
							class="easyui-textbox theme-textbox-radius" data-options="required:true">
					</td>
					<td class="text-title">下次联系时间</td>
					<td class="text-content">
						<input class="easyui-datetimebox" name="busiVO.nextsteptime" value="${busiVO.nextsteptime }"
	  					  data-options="required:false,showSeconds:false" style="width:150px">
					</td>
				</tr>
				<tr>
					<td class="text-title">下次联系内容</td>
					<td class="text-content">
						<input type="text" name="busiVO.nextstep" value="${busiVO.nextstep }" 
							class="easyui-textbox theme-textbox-radius" data-options="required:false">
					</td>
					
				</tr>
				
				
				</table>
		
	</section>
	<strong>附加信息</strong>
	<section class="info-section">
			<table>
				<tr>
					<td class="text-title">备注</td>
					<td class="text-content">
						<textarea name="busiVO.description" rows="5" style="width:80%;">${busiVO.description }</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;margin-top: 10px;">
						<a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton button-primary" style="margin-left:-70px;">保存</a> 
						<a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-danger" style="margin-left:30px;">重置</a>
					</td>
				</tr>
				</table>
	</section>
	</form>
	
	<script type="text/javascript">
$(function(){
    //给负责人下拉框填充选项
    $.post("system/user/UserAction_listUser.action",{},function (data) {
		var myselect = $("select:eq(0)");
		$.each(data.data,function (index,obj) {
			myselect.append("<option value='"+obj.id+"'>"+obj.username+"</option>")
        })
    },"json")

    $.post(
        "manage/customer/CustomerAction_findAll.action",
        function(data){
            if(data&&data.data){
                $.each(data.data,function(index,obj){
                    var option;
                    if(""==obj.id){
                        option=$("<option value='"+obj.customerid+"' selected>"+obj.name+"</option>");
                    }else{
                        option=$("<option value='"+obj.customerid+"'>"+obj.name+"</option>");
                    }
                    $("select[name='busiVO.customerId']").append(option);
                })
            }
        },"json"
    )
    if(""){
        fillContacts("");
    }
    //给商机类型下拉框填充选项
    $.post(
        "system/dict/DictAction_findByTypecode.action",
        {
            "typeCode":"businessType"
        },
        function(data){
            if(data&&data.data){
                $.each(data.data,function(index,obj){
                    var option;
                    if(obj.dictname==""){
                        option=$("<option value='"+obj.dictname+"' selected>"+obj.dictname+"</option>");
                    }else{
                        option=$("<option value='"+obj.dictname+"'>"+obj.dictname+"</option>");
                    }
                    $("select[name='busiVO.type']").append(option);
                })
            }
        },"json"
    )
    //给商机状态下拉框填充选项
    $.post(
        "system/dict/DictAction_findByTypecode.action",
        {
            "typeCode":"businessStatus"
        },
        function(data){
            if(data&&data.data){
                $.each(data.data,function(index,obj){
                    var option;
                    if(obj.id==""){
                        option=$("<option value='"+obj.id+"' selected>"+obj.dictname+"</option>");
                    }else{
                        option=$("<option value='"+obj.id+"'>"+obj.dictname+"</option>");
                    }
                    $("select[name='busiVO.businessStatusId']").append(option);
                })
            }
        },"json"
    )
    //给商机来源下拉框填充选项
    $.post(
        "system/dict/DictAction_findByTypecode.action",
        {
            "typeCode":"businessOrigin"
        },
        function(data){
            if(data&&data.data){
                $.each(data.data,function(index,obj){
                    var option;
                    if(obj.dictname==""){
                        option=$("<option value='"+obj.dictname+"' selected>"+obj.dictname+"</option>");
                    }else{
                        option=$("<option value='"+obj.dictname+"'>"+obj.dictname+"</option>");
                    }
                    $("select[name='busiVO.origin']").append(option);
                })
            }
        },"json"
    )







})
//监听客户下拉框的事件，若更改客户则重新给联系人下拉框填充选项
$("select[name='busiVO.customerId']").on("change",function(event){
    var custId=$(this).val();
    fillContacts(custId);
})

//给联系人下拉框填充选项的方法
function fillContacts(id){
    $.post(
        "manage/contacts/ContactsAction_findByCustomer.action",
        {
            "customer.customerid":id
        },
        function(data){
            if(data&&data.data){
                $("select[name='busiVO.contactsId']").empty();
                if(data.data.length){
                    $.each(data.data,function(index,obj){
                        var option;
                        if(obj.id==""){
                            option=$("<option value='"+obj.contactsid+"' selected>"+obj.name+"</option>");
                        }else if(obj.isFirst){
                            option=$("<option value='"+obj.contactsid+"' selected>"+obj.name+"(首要)</option>");
                        }else{
                            option=$("<option value='"+obj.contactsid+"'>"+obj.name+"</option>");
                        }
                        $("select[name='busiVO.contactsId']").append(option);
                    })
                }else{
                    $("select[name='busiVO.contactsId']").append("<option value='-1'>暂无数据</option>");
                }
            }
        },"json"
    )
}



$(function() {
    //重置按钮
    $("#resetBtn").on("click",function(event){
        $("#form").form("reset");
    });
    //保存按钮
    $("#saveBtn").on("click", function(event) {
        $("#form").form("submit", {
            url : "manage/business/BusinessAction_saveOrUpdate.action",
            onSubmit : function() {
                //对表单进行数据校验,如果未通过校验，返回false，阻止表单提交
                return $(this).form("validate");

            },
            success : function(data) {
                //data未服务器端返回的字符串数据，eval将字符串数据转换为json对象
                data = eval("(" + data + ")");
                if (data.success) {
                    $.messager.alert("提示","保存成功","info",function () {
                        parent.closeTopWindow();
                    })

                }
            }
        });
    });


});
//监听客户下拉框的事件，若更改客户则重新给联系人下拉框填充选项


 //给联系人下拉框填充选项的方法

	</script>
</body>
</html>
				