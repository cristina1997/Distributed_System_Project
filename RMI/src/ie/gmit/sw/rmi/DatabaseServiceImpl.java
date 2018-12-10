package ie.gmit.sw.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.*;
import java.util.Date;

import ie.gmit.sw.Model.Order;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {

	private static final long serialVersionUID = 1L;
	private Connection conn;
	private PreparedStatement ps;
	private final String DB_URL = "jdbc:mysql://localhost:3306/carOrders?useSSL=false";
	private final String USER = "root";
	private final String PASS = "";

	public DatabaseServiceImpl() throws RemoteException, SQLException {
		connect();
	}

	public Connection getConnection() {
		return conn;
	}

	@Override
	public ArrayList<Order> read() throws RemoteException, SQLException {
		System.out.println("In read");
		final ArrayList<Order> orders = new ArrayList<Order>();
		ps = conn.prepareStatement("select * from orders ");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			final Order order = new Order();
			order.setOrderId(rs.getInt("OrderID"));
			order.setDate(rs.getDate("Date"));
			order.setCar(rs.getInt("CarID"));
			order.setCust(rs.getInt("CustID"));

			orders.add(order);
		}
		return orders;
	}

	private void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
