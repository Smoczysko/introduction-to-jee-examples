<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="parts/head.jsp" />
</head>

<body>

<jsp:include page="parts/navbar.jsp" />

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h3>Rename author "<%= request.getParameter("author") %>":</h3>
            <br/>

            <form action="${pageContext.request.contextPath}/bulk" method="post" class="form-horizontal">
                <input type="hidden" name="action" value="rename" />
                <input type="hidden" name="author" value="<%=request.getParameter("author")%>">

                <div class="form-group">
                    <label for="newName" class="col-sm-2 control-label">New name:</label>

                    <div class="col-sm-10">
                        <input type="text" name="newName" id="newName" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Rename</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <hr>

    <jsp:include page="parts/footer.jsp" />
</div>

<jsp:include page="parts/scripts.jsp" />
</body>
</html>