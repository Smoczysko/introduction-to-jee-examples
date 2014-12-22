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
      <h3>Query messages with comments made by:</h3>
      <br/>

      <form action="${pageContext.request.contextPath}/search" method="get" class="form-horizontal">
        <input type="hidden" name="type" value="commentAuthor" />

        <div class="form-group">
          <label for="author" class="col-sm-2 control-label">Author:</label>

          <div class="col-sm-10">
            <input type="text" name="author" id="author" class="form-control">
          </div>
        </div>

        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Search</button>
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