package sec05.exam05;

public class PersonEx {
	public static void main(String[] args) {
		Person p = new Person("12345-1234567",  "홍길동");
		
		System.out.println(p.nation);
		System.out.println(p.ssn);
		System.out.println(p.name);
		
//		p.nation = "usa"; // final 필드로 선언되었지만 생성자를 통해 초기화해 그 이후엔 값변경 x.
//		p.ssn = "654321-7654321"; // final 필드로 선언되어서 필드값을 변경 할 수 없음.
		
		p.name = "홍삼원"; // 일반 필드값이라 변경 가능
		System.out.println(p.name);
	}
	
	
}
