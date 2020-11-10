package gb.lesson3.servlets;

import gb.lesson3.utils.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("Title", Pages.Home.name());

        getServletContext().getRequestDispatcher("/header").include(req, resp);
        getServletContext().getRequestDispatcher("/navigation").include(req, resp);
        resp.getWriter().println("<h1>" + Pages.Home.name() + "</h1>");
        resp.getWriter().println("<h2>" + Pages.Home.name() + "</h2>");
        resp.getWriter().println("<h3>" + Pages.Home.name() + "</h3>");
        resp.getWriter().println("<h4>" + Pages.Home.name() + "</h4>");
        resp.getWriter().println("<h5>" + Pages.Home.name() + "</h5>");
        resp.getWriter().println("<h6>" + Pages.Home.name() + "</h6>");
    }

}
