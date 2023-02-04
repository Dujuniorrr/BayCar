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

@WebServlet(urlPatterns = {"/dashboardCar"})
public class ControllerCar extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private boolean login = false;
    public Car car = new Car();

    public ControllerCar() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if(action.equals("/dashboardCar")){
            dashboardCar(request, response);
        }

    }

    public void dashboardCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Car> carsSold = car.listCarSold();
        request.setAttribute("carsSold", carsSold);
        RequestDispatcher rd = request.getRequestDispatcher("car/dashboardCar.jsp");
        rd.forward(request, response);
    }
}
