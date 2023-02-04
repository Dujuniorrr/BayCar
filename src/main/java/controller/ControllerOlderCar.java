package controller;

import model.Car;
import model.OlderCar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/dashboardOlderCar"})
public class ControllerOlderCar extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private boolean login = false;
    public OlderCar olderCar = new OlderCar();

    public ControllerOlderCar() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if(action.equals("/dashboardOlderCar")){
            dashboardOlderCar(request, response);
        }

    }

    public void dashboardOlderCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<OlderCar> olderCarsSold = olderCar.listOlderCarSold();
        ArrayList<OlderCar> olderCarsRented = olderCar.listOlderCarRented();
        request.setAttribute("olderCarsSold", olderCarsSold);
        request.setAttribute("olderCarsRented", olderCarsRented);
        RequestDispatcher rd = request.getRequestDispatcher("olderCar/dashboardOlderCar.jsp");
        rd.forward(request, response);
    }
}
