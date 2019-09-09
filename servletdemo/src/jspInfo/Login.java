package jspInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        /**
         * 表单提交
         */
        out.println("<h1>用户登录</h1><br/>");
        out.println("<form action= '/loginDispatcher' method='post' ><br/>");
        out.println("用户名:<input type= 'text' name= 'username'/><br/> ");
        out.println("密码:<input type= 'password' name= 'pwd'/> <br/>");
        out.println("<input type= 'submit' value= '提交信息'/> ");
        out.println("</form> ");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(req,response);
    }
}
