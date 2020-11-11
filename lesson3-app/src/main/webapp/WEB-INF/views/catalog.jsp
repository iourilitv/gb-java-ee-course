<%@ page import="gb.lesson3.entities.Product" %>
<%@ page import="gb.lesson3.utils.Pages" %>
<%@ page import="gb.lesson3.utils.Attributes" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<c:set var="page" value="${Pages.Catalog.name()}" />
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>
<%--    <jsp:useBean id="request" scope="request" type="java.lang.String"/>--%>

    <title><c:out value="${page}"/></title>
<%--    <title><%request.getAttribute(Attributes.Title.name());%></title>--%>
</head>

<body>

<%--    <h2><%request.getAttribute(Attributes.Title.name());%></h2>--%>
<%--    <h2>page: <%=page%></h2>--%>
    <h2>page: <c:out value="${page}"/></h2>

</body>

</html>