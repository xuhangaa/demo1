package interceptor;

import domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrivilegeInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        判断用户有没有登陆，其实就是判断session中有没有user
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        System.out.println("preHandle");
        System.out.println(user);
        if(user==null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }
        //放行 访问目标资源
        return true;
    }
}
