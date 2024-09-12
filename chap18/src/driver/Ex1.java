package driver;

import mvc.command.CommandHandler;

class Aaa {
	void disp() {
		System.out.println("프린트 Aa");
	}
}

public class Ex1 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		// new없이 객체 생성하고 테스트
		Class<?> handlerClass = Class.forName("driver.Aaa");
        Object handlerInstance = handlerClass.newInstance();
        Aaa aa = (Aaa) handlerInstance;
        aa.disp();
	}

}
