<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import= "model.MyAccount" %>
    
    <%// セッションスコープからユーザー情報を取得
    MyAccount loginUser = (MyAccount) session.getAttribute("loginUser");
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
<h1>ログイン処理</h1>
<% if(loginUser != null) { %>
<p>ログインに成功しました</p>
<p>ようこそ<%= loginUser.getAccID() %>さん</p>
<a href="/MoneyMGR_Sample3/Main">マイページへ</a>
<% } else { %>
<p>ログインに失敗しました</p>
<a href="/MoneyMGR_Sample3/">TOPへ</a>
<% } %>
<a href="/MoneyMGR_Sample3/UserInfo/">登録者一覧</a>
</body>
</html>