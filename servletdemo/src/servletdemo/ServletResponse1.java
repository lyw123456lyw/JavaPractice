package servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/ServletResponse1")
public class ServletResponse1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        response.setContentType("text/html;charset=utf-8");
        //指定该页面不缓存IE
//        response.setDateHeader("Expires",-1);
        response.setDateHeader("Expires",System.currentTimeMillis()+3600*1000*24);
        //保证兼容性
//        response.setHeader("Cache-Control","no-cache");
//        response.setHeader("Pragma","no-cache");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
