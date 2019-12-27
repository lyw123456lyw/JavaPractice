package servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Properties;

@WebServlet("/servlet3")
public class Servlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取ServletContext对象引用
        //1.通过this直接获取
        ServletContext servletContext = this.getServletContext();
        String name = this.getServletConfig().getInitParameter("name");
        out.println(name+"全局配置参数");
        //2.获取外部加载文件
        InputStream inputStream = this.getServletContext().getResourceAsStream("dbinfo.propertise");
        //创建Propertise对象
        Properties properties = new Properties();
        properties.load(inputStream);
        out.println("name"+properties.getProperty("username")+"loveFlag:"+properties.getProperty("password"));
        //如果得到一个文件的全路径(项目发布在Tomcat中所以时项目发布的绝对路径)
        String path = this.getServletContext().getRealPath("/imgs/wife.jpg");
        out.println("path="+path);
        //如果需要读取src下的文件就是用如下
        InputStream resourceAsStream = Servlet3.class.getClassLoader().getResourceAsStream("dbinfo.propertise");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    public void init() throws ServletException {
        String path = this.getServletContext().getRealPath("record.txt");
        try{
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String num = bufferedReader.readLine();
            this.getServletContext().setAttribute("nums",num);
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
