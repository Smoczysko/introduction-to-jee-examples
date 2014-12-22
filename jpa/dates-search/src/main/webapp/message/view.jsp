<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../parts/head.jsp" />
</head>

<body>

<jsp:include page="../parts/navbar.jsp" />

<div class="container">
    <div class="row">
        <h3>Message</h3>
        <br/>

        <p>Title:</p>
        <div class="well well-sm">${message.title}</div>

        <p>Author:</p>
        <div class="well well-sm">${message.author}</div>

        <p>Created:</p>
        <div class="well well-sm">${message.createdAt}</div>

        <p>Message:</p>
        <div class="well well-lg">${message.message}</div>
    </div>

    <hr>

    <jsp:include page="../parts/footer.jsp" />
</div>

<jsp:include page="../parts/scripts.jsp" />
</body>
</html>