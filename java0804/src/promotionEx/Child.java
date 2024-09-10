package promotionEx;

public class Child extends Parent {
	
	@Override
	void method2() {
		System.out.println("method2() @Override");
	}
	void method3() {
		System.out.println("method3()");
	}
}