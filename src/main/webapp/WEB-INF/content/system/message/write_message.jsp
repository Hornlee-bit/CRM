<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'list_message.jsp' starting page</title>

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
<style type="text/css">
    table{
        margin:auto;
    }
    #select{
        width:85%;
        height:30px;
        border:0.5px solid gray;
    }
</style>
<body>
<section class="info-section">
    <form id="form" method="post">
        <table>
            <tr>
                <td class="text-title">用户名：</td>
                <td class="text-content">
                    <select name="messageVO.userByTouserId" id="select">
                        <option value="-1">请选择收件人</option>
                        <c:forEach items="${list}" var="user" >
                            <option value="${user.id}">${user.username}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="text-title">内容：</td>
                <td class="text-content">
                    <textarea rows="10"  cols="50" name="messageVO.content"  class="theme-textbox-radius"
                    >
                              </textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;margin-top: 10px;">
                    <a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton button-primary">发送</a>
                    <a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-danger">重置</a>
                </td>
            </tr>
        </table>
    </form>
</section>
<script type="text/javascript">
    $(function() {
        //重置按钮
        $("#resetBtn").on("click",function(){
            $("#form").form("reset");
        });
        //保存按钮
        $("#saveBtn").on("click", function() {
            $("#form").form("submit", {
                url : "system/message/MessageAction_save.action",
                onSubmit : function() {
                    //对表单进行数据校验,如果未通过校验，返回false，阻止表单提交
                    return $(this).form("validate");

                },
                success : function(data) {
                    //data未服务器端返回的字符串数据，eval将字符串数据转换为json对象
                    data = eval("(" + data + ")");
                    if (data.success) {
                            $.messager.alert("SUCCESS","添加成功！","info",function () {
                                parent.closeTopWindow();
                            })
                        }
                    }
            });
        });
    });
</script>
</body>
</html>