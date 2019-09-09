package jspInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/loginDispatcher")
public class LoginDispatcher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //接受用户名
        String username = request.getParameter("username");
        //把username放进request域对象中
        request.setAttribute("redrecitName",username);
        /**
         * 表示使用转发的方法，把request和response对象传递给下一个Servlet
         * response.sendRedirect和request.getRequestDispatcher("/loginDispatcherDestination").forward(request,response)的区别
         * 1.使用forword不能转发带该web应用外的url
         * 2.因为forword时发生在web服务器，所以在在转发到另一个资源的时候是使用的同一个request和response对象
         * 3.使用sendRedirect不能够通过request.setAttribute把属性传递给下一个servlet.因为它会将请求重新返回给浏览器去重新访问url,就相当于改变浏览器的地址栏页面
         * 4.forword转向的时候浏览器地址栏是第一次访问的url
         */
        //response.sendRedirect("https://www.baidu.com/");
        request.getRequestDispatcher("/loginDispatcherDestination").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
