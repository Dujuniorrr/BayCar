<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
        String manager = (String) session.getAttribute("manager");
        if(manager == null){
            response.sendRedirect("login.jsp");
        }
 %>
