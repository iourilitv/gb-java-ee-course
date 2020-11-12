package gb.lesson4.servlets;

import gb.lesson4.repositories.ProductRepository;
import gb.lesson4.entities.Product;
import gb.lesson4.utils.Attributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/product/edit", "/product/delete"})
public class ProductServlet extends HttpServlet {
    Logger log = LoggerFactory.getLogger(this.getClass());

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
        try {
            String servletPath = req.getServletPath();
            log.info("****** servletPath: " + servletPath);

            log.warn("**** prodId=" + req.getParameter(Attributes.productId.name()));

            Integer prodId = Integer.valueOf(req.getParameter(Attributes.productId.name()));
            if(servletPath.contains("edit")) {
                Product product = productRepository.findById(prodId)
                        .orElseThrow(() -> new RuntimeException("Product with id=" + prodId + " was not found!"));
                req.setAttribute(Attributes.product.name(), product);
                getServletContext().getRequestDispatcher("/WEB-INF/views/product-details.jsp").forward(req, resp);
            } else if(servletPath.contains("delete")) {
                productRepository.delete(prodId);
                getServletContext().getRequestDispatcher("/catalog").forward(req, resp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
