package vehicle;

public class Main {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		Bus bus = new Bus();
		Driver driver = new Driver();
		
		driver.drive(bus);
		driver.drive(vehicle);
	}

}
