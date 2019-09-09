package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieApplication")
public class CookieApplication extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            Cookie[] cookies = request.getCookies();
            boolean flag = false;
            if(cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    String name = cookies[i].getName();
                    if ("last".equals(name)) {
                        out.println("您上次登录的时间为" + cookies[i].getValue());
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
                        String format = simpleDateFormat.format(new Date());
                        Cookie cookieTime = new Cookie("last",format);
                        cookieTime.setMaxAge(10);
                        response.addCookie(cookieTime);
                        flag = true;
                        break;
                    }

                }


            }
            if(!flag){
                out.println("您是首次登录的用户");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
                String format = simpleDateFormat.format(new Date());
                Cookie cookie = new Cookie("last",format);
                cookie.setMaxAge(20);
                response.addCookie(cookie);
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
        }

}
