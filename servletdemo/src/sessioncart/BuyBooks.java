package sessioncart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/buyBooks")
public class BuyBooks extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String bookName = request.getParameter("name");
        HttpSession session = request.getSession();
        ArrayList<String> myBooks = (ArrayList<String>) session.getAttribute("myBooks");
        if(myBooks == null){
            myBooks = new ArrayList<String>();
            myBooks.add(bookName);
            session.setAttribute("myBooks",myBooks);
        }else{
            myBooks.add(bookName);
            session.setAttribute("myBooks",myBooks);
        }
        session.setAttribute("myBooks",bookName);
        request.getRequestDispatcher("/showMyCart").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
