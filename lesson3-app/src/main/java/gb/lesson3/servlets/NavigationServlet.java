package gb.lesson3.servlets;

import gb.lesson3.utils.Pages;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/navigation")
public class NavigationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String liBeginning = "<li><a href='" + req.getContextPath() + "/%s'>%s</a></li>";
        resp.getWriter().println("<ul>");
        resp.getWriter().printf(liBeginning, Pages.Home.name().toLowerCase(), Pages.Home.name());
        resp.getWriter().printf(liBeginning, Pages.Catalog.name().toLowerCase(), Pages.Catalog.name());
        resp.getWriter().printf(liBeginning, Pages.Product.name().toLowerCase(), Pages.Product.name());
        resp.getWriter().printf(liBeginning, Pages.Cart.name().toLowerCase(), Pages.Cart.name());
        resp.getWriter().printf(liBeginning, Pages.Order.name().toLowerCase(), Pages.Order.name());
        resp.getWriter().println("</ul>");
    }
}
