<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>학생 등록</title>
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
<h1>학생 <c:out value="${buttonText}" default="등록"/> </h1>
<form method="post" action="${action}">
    <table>
        <tbody>
        <tr>
            <td>아이디</td>
            <td>
                <label>
                    <input type="text" name="id"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>이름</td>
            <td>
                <label>
                    <input type="text" name="name"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>성별</td>
            <td>
                <label>
                    <input type="radio" name="gender" value="man">남
                </label>
                <label>
                    <input type="radio" name="gender" value="woman">여
                </label>
            </td>
        </tr>
        <tr>
            <td>나이</td>
            <td>
                <label>
                    <input type="text" name="age"/>
                </label>
            </td>
        </tr>
        </tbody>
    </table>
    <button id="button" type="submit">
        <c:out value="${buttonText}" default="등록"/>
    </button>
</form>
</body>
</html>
