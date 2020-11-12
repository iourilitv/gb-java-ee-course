<%@ page import="gb.lesson3.entities.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="gb.lesson3.utils.Pages" %>
<%@ page import="gb.lesson3.utils.Attributes" %>
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

    <div class="container">
        <div class="row py-2">
            <div class="col-12">
                <%--   //TODO replace url with a link "/form" to ProductServlet        --%>
                <a class="btn btn-primary" href="product-form.jsp">Add a new Product</a>
            </div>

            <div class="col-12">
                <table class="table table-bordered my-2">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Title</th>
                        <th scope="col">Description</th>
                        <th scope="col">Price</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>

                    <tbody>
<%--                     //TODO  IDEA распознает var только как String --%>
<%--                    <c:forEach var="product" items="${requestScope.get(Attributes.products.name())}">--%>
                        <c:forEach var="product" items="${requestScope.products}">
                        <tr>
                            <td>
                                <c:out value="${product.id}"/>
                            </td>
                            <td>
                                <c:out value="${product.title}"/>
                            </td>
                            <td>
                                <c:out value="${product.description}"/>
                            </td>
                            <td>
                                <c:out value="${product.price}"/>
                            </td>
                            <td>
<%--                                 //TODO Похоже на костыль, но по другому не нашел как сделать разные url на кнопки --%>
                                <c:url value="/product/edit" var="editUrl">
                                    <c:param name="productId" value="${product.id}"/>
                                </c:url>
                                <a class="btn btn-success" href="${editUrl}"><i class="fas fa-edit"></i></a>

                                <c:url value="/product/delete" var="deleteUrl">
                                    <c:param name="productId" value="${product.id}"/>
                                </c:url>
                                <a class="btn btn-danger" href="${deleteUrl}"><i class="far fa-trash-alt"></i></a>

<%--                                <a class="btn btn-success" href="${productUrl + '/form'}"><i class="fas fa-edit"></i></a>--%>
<%--                                <a class="btn btn-danger" href="${productUrl + '/delete'}"><i class="far fa-trash-alt"></i></a>--%>

                            </td>
                        </tr>

                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>

</html>