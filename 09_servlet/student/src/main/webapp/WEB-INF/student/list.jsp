<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>학생 목록 조회</title>
    <link rel="stylesheet" href="/style.css"/>
    <style>
        table {
            width: 800px;
            border-collapse: collapse;
            border:1px #ccc solid;
        }
        table tr>td,th{
            padding:5px;
            border:1px #ccc solid;
        }
    </style>
</head>

<body>
<h1>학생 리스트</h1>
<p><a href="/student/register">학생(등록)</a></p>
<table>
    <thead>
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>성별</th>
        <th>나이</th>
        <th>cmd</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${studentList}">
        <tr>
            <td>${item.id}</td>
            <td style="text-align: center">${item.name}</td>
            <td style="text-align: center">${item.gender}</td>
            <td style="text-align: center">${item.age}</td>
            <td style="text-align: center"><a href="/student/view?id=${item.id}">조회</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
