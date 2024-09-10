package java0711;

import java.util.Scanner;

public class exam05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("n값 입력: ");
		int n = scan.nextInt();
		
//		for (int i=0; i<n/2; i++) {
//			System.out.print("+-");
//		}
//		if(n % 2 != 0) {
//			System.out.println("+");
//		}
		
		for (int i=0; i<n; i++) {
			if(i%2==0) {
				System.out.print("+");
			} else {
				System.out.print("-");
			}
		}
	}

}
//문제5. +, - 기호를 번갈아 출력하는 프로그램을 작성하세요.
//ex) n = 12, +-+-+-+-+-+-