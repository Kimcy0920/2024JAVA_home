package sec01.exam03;

public class A {
	int field1;
	void method1() {}
	
	static int field2;
	static void method2() {}
	
	class B {
		void method() {
			System.out.println("인스턴스 멤버 클래스 B");
			field1 = 10;
			method1();
			
			
			field2 = 10;
			method2();
		}
	}
	
	static class C {
		void method() {
//			field1 = 10;
//			method1();
			System.out.println("정적 멤버 클래스 B");
			field2 = 10;
			method2();
		}
	}
	
	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B();
		b.method();
		
		
		A.C c = new A.C();
		c.method();
	}
}

/* 클래스 A에 인스턴스 멤버와 정적 멤버가 존재
 * 인스턴스 멤버 클래스인 중첩클래스 B에 메소드를 선언
 * 클래스 A의 인스턴스 멤버와 정적 멤버를 호출 - 사용가능
 * 
 * 정적 멤버 클래스인 중첩클래스 C에 메소드를 선언
 * 클래스 A의 인스턴스 멤버와 정적 멤버를 호출 - 정적멤버만 사용가능
*/