package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sessionToCookieServlet")
public class SessionToCookieServlet extends HttpServlet {
    /**
     *对session的说明
     * 1.session是存放在服务器内存当中，
     * 2.每有一个全新的浏览器访问服务器的时候就会在服务器内存中为它创建一个session对象
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        session.setAttribute("userName","李依伟");

        //把sessionId保存在cookie中
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(1800);
        response.addCookie(cookie);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
