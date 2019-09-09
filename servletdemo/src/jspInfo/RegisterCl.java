package jspInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 各种表单提取参数
 */
@WebServlet("/register")
public class RegisterCl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String pwd = request.getParameter("pwd");
        /**
         * 返回的是单个参数的绑定
         */
        String userName = request.getParameter("userName");
        /**
         * 返回的是多个参数的绑定
         */
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            out.println("你的爱好是："+hobby+"<br/>");
        }
        String city = request.getParameter("city");
        String intro = request.getParameter("intro");

        out.println("提交的用户名="+userName+"<br/>");
        out.println("提交的用户名密码="+pwd+"<br/>");
        out.println("你所在的城市="+city+"<br/>");
        out.println("你的简介="+intro+"<br/>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
