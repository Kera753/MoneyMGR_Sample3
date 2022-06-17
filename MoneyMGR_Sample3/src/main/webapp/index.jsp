<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お金情報記録アプリ</title>
</head>
<body>
<!-- 見出しもじ -->
<h1>お金情報記録アプリへようこそ</h1>
<!-- ログインフォーム -->
<form action="/MoneyMGR_Sample3/LoginServlet" method="post">
ID：<input type="text" name="accID"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="ログイン">

<a href="/MoneyMGR_Sample3/RegisterUser">ユーザ登録する</a>


</form>
</body>
</html>