package lml.lml.filter;

import lml.lml.domain.User;
import lml.lml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author lml
 */
@Component
@WebFilter(filterName = "base",urlPatterns = "/*")
public class BaseFilter  implements Filter {

    @Autowired
    UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----------------------->过滤器被创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, GET");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
//        filterChain.doFilter(servletRequest,servletResponse);
//        String curOrigin = request.getHeader("Origin");
//        System.out.println("###跨域过滤器->当前访问来源->"+curOrigin+"###");


        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        try{
            request.getSession().getAttribute("page").toString();
        }catch (NullPointerException e){
            request.getSession().setAttribute("page",0);
            e.printStackTrace();
        }


        if("/login".equals(request.getServletPath())||"/loginCheck".equals(request.getServletPath())){
            System.out.println("您正在登陆login");
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            try {
                String id=request.getSession().getAttribute("account").toString();
                String pw=request.getSession().getAttribute("password").toString();
                User user=new User();
                user.setUserAccount(id);
                user.setPassword(pw);
                if(userService.loginCheck(user)){
                    System.out.println("xxxxxx是"+request.getSession().getAttribute("1"));
                    filterChain.doFilter(servletRequest, servletResponse);
                }else {
                    response.sendRedirect("/login");
                }

            }
            catch (NullPointerException e){
                response.sendRedirect("/login");
                e.printStackTrace();
            }

        }

    }

    @Override
    public void destroy() {

    }
}
