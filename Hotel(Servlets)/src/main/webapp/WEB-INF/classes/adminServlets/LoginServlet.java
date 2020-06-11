package adminServlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public static final String password = "q1w2e3r4";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        if(this.password.equals(password)){
            getServletContext().getRequestDispatcher( "/administration/administration.jsp").forward(request, response);
        }else{
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
