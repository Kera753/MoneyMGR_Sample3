<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.MyAccount" %>
<%
MyAccount registerUser = (MyAccount) session.getAttribute("registerUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録</title>
<link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
<p>下記のユーザーを登録します</p>
<p>
ログインID：<%= registerUser.getAccID() %><br>
名前:<%= registerUser.getAccName() %><br>
</p>
</body>
</html>