<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title>Oleg</title>

    <link href="/css/bootstrap.css" type="text/css" rel="stylesheet" />
    <script src="/js/jquery-3.1.0.min.js" ></script>
    <script src="/js/bootstrap.min.js" ></script>

</head>
<body>

<div>
    <h3>${pageContext.request.userPrincipal.name}</h3>
    <sec:authorize access="!isAuthenticated()">
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="upload" type="button" class="btn btn-primary">File upload</a></h4>
        <h4><a href="/downloading" type="button" class="btn btn-warning">All files</a></h4>

        <h4><a href="/logout">Выйти</a></h4>
    </sec:authorize>
    <h4><a href="/admin">Delete Files (only admin)</a></h4>
</div>

</body>
</html>