package ie.gmit.sw.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import ie.gmit.sw.Model.Order;

public class ServiceSetup {
	public static void main(String[] args) throws Exception {

		// Set an instance of DatabaseService
		Order order = new Order();
		
		DatabaseService ds = new DatabaseServiceImpl();
		LocateRegistry.createRegistry(1099);
		Naming.rebind("databaseservice", ds);
		System.out.println("Server ready.");
	}
}
