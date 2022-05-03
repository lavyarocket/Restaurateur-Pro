package database;

import model.CustomerAccount;
import model.StaffAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DatabaseConnectionHandler {

    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";

    private Connection connection = null;

    public DatabaseConnectionHandler() {
        try {
            // Load the Oracle JDBC driver
            // Note that the path could change for new drivers
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (Exception e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }


    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void insertCustomer(CustomerAccount newAccount) {

        int customerID=0;

        try {
            Statement stmt = connection.createStatement();

            String sql = "SELECT CUSTOMERID FROM CUSTOMER ORDER BY CUSTOMERID DESC LIMIT 1";
            ResultSet result = stmt.executeQuery(sql);
            if(result.next()){
                customerID = result.getInt("customerID");
                customerID++;
            }
            else {
                customerID = 100;
            }

        } catch (Exception e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }


        try {
            // Insert customerID, name, email, password, address, phone into CustomerAccount table
            PreparedStatement ps = connection.prepareStatement("INSERT INTO CUSTOMER VALUES (ltrim(rtrim(?, ' '), ' '),ltrim(rtrim(?, ' '), ' '),ltrim(rtrim(?, ' '), ' '),ltrim(rtrim(?, ' '), ' '),ltrim(rtrim(?, ' '), ' '),ltrim(rtrim(?, ' '), ' '))");
            ps.setInt(1, customerID);
            ps.setString(2, newAccount.getName());
            ps.setString(3, newAccount.getEmail());
            ps.setString(4, newAccount.getAddress());
            ps.setString(5, newAccount.getPhone());
            ps.setString(6, newAccount.getPassword());

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }

    }

    public void deleteOrder(int OrderNo) {

        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM ORDERPLACED WHERE OrderNo = ?");
            ps.setInt(1, OrderNo);
            ps.executeUpdate();
            connection.commit();

            ps.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void updateOrderStatus(int OrderNo, String orderStatus) {

        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE CUSTOMER SET ORDERSTATUS = ? WHERE ORDERNO = ?");
            ps.setString(1, orderStatus);
            ps.setInt(2, OrderNo);
            ps.executeUpdate();
            connection.commit();

            ps.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void insertStaff(StaffAccount newAccount, int previousStaffID) {
        int staffID = previousStaffID+1;

        try {
            // Insert staffID, name, email, password, role, phone into CustomerAccount table
            PreparedStatement ps = connection.prepareStatement("INSERT INTO STAFF VALUES (ltrim(rtrim(?, ' '), ' '),ltrim(rtrim(?, ' '), ' '),ltrim(rtrim(?, ' '), ' '),ltrim(rtrim(?, ' '), ' '),ltrim(rtrim(?, ' '), ' '),ltrim(rtrim(?, ' '), ' '))");
            ps.setInt(1, staffID);
            ps.setString(2, newAccount.getName());
            ps.setString(3, newAccount.getEmail());
            ps.setString(4, newAccount.getPassword());
            ps.setString(5, newAccount.getRole());
            ps.setString(6, newAccount.getPhone());

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }

    }

    public int customerLogin(String email, String password) {
        int customerID = 0;
        try{
            Statement stmt = connection.createStatement();
            String sql = "SELECT CUSTOMERID FROM ORA_MAHAAN29.CUSTOMER where EMAIL = '" + email +"' AND PASSWORD = '" + password +"'" ;
            ResultSet result = stmt.executeQuery(sql);
            if(result.next()){
                customerID = result.getInt("customerID");
                System.out.println("customerID: " + customerID);
            }
            else {
                System.out.println("Wrong email/password");
            }

            PreparedStatement ps = connection.prepareStatement("SELECT CUSTOMERID FROM ORA_MAHAAN29.CUSTOMER WHERE EMAIL = ? AND PASSWORD = ?");
            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                customerID = rs.getInt("CustomerID");
                System.out.println("CustomerID: " + customerID + " email: " + email);
            }
        }
        catch (Exception e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
        return customerID;
    }

    public CustomerAccount getCustomerProfile(int customerID) {
        CustomerAccount myCustomer;
        String name = "";
        String email = "";
        String password = "";
        String address = "";
        String phone = "";

        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT NAME FROM CUSTOMER WHERE CUSTOMERID = " + customerID;
            ResultSet result = stmt.executeQuery(sql);
            if(result.next()) {
                System.out.println("Customer Name: " + result.getString("Name"));
            }

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM CUSTOMER WHERE CUSTOMERID = ? ");
            ps.setInt(1, customerID);

            ResultSet rs = ps.getResultSet();
            if(rs.next()) {
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
                address = rs.getString("address");
                phone = rs.getString("phone");

            }
            ps.close();
        } catch (Exception e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }

        myCustomer = new CustomerAccount(customerID, name, email, password, address, phone);
        return myCustomer;
    }

    public Object getItemInfo(int itemID) {

        String title="";
        String price = "";

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT TITLE, PRICE FROM ITEM WHERE ITEMID = ?");
            ps.setInt(1, itemID);

            ResultSet rs = ps.getResultSet();

            if(rs.next()) {
                title = rs.getString("title");
                price = rs.getString("price");
            } else {
                System.out.println("Item does not exist.");
            }

            ps.close();

            return new String[]{title, price};

        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Object CustomersPlacedOrder(int customerID) {

        String name = "";
        String email = "";

        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT NAME, EMAIL FROM CUSTOMER C JOIN ORDERPLACED O ON C.CUSTOMERID = O.CUSTOMERID";
            ResultSet result = stmt.executeQuery(sql);

            if(result.next()) {
                name = result.getString("name");
                email = result.getString("email");
            } else {
                System.out.println("No customers placed an order.");
            }

            return new String[]{name, email};

        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //Aggregation with group by
    public int NumberOfItems(int itemID) {

        int numberOfItems = 0;

        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT COUNT(itemID) FROM ITEM GROUP BY TAG";
            ResultSet result = stmt.executeQuery(sql);

            numberOfItems =  ((Number) result.getObject(1)).intValue();

            return numberOfItems;

        } catch(Exception e) {
            System.out.println(e);
        }
        return numberOfItems;
    }

    //Aggregation with having
    public int VegetarianItems() {

        int vegetarianItems=0;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT COUNT(ItemID) FROM ITEM HAVING name LIKE %?%");
            ps.setString(1, "veg");

            ResultSet rs = ps.getResultSet();

            if(rs.next()) {
                vegetarianItems =  ((Number) rs.getObject(1)).intValue();
            } else {
                System.out.println("Item does not exist.");
            }
            ps.close();

            return vegetarianItems;

        } catch(Exception e) {
            System.out.println(e);
        }

        return vegetarianItems;
    }

    //Nested Aggregation with Group BY
    public Object BestFeedBacks() {

        ArrayList<Object> feedbackArray = new ArrayList();
        int rating;
        String des = "";


        try {
            PreparedStatement ps = connection.prepareStatement("SELECT DESCRIPTION, MAX(RATINGS) FROM FEEDBACKGIVEN GROUP BY CUSTOMERID");

            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                rating = rs.getInt("ratings");
                des = rs.getString("description");
                feedbackArray.add(rating,des);
            }

            ps.close();
            return feedbackArray;

        } catch(Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public Object FindStaffWhoDesignedAllMenus() {

        String name="";
        ArrayList<Object> staffNames = new ArrayList();


        try {
            PreparedStatement ps = connection.prepareStatement("SELECT name FROM STAFF S WHERE NOT EXISTS ((SELECT M.MENUID FROM MENU M) " +
                    "EXCEPT (SELECT D.STAFFID FROM DESIGNS D WHERE D.STAFFID = S.STAFFID))");

            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                name = rs.getString("name");
                staffNames.add(name);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Connection login(String username, String password) {
        try {
            if (connection != null) {
                connection.close();
            }

            connection = DriverManager.getConnection(ORACLE_URL, username, password);
            connection.setAutoCommit(false);

            System.out.println("\nConnected to Oracle!");
            return connection;
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            return null;
        }
    }
//
    private void rollbackConnection() {
        try  {
            connection.rollback();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void databaseSetup() {
        dropBranchTableIfExists();

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE CUSTOMER (customerID integer PRIMARY KEY not null, name varchar(50), email varchar(50) not null, password varchar(50) not null, address varchar(50), phone varchar(50) not null)");
            stmt.executeUpdate("CREATE TABLE ORDERPLACED (orderno integer, customerID integer not null, orderStatus varchar(50), orderAmount double, paymentMethod varchar(50), primary key (customerid, orderno), foreign key(customerID) references CUSTOMER)");
            stmt.executeUpdate("CREATE TABLE FEEDBACKGIVEN (customerID integer, feedbackID integer not null, title varchar(50), description varchar(50), ratings integer, primary key (customerid, feedbackID), foreign key(customerID) references CUSTOMER)");
            stmt.executeUpdate("CREATE TABLE COMBO (comboID integer, title varhcar(50), description varchar(50), price double, primary key (comboID))");
            stmt.executeUpdate("CREATE TABLE STAFF (staffID integer, name varhcar(50), email varchar(50), password varchar(50), role varchar(50), phone integer, primary key (staffID))");
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }

        CustomerAccount customer1 = new CustomerAccount(101, "John Doe", "john@gmail.com", "John@123", "XYZ Street", "123456789");
        insertCustomer(customer1);

    }

    private void dropBranchTableIfExists() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select table_name from user_tables");

            while(rs.next()) {
                if(rs.getString(1).toLowerCase().equals("branch")) {
                    stmt.execute("DROP TABLE branch");
                    break;
                }
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }
}
