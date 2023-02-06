package controller;

import model.Client;
import model.OlderCar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/addClient", "/dashboardClient"})
public class ControllerClient extends HttpServlet {

    private static final long serialVersionUID = 1L;

    Client client = new Client();

    public ControllerClient() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/addClient")) {
            addClient(response, request);
        } else if (action.equals("/dashboardClient")) {
            dashboardClient(response, request);
        } else {
            response.sendRedirect("home.jsp");
        }
    }

    private void addClient(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String adress = request.getParameter("adress");
        String phone = request.getParameter("phone");
        String cpf = request.getParameter("cpf");

        client.addClient(name, email, adress, phone, cpf);

       response.sendRedirect("dashboardClient");
    }

    private void dashboardClient(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        ArrayList<Client> clients = client.listClients();
        request.setAttribute("clients", clients);
        RequestDispatcher rd = request.getRequestDispatcher("client/dashboardClient.jsp");
        rd.forward(request, response);
    }

}

