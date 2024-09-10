package java0710;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (;;) {
			System.out.println("명령>>");
			String input = scan.nextLine();
			if (input.equalsIgnoreCase("q")) { // equals는 대소문자도 구분, 왼쪽코드는 대소문자 구분x
				break;
			}
		}
		System.out.println("종료");
	}

}