package promotionEx;

public class ChildEx {

	public static void main(String[] args) {
		Child child = new Child();
		Parent parent = child;
		
		parent.method1();
		parent.method2();
//		parent.method3(); 부모 타입으로 변환해 자식클래스한테만 존재하는 메소드3을 호출 할 수 없음
		
		Child child2 = (Child) parent;
//		자식클래스의 메소드를 사용하기 위해 강제 타입 변환
		child2.method3();
	}
}
