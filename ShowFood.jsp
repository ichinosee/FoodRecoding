<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show All Food</title>
</head>
<body>

<table border="1">
<tr><td>NO</td><td>食品名</td><td>カロリー</td></tr>
<c:forEach items="${items}" var="item">
        <tr><td>${item.code}</td><td>${item.name}</td><td>${item.calorie}</td></tr>
</c:forEach>


</table>

</body>
</html>