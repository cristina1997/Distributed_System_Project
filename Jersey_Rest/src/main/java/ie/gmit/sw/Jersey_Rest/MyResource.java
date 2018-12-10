package ie.gmit.sw.Jersey_Rest;

import java.net.MalformedURLException;
import java.rmi.*;
import java.sql.SQLException;
import java.util.*;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.Model.Order;
import ie.gmit.sw.rmi.DatabaseService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Singleton
@Path("myresource")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws SQLException
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public ArrayList<Order> getOrders() throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		DatabaseService ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/databaseservice");
		
		return ds.read();
	}

	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public void createOrders(Order order) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		DatabaseService ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/databaseservice");
		
		ds.create(order);
	}

	@PUT
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public void updateOrders(Order order) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
	
		DatabaseService ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/databaseservice");
		
		ds.update(order);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public void deleteOrders(Order order) throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		System.out.println("test..");
		
		DatabaseService ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/databaseservice");
		
		ds.delete(order);
	}

}
