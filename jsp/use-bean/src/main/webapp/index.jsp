<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Message board</title>
</head>
<body>
    <jsp:useBean id="storage" class="pl.edu.ug.introductiontojee.jsp.usebean.MessageStorageService" scope="application" />

    <h2>Message board</h2>
    <br>

    <c:forEach var="message" items="${storage.allMessages}">
        <p>Message: ${message.message}</p>
        <p>Author: ${message.author}</p>
    </c:forEach>

    <br/>

    <p>Add new message:</p>

    <form action="add.jsp" method="post">
        Message: <input type="text" name="message"><br/>
        Author: <input type="text" name="author"><br/>

        <input type="submit" value="Add">
    </form>
</body>
</html>
