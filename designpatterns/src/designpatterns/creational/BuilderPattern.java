package designpatterns.creational;

class NewVehicle {
	// Mandatory
	private String engine;
	private int wheels;
	// Optional
	private int airBags;
	// ...n number of other optional props

	private NewVehicle(VehicleBuilder builder) {
		this.engine = builder.engine;
		this.wheels = builder.wheels;
		this.airBags = builder.airBags;
	}

	public String getEngine() {
		return engine;
	}

	public int getWheels() {
		return wheels;
	}

	public int getAirBags() {
		return airBags;
	}

	public static class VehicleBuilder {
		// Required props same as container class
		private String engine;
		private int wheels;

		// Optional props same as container class
		private int airBags;
		// ....n number of setters for other optional props

		public VehicleBuilder(String engine, int wheels) {
			this.engine = engine;
			this.wheels = wheels;
		}

		public NewVehicle build() {
			return new NewVehicle(this);
		}

		public void setAirBags(int airBags) {
			this.airBags = airBags;
		}

	}

	@Override
	public String toString() {
		return "NewVehicle [engine=" + engine + ", wheels=" + wheels + ", airBags=" + airBags + "]";
	}

}

/*
 * When we have too many args to pass to constructor and avoid using null/dummy
 * values as default then use builder pattern
 */
public class BuilderPattern {

	public static void main(String[] args) {
		NewVehicle.VehicleBuilder carBuilder = new NewVehicle.VehicleBuilder("3200cc", 4);
		carBuilder.setAirBags(4);
		NewVehicle car = carBuilder.build();
		System.out.println(car);
		NewVehicle bike = new NewVehicle.VehicleBuilder("999cc", 2).build();
		System.out.println(bike);

	}

}
