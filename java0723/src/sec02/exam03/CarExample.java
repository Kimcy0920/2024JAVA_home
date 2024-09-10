package sec02.exam03;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i=0; i<5; i++) {
			int problemLocation = car.run();
			
			switch(problemLocation) {
			case 1:
				System.out.println("菊哭率 HankookTire肺 背们");
				car.frontLeftTire = new HankookTire("菊哭率", 15);
				break;
			case 2:
				System.out.println("菊坷弗率 KumhoTire肺 背们");
				car.frontLeftTire = new KumhoTire("菊哭率", 13);
				break;
			case 3:
				System.out.println("第哭率 HankookTire肺 背们");
				car.frontLeftTire = new HankookTire("第哭率", 14);
				break;
			case 4:
				System.out.println("第坷弗率 KumhoTire肺 背们");
				car.frontLeftTire = new HankookTire("第坷弗率", 17);
				break;		
			}
			System.out.println("--------------------------------");
		
		}
		
	}
	
}
