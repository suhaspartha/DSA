package designpatterns.creational;

import java.util.ArrayList;
import java.util.List;

class CarDealer {
	private List<String> cars;

	public CarDealer() {
		cars = new ArrayList<>();
	}

	public CarDealer(List<String> cars) {
		this.cars = cars;
	}

	public void insertValues() {
		cars.add("AMG A45");
		cars.add("Porsche 992 911 turbo S");
		cars.add("McLaren Senna");
		cars.add("Lambhorgini Aventador");
		cars.add("Ferrari 488 Pista");
	}

	@Override
	public CarDealer clone() {
		List<String> temp = new ArrayList<>();
		for (String car : cars) {
			temp.add(car);
		}
		return new CarDealer(temp);
	}

	public List<String> getCars() {
		return cars;
	}

	@Override
	public String toString() {
		return "CarDealer [cars=" + cars + "]";
	}

}

/*
 * Use this when we need a repeated object and customize on top of it without
 * altering original object
 */
public class PrototypePattern {

	public static void main(String[] args) {
		CarDealer dealer1 = new CarDealer();
		dealer1.insertValues();

		System.out.println("dealer1 = " + dealer1);
		CarDealer dealer2 = dealer1.clone();
		System.out.println("dealer1 cloned to dealer2 and added extra car");
		dealer2.getCars().add("Ford Mustang GT");

		System.out.println("dealer2 = " + dealer2);
		System.out.println("dealer1 is unaltered");
		System.out.println("dealer1 = " + dealer1);

	}

}
