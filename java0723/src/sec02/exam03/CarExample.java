package sec02.exam03;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i=0; i<5; i++) {
			int problemLocation = car.run();
			
			switch(problemLocation) {
			case 1:
				System.out.println("�տ��� HankookTire�� ����");
				car.frontLeftTire = new HankookTire("�տ���", 15);
				break;
			case 2:
				System.out.println("�տ����� KumhoTire�� ����");
				car.frontLeftTire = new KumhoTire("�տ���", 13);
				break;
			case 3:
				System.out.println("�ڿ��� HankookTire�� ����");
				car.frontLeftTire = new HankookTire("�ڿ���", 14);
				break;
			case 4:
				System.out.println("�ڿ����� KumhoTire�� ����");
				car.frontLeftTire = new HankookTire("�ڿ�����", 17);
				break;		
			}
			System.out.println("--------------------------------");
		
		}
		
	}
	
}
