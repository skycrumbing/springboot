package com.how2java.springboot.filter;

import com.how2java.springboot.web.UserController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/9/14 0014.
 * 同源策略[same origin policy]是浏览器的一个安全功能，不同源的客户端脚本在没有明确授权的情况下，不能读写对方资源。 同源策略是浏览器安全的基石。
 * 源[origin]就是协议、域名和端口号。例如：http://www.baidu.com:80这个URL
 * 哪些操作不受同源策略限制：1，页面中的链接，重定向以及表单提交是不会受到同源策略限制的。2，跨域资源的引入是可以的。但是JS不能读写加载的内容。
 * 受前面所讲的浏览器同源策略的影响，不是同源的脚本不能操作其他源下面的对象。想要操作另一个源下的对象就需要跨域。 在同源策略的限制下，非同源的网站之间不能发送 AJAX 请求。
 */
@WebFilter(filterName="corsFilter",urlPatterns = "/*")
public class CorsFilter implements Filter {
    private static final Logger log = Logger.getLogger(UserController.class);
    private String allowOrigin;
    private String allowMethods;
    private String allowCredentials;
    private String allowHeaders;
    private String exposeHeaders;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");//允许访问的客户端域名
        //允许访问的方法名,浏览器会向所请求的服务器发起两次请求，第一次是浏览器使用OPTIONS方法发起一个预检请求，
        // 第二次才是真正的异步请求，第一次的预检请求获知服务器是否允许该跨域请求：如果允许，才发起第二次真实的请求；
        // 如果不允许，则拦截第二次请求。
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        //用来指定本次预检请求的有效期，单位为秒，，在此期间不用发出另一条预检请求。
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        //是否允许请求带有验证信息，若要获取客户端域下的cookie时，需要将其设置为true；
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        //允许服务端访问的客户端请求头，多个请求头用逗号分割，例如：Content-Type；
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Token");
        //Access-Control-Expose-Headers:该字段可选。CORS请求时，XMLHttpRequest对象的getResponseHeader()方法只能拿到6个基本字段：Cache-Control、Content-Language、
        // Content-Type、Expires、Last-Modified、Pragma。如果想拿到其他字段，就必须在Access-Control-Expose-Headers里面指定。
        log.debug("com/how2java/springboot/filter");
        filterChain.doFilter(servletRequest,httpServletResponse);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("我是filter");
    }

    @Override
    public void destroy() {

    }
}
