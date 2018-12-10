package ie.gmit.sw.rmi;

import ie.gmit.sw.Model.Car;
import ie.gmit.sw.Model.ObjectFactory;

public class ClientSetup {
	public static void main(String[] args) throws Exception{
		ObjectFactory of = new ObjectFactory();
		
		Object o = of.createOrder();
		
		Car car = new Car();
		car.setCarid(4);
		car.setColor("");
		car.setBrand("");
		car.setModel("");
	}
}
