<%@ page import="gb.lesson3.utils.Pages" %>

<%-- //TODO does't work the styles from ../style.css --%>
    <ul style= "list-style-type: none">
        <li style= "display: inline-block">
            <a href="${pageContext.request.contextPath}/${Pages.Home.name().toLowerCase()}"><%=Pages.Home.name()%></a>
        </li>

        <li style= "display: inline-block">
            <a href="${pageContext.request.contextPath}/${Pages.Catalog.name().toLowerCase()}"><%=Pages.Catalog.name()%></a>
        </li>

        <li style= "display: inline-block">
            <a href="${pageContext.request.contextPath}/${Pages.Cart.name().toLowerCase()}"><%=Pages.Cart.name()%></a>
        </li>

        <li style= "display: inline-block">
            <a href="${pageContext.request.contextPath}/${Pages.Order.name().toLowerCase()}"><%=Pages.Order.name()%></a>
        </li>

        <li style= "display: inline-block">
            <a href="${pageContext.request.contextPath}/${Pages.About.name().toLowerCase()}"><%=Pages.About.name()%></a>
        </li>
    </ul>
