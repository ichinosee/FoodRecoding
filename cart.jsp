<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome food record!!</title>
<link rel="stylesheet" type="text/css" href="/food/css/style.css">
</head>
<body>

	<jsp:include page="/menu.jsp" /><br>
	<h3>現在の食べたものリスト</h3>

	<c:if test="${empty cart.items}">
現在カートは空です。
</c:if>

	<c:if test="${not empty cart.items}">
		<table border="1">
			<tr>
				<td>食品番号</td>
				<td>食品名</td>
				<td>カロリー</td>
				<td>個数</td>
				<td>小計</td>
				<td>削除</td>
			</tr>

			<c:forEach items="${cart.items}" var="food">
				<tr>
					<td align="center">${food.value.code}</td>
					<td align="center">${food.value.name}</td>
					<td align="right">${food.value.calorie}cal</td>
					<td align="right">${food.value.quantity}</td>
					<td align="right">${food.value.calorie * food.value.quantity}カロリー</td>
					<td>
						<form action="/food/CartServlet?action=delete" method="post">
							<input type="hidden" name="food_code" value="${food.value.code}">
							<input type="submit" value="削除">
						</form>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td align="right" colspan="6">総計：${cart.total}カロリー</td>
			</tr>
		</table>

		<form action="/food/OrderServlet?action=input_customer"
			method="post">
			<input type="submit" value="記録する">
		</form>
	</c:if>

</body>
</html>