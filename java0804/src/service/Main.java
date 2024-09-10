package service;

public class Main {
	public static void main(String[] args) {
		Controller controller = new Controller();
		
//		MemberService memberService = new MemberService();
//		controller.setService(memberService); 같은 코드임
		
//		controller.setService(new Service());
//		controller.ss.login(); Service는 부모여서 자식클래스에서 재정의된 메서드 사용X
		
		controller.setService(new MemberService());
		controller.ss.login();

		controller.setService(new AService());
		controller.ss.login();
	}
}
