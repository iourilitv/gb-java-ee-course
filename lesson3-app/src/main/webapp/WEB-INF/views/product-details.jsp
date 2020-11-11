<%@ page import="gb.lesson3.utils.Pages" %>
<%@ page import="gb.lesson3.utils.Attributes" %>
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
<%--    Почему-то product распознается как String --%>
    <c:set var="product" value="${requestScope.get(Attributes.product.name())}"/>
    <div>
        <label>Id</label>
        <h3><c:out value="${product.id}"/></h3>
    </div>

    <div>
        <label>Id</label>
        <h3><c:out value="${product.title}"/></h3>
    </div>

    <div>
        <label>Id</label>
        <h3><c:out value="${product.description}"/></h3>
    </div>

    <div>
        <label>Id</label>
        <h3><c:out value="${product.price}"/></h3>
    </div>

    <a class="btn btn-success" href="${pageContext.request.contextPath}/catalog"><i class="fas fa-window-close"></i></a>

</body>
</html>
