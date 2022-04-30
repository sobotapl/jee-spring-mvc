
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>

    <tr>
    <c:forEach var="quote" items="${quotes}">
        <th>Autor</th>
        <th>Cytat</th>
    </tr>
    <c:forEach var="quote" items="${quotes}">
    <tr>
        <td>${quote.author}</td>
        <td>${quote.content}</td>
    <tr>
        </c:forEach>
</table>



</body>
</html>
