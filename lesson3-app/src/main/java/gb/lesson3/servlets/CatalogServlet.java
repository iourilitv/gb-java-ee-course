package gb.lesson3.servlets;

import gb.lesson3.repositories.ProductRepository;
import gb.lesson3.utils.Attributes;
import gb.lesson3.utils.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/catalog")
public class CatalogServlet extends HttpServlet {
    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository = (ProductRepository) getServletContext().getAttribute(Attributes.productRepository.name());
        if(productRepository == null) {
            throw new ServletException(Attributes.productRepository.name() + " is not initialized");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("Title", Pages.Catalog.name());
        getServletContext().getRequestDispatcher("/header").include(req, resp);
        getServletContext().getRequestDispatcher("/navigation").include(req, resp);
        resp.getWriter().println("<h1>" + Pages.Catalog.name() + "</h1>");

        try {
            req.setAttribute(Attributes.products.name(), productRepository.findAll());
            getServletContext().getRequestDispatcher("/WEB-INF/views/catalog.jsp").forward(req, resp);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
