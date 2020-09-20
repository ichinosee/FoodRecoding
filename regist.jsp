<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome food recoding!!</title>
<link rel="stylesheet" type="text/css" href="/food/css/style.css">
</head>
<body>

<jsp:include page="/menu.jsp"/><br>
<h3>お疲れ様でした！！</h3>
レコーディングをした方はこれまでで
<h3><font color="red">${orderNumber}番目</font></h3>
になります！！
</body>
</html>