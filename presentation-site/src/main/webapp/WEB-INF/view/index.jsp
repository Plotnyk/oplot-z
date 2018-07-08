<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Автосервис</title>
</head>
<body>
<div>
    <h1> GET SERVICE LOCATION AVTOMASTERS</h1>
</div>
<div>    <!-- buttons holder -->
    <button onclick="location.href='/city/rest/getAllDBLogsJSON_A'">List company A</button>
    <button onclick="location.href='/rest/getAllDBLogsJSON_B'">List company B</button>
    <button onclick="location.href='/rest/getAllDBLogsJSON'">List company</button>
    <button onclick="location.href='/add'">Add company</button>
</div>
</body>
</html>