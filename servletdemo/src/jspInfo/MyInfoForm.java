package jspInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 各种表单的提交
 */
@WebServlet("/form")
public class MyInfoForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        /**
         * 表单提交
         */
        out.println("<form action= '/register' method='post' ><br/>");
        out.println("用户名:<input type= 'text' name= 'userName'/><br/> ");
        out.println("密码:<input type= 'password' name= 'pwd'/> <br/>");
        out.println("你的爱好：<input type= 'checkbox' name= 'hobby' value = 'music'/>music");
        out.println("<input type= 'checkbox' name= 'hobby' value = 'PE'/>PE");
        out.println("<input type= 'checkbox' name= 'hobby' value = 'travel'/>travel<br/>");
        out.println("所在城市：<select name= 'city'><option value='bj'>北京</option><option value='cq'>重庆</option></select><br/>" );
        out.println("你的介绍：<textarea cols= '20' rows= '10' name= 'intro'>请输入介绍...</textarea><br/>");
        out.println("提交照片：<input type= 'file' name= 'photo'/><br/>");
        out.println("<input type= 'submit' value= '提交信息'/> ");
        out.println("</form> ");
        out.println("<img src='wife.jpg'> ");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<form action= '/register' method='post' >");
        out.println("用户名:<input type= 'text' name= 'userName'/> ");
        out.println("密码:<input type= 'password' name= 'pwd'/> ");
        out.println("<input type= 'submit' value= '提交信息'/> ");
        out.println("</form> ");
    }
}
