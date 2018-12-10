package ie.gmit.sw.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.Model.Order;

public interface DatabaseService extends Remote {

	public ArrayList<Order> read() throws RemoteException, SQLException;

}
