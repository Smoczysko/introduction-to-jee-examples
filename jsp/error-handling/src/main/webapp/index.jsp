<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page errorPage="error.jsp" %>

<html>
<head>
    <title>Message board</title>
</head>
<body>
    <jsp:useBean id="storage" class="pl.edu.ug.introductiontojee.jsp.error.MessageStorageService" scope="application" />

    <h2>Message board</h2>
    <br>

    <c:forEach var="message" items="${storage.getAllMessages}">
        <p>Message: ${message.message}</p>
        <p>Author: ${message.author}</p>
    </c:forEach>
</body>
</html>
