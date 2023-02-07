package controller;

import dao.ClientDAO;
import model.Car;
import model.Client;
import model.OlderCar;

import model.Sale;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/addClient", "/dashboardClient", "/deleteClient", "/viewClient", "/postImg"})
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
        } else if (action.equals("/deleteClient")) {
            deleteClient(response, request);
        } else if (action.equals("/viewClient")) {
            viewClient(response, request);
        } else {
            response.sendRedirect("home.jsp");
        }
    }

    private void viewClient(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        client.recoverClient(request.getParameter("id"));
        ArrayList<Sale> sales = client.recoverSalesByClient();

        request.setAttribute("sales", sales);
        request.setAttribute("client", client);

        RequestDispatcher rd = request.getRequestDispatcher("client/viewClient.jsp");
        rd.forward(request, response);
    }

    private void deleteClient(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        new ClientDAO().deleteClient(request.getParameter("id"));

        response.sendRedirect("dashboardClient");
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

