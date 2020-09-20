<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/food/WEB-INF/css/style.css">
<a href="/food/ShowFoodServlet?action=top">ようこそ！</a>
<c:forEach items="${categories}" var="category">
<a href="/food/ShowFoodServlet?action=list&code=${category.code}"class="pochitto_btn_blue">${category.name}</a>
</c:forEach>
<br>
<a href="/food/CartServlet?action=show">今日食べた食べ物をチェック</a>
