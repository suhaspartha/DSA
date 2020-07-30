package designpatterns.creational;

abstract class Vehicle {
	protected String vehicleType;

	protected abstract int getWheels();

	public String toString() {
		return "Here is your " + vehicleType + " and it has " + this.getWheels() + " wheels";
	}
}

class Car extends Vehicle {
	private int wheels;

	public Car(int wheels) {
		this.wheels = wheels;
		this.vehicleType = "Car";
	}

	@Override
	public int getWheels() {
		return wheels;
	}

}

class Bike extends Vehicle {
	private int wheels;

	public Bike(int wheels) {
		this.wheels = wheels;
		this.vehicleType = "Bike";
	}

	@Override
	public int getWheels() {
		return wheels;
	}

}

/*
 * This factory produces vehicles. Based on the request it decides what
 * product/object has to be generated.
 */
class VehicleFactory {
	public static Vehicle getVehicle(String type) {
		if (type.equals("car")) {
			return new Car(4);
		} else if (type.equals("bike")) {
			return new Bike(2);
		}
		return null;
	}
}

public class FactoryPattern {

	public static void main(String[] args) {
		/* Ask factory for the required product */
		Vehicle vehicle1 = VehicleFactory.getVehicle("car");
		System.out.println(vehicle1);
		Vehicle vehicle2 = VehicleFactory.getVehicle("bike");
		System.out.println(vehicle2);
	}

}
