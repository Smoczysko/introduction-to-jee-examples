<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
    <jsp:useBean id="storage" class="pl.edu.ug.introductiontojee.jsp.include.MessageStorageService" scope="application" />
    <jsp:useBean id="message" class="pl.edu.ug.introductiontojee.jsp.include.Message" scope="request" />
    <jsp:setProperty name="message" property="*" />

    <%
        storage.add(message);
        response.sendRedirect(request.getContextPath());
    %>
</body>
</html>
