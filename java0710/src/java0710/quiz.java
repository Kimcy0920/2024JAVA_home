package java0710;

import java.util.Scanner;

public class quiz {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = 0;
		int j = 0;
		int sum = 0;
		
		
		// 문제1. 1부터 10까지 출력하세요.
		for (i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
		// 문제2. 1부터 100까지의 합을 구하세요.
		for (i = 1; i <= 100; i++) {
			sum = sum + i;
		}
		System.out.println("1~100까지의 합은 " + sum);
		
		// 문제3. 1부터 10까지 짝수를 출력하세요.
		for (i = 1; i <= 10; i++) {
			if (i % 2 != 1) {
				System.out.println(i);
			}
		}
		
		// 문제4. 1부터 100까지 짝수의 합계를 구하세요.
		for (i = 1; i <= 100; i++) {
			if (i % 2 != 1) {
				sum = sum + i;
			}
		}
		System.out.println(sum);
		
		// 문제5. 구구단 출력하기 (전체)
		for (i = 2; i <= 9; i++) {
			for (j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i*j);
			}
		}
		
		// 문제6. 구구단 출력하기 (단 입력 받아서)
		
		
		System.out.print("단 입력(2~9): ");
		String input = scan.nextLine();
		int num = Integer.parseInt(input);
			
		for (i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", num, i, num*i);
			}
		}
}