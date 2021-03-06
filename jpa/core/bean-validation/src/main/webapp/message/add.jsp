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
        <div class="col-md-12">
            <h3>Add message:</h3>
            <br/>

            <form action="${pageContext.request.contextPath}/add" method="post" class="form-horizontal">
                <c:choose>
                    <c:when test="${errors.size() > 0}">
                        <c:forEach var="error" items="${errors}">
                            <div class="alert alert-danger" role="alert">${error}</div>
                        </c:forEach>
                    </c:when>
                </c:choose>

                <div class="form-group">
                    <label for="title" class="col-sm-2 control-label">Title:</label>

                    <div class="col-sm-10">
                        <input type="text" name="title" id="title" value="${message.title}" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <label for="message" class="col-sm-2 control-label">Message:</label>

                    <div class="col-sm-10">
                        <input type="text" name="message" id="message" value="${message.message}" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <label for="author" class="col-sm-2 control-label">Author:</label>

                    <div class="col-sm-10">
                        <input type="text" name="author" id="author" value="${message.author}" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Save</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <hr>

    <jsp:include page="../parts/footer.jsp" />
</div>

<jsp:include page="../parts/scripts.jsp" />
</body>
</html>