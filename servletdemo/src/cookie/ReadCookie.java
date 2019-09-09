package cookie;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/readCookie")
public class ReadCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            /**
             * 对cookie进行解码(base64解码)
             */
            if("name".equals(cookie.getName())){
                String decode = URLDecoder.decode(cookie.getValue(), "utf-8");
                out.println("Cookie的信息 名字"+cookie.getName()+" value"+decode+"</br>");
            }

            out.println("Cookie的信息 名字"+cookie.getName()+"value"+cookie.getValue());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
