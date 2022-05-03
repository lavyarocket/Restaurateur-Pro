package com.example.cpsc304project;

import database.DatabaseConnectionHandler;
import model.CustomerAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CustomerLogin", value = "/CustomerLogin")
public class CustomerSignup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseConnectionHandler dbHandler = new DatabaseConnectionHandler();
        dbHandler.login("ora_mahaan29", "a97290894");


        System.out.println("LOGGING IN...");
        PrintWriter pw = response.getWriter();

        int customerID = 0;

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");


        CustomerAccount newCustomer = new CustomerAccount(customerID, name, email, password, address, phone);



        pw.println(email + " " + password);

        System.out.println("email: " + email + " password: " + password);


        dbHandler.insertCustomer(newCustomer);

        System.out.println("Sign Up Successful!");

        dbHandler.close();
        pw.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

