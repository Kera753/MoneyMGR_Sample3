<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.MyAccount,model.FriendAccount,java.util.List" %>
<%
// セッションスコープに保存されたユーザー情報を取得
MyAccount loginUser = (MyAccount) session.getAttribute("loginUser");
// アプリケーションスコープに保存されたともだちリストを取得
List<FriendAccount> friendList =
(List<FriendAccount>) application.getAttribute("friendList");
// リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<h1>マイページ</h1>
<p>
<%= loginUser.getAccName() %>さん、ログイン中
<a href="//MoneyMGR_Sample3/Logout">ログアウト</a>
</p>
<p><a href="//MoneyMGR_Sample3/Main">更新</a></p>
<h2>貸す金額</h2>
<form action="/MoneyMGR_Sample3/Main" method="post">
<input type="text" name="creditValue">
<input type="submit" value="決定">
<br>
<h2>借りた金額</h2>
<input type="text" name="debtValue">
<input type="submit" value="決定">

</form>


<%
String creditV = request.getParameter("creditValue");
String  debtV= request.getParameter("debtValue");
%>

<h3> 貸金は<%= creditV %> </h3>
<h3> 借金は<%= debtV %> </h3>




<% if(errorMsg != null){ %>
<p><%= errorMsg %></p>
<% } %>



</body>
</html>