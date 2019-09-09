package servletdemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class MyHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(new Date()+" 时间和主机 1 "+request.getRemoteHost());
        PrintWriter out = response.getWriter();
        //获取请求头的主机信息
        String host = request.getHeader("Host");
        //获取浏览器的Referer,告诉浏览器我们来自哪里
        String referer = request.getHeader("Referer");
        out.println("Referer="+referer);
        System.out.println(referer+"ddddddddddddddddd");
        if(referer == null || !referer.startsWith("http://localhost:8080")){
            response.sendRedirect("/error");
            return;
        }
        out.println("Referer"+referer);
        out.println("host="+host);
        out.println("这是我们非常重要的信息");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println(new Date()+" 时间和主机 2 "+request.getRemoteHost());
    }

}
