package servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet("/abc")
public class ServletResponse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 等同于sendRedirect
         */
        //response.setStatus(302);
        //response.setHeader("Location","/error");


        /**
         * 当有一个请求到达该servlet时告诉他去请求另外一个url
         */
        //response.sendRedirect("www.baidu.com");等同于上面两句话


        /**
         *
         */
        String encode = URLEncoder.encode("老婆大人.jpg", "utf-8");


        /**
         * Content-Type：用于定义网络文件的类型和网页的编码，决定浏览器将以什么形式、什么编码读取这个文件
         * setCharacterEncoding：作用是设置对客户端请求进行重新编码的编码
         * 是说一个是设置读，一个是设置取
         */
        //response.setContentType("text/html;charset=utf-8");
        //request.setCharacterEncoding("utf-8");


        /**
         * 实现定时多少秒刷新到另一个页面
         */
        //response.setHeader("Refresh","5;url=/abc");


        /**
         * Content-Disposition:是 MIME 协议的扩展，MIME 协议指示 MIME 用户代理如何显示附加的文件。Content-disposition
         * 其实可以控制用户请求所得的内容存为一个文件的时候提供一个默认的文件名，文件直接在浏览器上显示或者在访问时弹出文件下载对话框
         *attachment：表示以附件的方式下载
         *inline：表示在页面内直接下载
         */
        response.setHeader("Content-Disposition","attachment;filename="+encode);

        /**
         * content-type:使用Content-Type来表示具体请求中的媒体类型信息
         */
        response.setHeader("content-type", "image/jpg");

        String path = this.getServletContext().getRealPath("/wife.jpg");
        FileInputStream fileInputStream = new FileInputStream(path);
        byte[] bytes = new byte[1024];
        int len = 0;
        OutputStream os = response.getOutputStream();
        while((len = fileInputStream.read(bytes))>0){
            os.write(bytes,0,len);
        }
        os.close();
        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
