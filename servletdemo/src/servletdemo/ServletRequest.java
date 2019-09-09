package servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/request")
public class ServletRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        /**
         * 返回客户端发送请求的时候完整的URL地址
         */
        StringBuffer ur = request.getRequestURL();

        /**
         * 获取请求资源
         */
        String uri = request.getRequestURI();

        /**
         *获取ip地址
         */
        String ip = request.getRemoteAddr();

        /**
         * 得到请求方的主机名，如果客户机没有在dns上注册就会返回ip地址，如果注册过就返回机器名
         */
        String remoteHost = request.getRemoteHost();

        /**
         在客户机向服务器发送请求的时候服务器始终使用一个端口服务，但是客户机事实上也是随机抓去一个端口来访问的
         */
        int remotePort = request.getRemotePort();

        /**
         * 获取服务器所使用的端口号
         */
        int localPort = request.getLocalPort();

        /**
         * 获取到主机+端口号
         */
        String host = request.getHeader("Host");

        /**
         * 获取请求头里面的所有信息
         */
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println(headerName+" "+request.getHeader(headerName));
        }

        /**
         *
         */


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
