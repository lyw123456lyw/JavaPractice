package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/sessionServlet")
public class SessionServlet extends HttpServlet {
    /**
     *对session的说明
     * 1.session是存放在服务器内存当中，
     * 2.每有一个全新的浏览器访问服务器的时候就会在服务器内存中为它创建一个session对象
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        /**
         * 访问session，当发现没有session的时候，就会自动创建session
         * request.getSession(false)如果当前HTTPSession中没有值就不创建。若存在会话则返回该会话，否则返回NULL
         */
        //HttpSession sessionFalse = request.getSession(false);
        HttpSession session = request.getSession();

        /**
         * 往session中设置值以及取值
         */
        session.setAttribute("userName","李依伟");
        session.getAttribute("userName");

        /**
         * 设置session的生命周期
         */
        session.setMaxInactiveInterval(3600);

        /**
         * session失效的几种情况
         * 1.重启web服务器，关闭网页
         * 2.设置session过期时间，如果在session设置时间不操作session就会失效
         * 3.函数调用，通过invalidate方法设置使所有的session都失效。常用于安全退出
         * 4.使session的某个属性失效,使用removeAttribute()方法
         */
        //session.invalidate();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
