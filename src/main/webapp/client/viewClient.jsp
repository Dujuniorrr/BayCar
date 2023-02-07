<%@ page import="model.Sale" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.DAO" %>
<%@ page import="dao.CarDAO" %><%--
  Created by IntelliJ IDEA.
  User: Romily
  Date: 05/02/2023
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Sale> sales = (ArrayList<Sale>) request.getAttribute("sales");%>
<html>
<head>
    <title>View Client</title>
</head>
<body>
    <form class="bg-dark" action="postImg" method="post" enctype="multipart/form-data">
        <input type="file">
        <input type="submit">
    </form>

    <% for (int i = 0; i < sales.size(); i++) { %>
        <p>id = <%= sales.get(i).getId() %></p>
        <p>Data = <%= sales.get(i).getDate() %></p>
        <p>Valor = <%= sales.get(i).getValue() %></p>
        <p>Parcelamento = <%= sales.get(i).getParcel() %></p>


    <% if (new CarDAO().recoverIdCarBySale(sales.get(i).getId()) != null) {%>
        <a href="viewCar?id=<%= new CarDAO().recoverIdCarBySale(sales.get(i).getId()) %>">ver venda</a>
    <%System.out.println(new CarDAO().recoverIdCarBySale(sales.get(i).getId())); } else {%>
        <a href="viewOlderCar?id=<%= new CarDAO().recoverIdOlderCarBySale(sales.get(i).getId()) %>">ver venda</a>
    <% System.out.println(new CarDAO().recoverIdOlderCarBySale(sales.get(i).getId())); }} %>
</body>
</html>
