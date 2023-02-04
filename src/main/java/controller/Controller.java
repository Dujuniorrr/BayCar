package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private boolean login = false;

    public Controller() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
            if(action.equals("/login")){
                response.sendRedirect("login.jsp");
            }
            else {
                response.sendRedirect("home.jsp");
            }
    }

}