package by.netcracker.chef.web.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/Controller"})
public class EncodingFilter implements Filter {

    private static Logger logger = LogManager.getLogger(EncodingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.trace("INITIALIZING ENCODING FILTER");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.trace("ENCODING FILTER CALLED");

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.trace("DESTROYING ENCODING FILTER");
    }
}
