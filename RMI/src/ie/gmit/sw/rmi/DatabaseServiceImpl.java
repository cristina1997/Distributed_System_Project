package ie.gmit.sw.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.*;
import java.util.Date;

import ie.gmit.sw.Model.Order;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {
	// Source code adapted from:
	// - https://github.com/cristina1997/JDBC-JSF-Database
	// - https://github.com/espag/Java-RMI
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private PreparedStatement ps;
	
	
	private final String DB_URL = "jdbc:mysql://localhost:3306/carOrders?useSSL=false";
	private final String USER = "root";
	private final String PASS = "";

	// It calls the method that connects the mysql database to this rmi project
	public DatabaseServiceImpl() throws RemoteException, SQLException {
		connect();
	}

	// It returns the mysql database connection
	public Connection getConnection() {
		return conn;
	}

	@Override
	public ArrayList<Order> read() throws RemoteException, SQLException {
		System.out.println("Read");
		final ArrayList<Order> orders = new ArrayList<Order>(); // it creates an orders array list to store the database data
		ps = conn.prepareStatement("SELECT * FROM orders;"); // the mysql statement used in this method to read the data
		ResultSet rs = ps.executeQuery(); // execution of the myql statement

		// it goes through all the items available in the mysql orders table and sets them to the newly created array list
		while (rs.next()) {
			final Order order = new Order();
			order.setOrderId(rs.getInt("OrderID"));
			order.setDate(rs.getDate("Date"));
			order.setCar(rs.getInt("CarID"));
			order.setCust(rs.getInt("CustID"));

			orders.add(order); // it adds all the mysql orders to the orders array list
		}
		return orders; // returns orders array list to the MyResources class
	}

	@Override
	public void create(Order order) throws RemoteException, SQLException {
		System.out.println("Create");
		ps = conn.prepareStatement("INSERT INTO orders (Date, CustID, CarID) VALUES (CURDATE(), 4, 4);"); // the mysql statement used in this method to read the data
		
		ps.executeUpdate(); // execution of the myql statement

	}
	
	public void update(Order order) throws RemoteException, SQLException {
		System.out.println("Update");
		ps = conn.prepareStatement("UPDATE orders SET Date = CURDATE(), CustID = 3, CarID = 3 WHERE OrderID = 1234;"); // the mysql statement used in this method to read the data
		
		ps.executeUpdate(); // execution of the myql statement

	}
	
	public void delete(Order order) throws SQLException {
		System.out.println("Delete");
		ps = conn.prepareStatement("DELETE FROM orders WHERE OrderID = 1234;"); // the mysql statement used in this method to read the data
		
		ps.executeUpdate(); // execution of the myql statement
	}

	private void connect() {
		try {
			// it gets the mysql driver from this computer
			Class.forName("com.mysql.jdbc.Driver");

			// it uses the database url, user and password to access the mysql database
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
