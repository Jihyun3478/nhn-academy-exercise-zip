<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="cfmt" uri="http://nhnacademy.com/cfmt" %>

<html>
<head>
    <title>학생 상세 조회</title>
    <link rel="stylesheet" href="/style.css"/>
    <style>
        table {
            width: 800px;
            border-collapse: collapse;
            border: 1px #ccc solid;
        }

        table tr > td, th {
            padding: 5px;
            border: 1px #ccc solid;
        }

        button {
            margin-top: 15px;
        }
    </style>
</head>

<body>
<h1>학생 등록</h1>
    <table>
        <tbody>
            <tr>
                <td>아이디</td>
                <td>
                    <c:out value="${student.id}"/>
                </td>
            </tr>
            <tr>
                <td>이름</td>
                <td>
                    <c:out value="${student.name}"/>
                </td>
            </tr>
            <tr>
                <td>성별</td>
                <td>
                    <c:out value="${student.gender}"/>
                </td>
            </tr>
            <tr>
                <td>나이</td>
                <td>
                    <c:out value="${student.age}"/>
                </td>
            </tr>
            <tr>
                <td>등록일</td>
                <td>
                    ${cfmt:formatDate(student.createdAt, 'yyyy-MM-dd HH:mm:ss')}
                </td>
            </tr>
        </tbody>
    </table>
    <ul>
        <li><a href="/student/list">리스트</a></li>
        <li><a href="/student/update?id=${student.id}">수정</a></li>
        <li>
            <form method="post" action="/student/delete">
                <input type="hidden" name="id" value="${student.id}" />
                <button id="button" type="submit">삭제</button>
            </form>
        </li>
    </ul>
</body>
</html>
