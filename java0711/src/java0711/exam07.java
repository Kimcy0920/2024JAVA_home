package java0711;

import java.util.Scanner;

public class exam07 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		two: for(;;) {
			System.out.print("숫자 입력: ");
			int n = scan.nextInt();
			if(9 < n && n < 100) {
				System.out.println(n);
				break two;
			}
		}

	}

}
//문제7. 2자리 양수를 입력받는 프로그램을 작성하세요.
//a = 5, a = 105, a = 57 --> a = 57