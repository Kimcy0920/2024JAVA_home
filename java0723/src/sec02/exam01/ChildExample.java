package sec02.exam01;

public class ChildExample {

	public static void main(String[] args) {
		Child child = new Child();
		
		Parent parent = child;
		
		parent.method1(); // 부모 메서드
		parent.method2(); // 자식 메서드(오버라이드)
		child.method3(); // 자식에서 새로 만든 메서드

	}

}
