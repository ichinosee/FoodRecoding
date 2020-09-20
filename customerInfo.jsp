<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wekcome food recoding!</title>
<link rel="stylesheet" type="text/css" href="/food/css/style.css">
</head>
<body>

	<jsp:include page="/menu.jsp" /><br>
	<h3>選択した食品</h3>

	<c:if test="${not empty cart.items}">
	<table border="1">
		<tr>
			<td>食品番号</td>
			<td>食品名</td>
			<td>カロリー</td>
			<td>個数</td>
			<td>小計</td>
		</tr>

		<c:forEach items="${cart.items}" var="food">
			<tr>
				<td align="center">${food.value.code}</td>
				<td align="center">${food.value.name}</td>
				<td align="right">${food.value.calorie}cal</td>
				<td align="right">${food.value.quantity}</td>
				<td align="right">${food.value.calorie * food.value.quantity}カロリー</td>
			</tr>
		</c:forEach>
		<tr>
			<td align="right" colspan="6">総計：${cart.total}カロリー</td>
		</tr>
	</table>

	<h3>ユーザー情報を入力してください</h3>

	<form action="/food/OrderServlet?action=confirm" method="post">
		<table border="1">
			<tr>
				<td>お名前</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>住所</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>電話番号</td>
				<td><input type="text" name="tel"></td>
			</tr>
			<tr>
				<td>e-mail</td>
				<td><input type="text" name="email"></td>
			</tr>
		</table>
		<input type="submit" value="確認画面へ">
	</form>

	</c:if>

</body>
</html>