package cookie;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet("/cookieDemoServlet")
public class CookieDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        /**
         * 解决cookie传中文问题d
         */
        String name = URLEncoder.encode("李依伟", "utf-8");
        //1.创建cookie
        Cookie cookie = new Cookie("user", name);
        //2.设置cookie的生命周期
        cookie.setMaxAge(3600);
        //3.把cookie信息写回给浏览器
        response.addCookie(cookie);
        out.println("创建成功");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
