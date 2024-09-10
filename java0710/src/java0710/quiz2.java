package java0710;

import java.util.Scanner;

public class quiz2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int i, j;
		int sum = 0;
		int sum2 = 0;
		
		// 문제1. 1부터 10까지 출력하세요.
		for(i=0; i<10; i++) {
			System.out.print(i + " ");
		}
		
		// 문제2. 1부터 100까지의 합을 구하세요.
		System.out.println();
		for(i=0; i<=100; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		// 문제3. 1부터 10까지 짝수를 출력하세요.
		for(i=0; i<10; i++) {
			if(i%2 == 0) {
				System.out.print(i + " ");
			}
		}
		
		// 문제4. 1부터 100까지 짝수의 합계를 구하세요.
		System.out.println();
		for(i=0; i<=100; i++) {
			if(i%2 == 0) {
				sum2 += i;
			}
		}
		System.out.println(sum2);
		
		// 문제5. 구구단 출력하기 (전체)
		System.out.println();
		for(i=2; i<10; i++) {
			for(j=1; j<10; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i*j);
			}
			System.out.println();
		}
		
		// 문제6. 구구단 출력하기 (단 입력 받아서)
		System.out.print("단 입력: ");
		System.out.println();
		int num = Integer.parseInt(scan.nextLine());
		for(i=1; i<10; i++) {
			System.out.printf("%d * %d = %d\n", num, i, num*i);
		}

	}
}