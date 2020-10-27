<%--
  Created by IntelliJ IDEA.
  User: benon94
  Date: 2020/3/10
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>自助平台</title>
    <link href="<%=basePath%>css/mui.min.css" rel="stylesheet" />
    <link href="<%=basePath%>css/style.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>layui/mobile/need/layer.css"/>
    <script type="text/javascript" src="<%=basePath%>layui/mobile/layer.js"></script>
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <h1 class="mui-title">登录</h1>
</header>

<div class="mui-content">
    <form id='Form1' class="mui-input-group" method="post" action="<%=basePath%>User/bind" >
        <div class="mui-input-row">
            <label>账号</label>
            <input id="account" name="account" type="text" class="mui-input-clear mui-input" placeholder="请输入您的账号" />
        </div>
        <div class="mui-input-row">
            <label>密码</label>
            <input id="password" name="password" type="password" class="mui-input-clear mui-input " placeholder="请输入您的密码" />
        </div>
        <div class="mark" style="width: 80%; height: 30px; padding: 15px 15px; color: red;"> ${tips}</div>
        <input style="display: none" name="bind" value="${bind}">
        <div>
            <input type="hidden" id="openid" />
            <input type="hidden" id="wechatName" />
        </div>
        <div class="mui-content-padded">
            <button id='login' class="mui-btn mui-btn-block mui-btn-primary" type="button">登录</button>

        </div>

    </form></div>
<div class="link-area"><a id='Up' href="Password.aspx">修改密码</a>
</div>
<div class="mui-content-padded oauth-area">

</div>
</body>
<script src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script>
    document.querySelector('#account').addEventListener('blur', function () {
        this.placeholder = '请输入您的用户名';
        if (this.value == '') {
            layer.open({
                content: 'err:用户名不可为空'
                ,btn: '我知道了'
            });
        }else{
            if(this.value.indexOf(" ") == -1){
                this.value = this.value.toUpperCase();
            }else{
                layer.open({
                    content: '用户名带有空格，请清除'
                    ,btn: '我知道了'
                });
            }
        }
    });
    document.querySelector('#password').addEventListener('blur', function () {
        this.placeholder = '请输入您的密码';
        var account = document.getElementById("account");
        if (account.value == '') {
            layer.open({
                content: 'err:用户名不可为空'
                ,btn: '我知道了'
            });
        } else if (this.value == '') {
            layer.open({
                content: 'err:密码不能为空'
                ,btn: '我知道了'
            });
        }
    });
    document.querySelector('#login').addEventListener('click',function (evt) {
        $.ajax({
            type: "post",
            url: '<%=basePath%>login',
            data: {
                'account': document.querySelector('#account').value,
                'password': document.querySelector('#password').value
            },
            async: true,
            //contentType: "application/json;charset=utf-8",
            success: function(result) {
                alert(result);
            }
        });
    })

</script>
<script src="<%=basePath%>js/mui.min.js"></script>
<script src="<%=basePath%>js/mui.enterfocus.js"></script>
<script src="<%=basePath%>js/app.js"></script>
</html>
