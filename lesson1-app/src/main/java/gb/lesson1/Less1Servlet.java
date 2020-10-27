package gb.lesson1;

import javax.servlet.*;
import java.io.IOException;

public class Less1Servlet implements Servlet {
    private transient ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        servletResponse.getWriter().println("<h1>Hello from " + this.getClass().getSimpleName() + "!!!</h1>");
    }

    @Override
    public String getServletInfo() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void destroy() {

    }
}
