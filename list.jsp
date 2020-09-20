<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食品一覧</title>
<link rel="stylesheet" type="text/css" href="/food/css/style.css">
</head>
<body>

	<jsp:include page="/menu.jsp"/>

	<h3>食品一覧</h3>
	<c:forEach items="${items}" var="food">
		<form action="/food/CartServlet?action=add" method="post">
		<input type="hidden" name="food_code" value="${food.code}">
		食品番号:<b>${food.code}</b>
		<br>
		食品名:<b>${food.name}</b>
		<br>
		カロリー:<b>${food.calorie}cal</b>
		<br>
		個数: <select name="quantity">
			<option value="1">1
			<option value="2">2
			<option value="3">3
			<option value="4">4
			<option value="5">5
		</select> 個<br>
		<input type="submit" value="食べたのもに追加"> </form>
	</c:forEach>
</body>
</html>