package gb.lesson2.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/header")
public class HeaderServlet extends HttpServlet {
    Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String title = resp.getHeader("Title");
        log.info("Title: " + title);

        resp.getWriter().println("<head>");
        resp.getWriter().println("<title>" + title + "</title>");
        resp.getWriter().println("<link rel='stylesheet' href='" + req.getContextPath() + "/static.css/style.css'>");
        resp.getWriter().println("</head>");
    }
}
