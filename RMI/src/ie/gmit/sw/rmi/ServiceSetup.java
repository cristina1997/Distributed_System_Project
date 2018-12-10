package ie.gmit.sw.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import ie.gmit.sw.Model.Order;

public class ServiceSetup {
	public static void main(String[] args) throws Exception {

		// Create an instance of DatabaseServiceImpl, and pass the list of orders to its constructor.
		DatabaseService ds = new DatabaseServiceImpl();
		
		// Start the RMI regstry on port 1099
		LocateRegistry.createRegistry(1099);
		
		// Bind the remote object to the registry with name - "databaseservice"
		Naming.rebind("databaseservice", ds);
		
		// Print a nice message to standard output to let the client know the server is running
		System.out.println("Server ready.");
	}
}
