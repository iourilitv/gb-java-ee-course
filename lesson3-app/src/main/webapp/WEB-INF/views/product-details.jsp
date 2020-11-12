<%@ page import="gb.lesson3.utils.Pages" %>
<%@ page import="gb.lesson3.utils.Attributes" %>
<%@ page import="gb.lesson3.entities.Product" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<c:set var="page" value="${Pages.Product.name()}" />

<jsp:include page="frags/header.jsp">
    <jsp:param name="Title" value="${page}"/>
</jsp:include>

<body>
    <jsp:include page="frags/navigation.jsp">
        <jsp:param name="Title" value="${page}"/>
    </jsp:include>

    <h2><c:out value="${page}"/></h2>

<%--    //TODO Как привести значение к Product? --%>
<%--    Почему-то product IDEA распознает как String. Но, тем не менее, работает --%>
    <c:set var="prod" scope="page" value="${requestScope.get(Attributes.product.name())}" property=""/>
    <div>
        <label>Id</label>
<%--        <h3><c:out value="${requestScope.get(Attributes.product.name()).id}"/></h3>--%>
        <h3><c:out value="${prod.id}"/></h3>
    </div>

    <div>
        <label>Title</label>
<%--        <h3><c:out value="${requestScope.get(Attributes.product.name()).title}"/></h3>--%>
        <h3><c:out value="${prod.title}"/></h3>
    </div>

    <div>
        <label>Description</label>
<%--        <h3><c:out value="${requestScope.get(Attributes.product.name()).description}"/></h3>--%>
        <h3><c:out value="${prod.description}"/></h3>
    </div>

    <div>
        <label>Price</label>
<%--        <h3><c:out value="${requestScope.get(Attributes.product.name()).price}"/></h3>--%>
        <h3><c:out value="${prod.price}"/></h3>
    </div>

    <a class="btn btn-success" href="${pageContext.request.contextPath}/catalog"><i class="fas fa-window-close"></i></a>

</body>
</html>
