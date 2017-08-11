<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
  <base href="<%=basePath%>">
  <meta charset="utf-8">
  <title>CRM登录</title>
  <script type="text/javascript" src="static/jquery/jquery.min.js"></script>
  <link rel="stylesheet" href="static/css/login.css">
</head>

<body>
  <section class="container">
    <div class="login">
      <h1>登录CRM系统</h1>
      <span id="info"></span>
      <form id="loginForm">
        <p><input type="text" name="username" value="" placeholder="用户名"></p>
        <p><input type="password" name="password" value="" placeholder="密码"></p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me">
            7天内自动登录
          </label>
        </p>
        <p class="submit"><input type="submit" value="登录"></p>
      </form>
    </div>

    <div class="login-help">
      <p>忘记密码? <a href="index.html">点击这里找回</a>.</p>
    </div>
  </section>
  <script type="text/javascript">
    $(function () {
        $("#loginForm").bind("submit", function (even) {
            //阻止默认事件
            even.preventDefault();
            var username = $("input[name='username']").val();
            var password = $("input[name='password']").val();
            if (!username) {
                $("#info").text("请输入用户名!").css("color", "red");
                return;
            }
            if (!password) {
                $("#info").text("请输入密码!").css("color", "red");
                return;
            }

            //登录的ajax请求
            $.post("system/user/login.action", {"user.username":username,"user.password":password}, function (result) {
                if (result.success) {
                    //跳转到主页
                    window.location.href="system/index.action";
                    return;
                }
                //登录失败信息
                $("#info").text(result.message).css("color", "red");
            }, "json");
        })
    })
  </script>
</body>
</html>
