package cj.filter;

import javax.servlet.*;
import java.io.IOException;

public class IllegalAccessMenuFilter implements Filter{
    private ServletContext servletContext;

    /**
     * 初始化时，设置context，后来会用来取全局变量
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.print("经过过滤器！");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
