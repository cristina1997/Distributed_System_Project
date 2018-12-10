package ie.gmit.sw.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import ie.gmit.sw.Model.Order;

public interface DatabaseService extends Remote {

	public ArrayList<Order> read() throws RemoteException, SQLException;
	public void create(Order order) throws RemoteException, SQLException;
	public void update(Order order) throws RemoteException, SQLException;
	public void delete(Order order) throws RemoteException, SQLException;

}
