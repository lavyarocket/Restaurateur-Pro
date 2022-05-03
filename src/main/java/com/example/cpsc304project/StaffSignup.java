package com.example.cpsc304project;

import database.DatabaseConnectionHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StaffSignup")
public class StaffSignup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LOGGING IN...");
        PrintWriter pw = response.getWriter();

        int staffID = 0;

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("role");
        String phone = request.getParameter("phone");


        pw.println(email + " " + password);

        System.out.println("username: " + email + " password: " + password);

        DatabaseConnectionHandler dbHandler = new DatabaseConnectionHandler();
        dbHandler.login("ora_mahaan29", "a97290894");

        if(staffID != 0) {
            pw.println("login successfully, account id: " + staffID);
            String sidStr = Integer.toString(staffID);
            request.setAttribute("staffID", sidStr);
//            request.getRequestDispatcher("SearchPage.jsp").forward(request, response);
        }
        else {
            pw.println("Wrong password!");
        }
        dbHandler.close();

        pw.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

