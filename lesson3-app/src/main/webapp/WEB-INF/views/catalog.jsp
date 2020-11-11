<%@ page import="gb.lesson3.entities.Product" %>
<%@ page import="gb.lesson3.utils.Pages" %>
<%@ page import="gb.lesson3.utils.Attributes" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<c:set var="page" value="${Pages.Catalog.name()}" />

<%-- //TODO error at name if use <jsp:param name="${Attributes.Title.name()}" value="Catalog"/> --%>
    <jsp:include page="frags/header.jsp">
        <jsp:param name="Title" value="${page}"/>
    </jsp:include>

<body>

    <jsp:include page="frags/navigation.jsp">
        <jsp:param name="Title" value="${page}"/>
    </jsp:include>

    <h2><c:out value="${page}"/></h2>

</body>

</html>