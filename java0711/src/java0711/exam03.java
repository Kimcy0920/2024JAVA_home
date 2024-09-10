package java0711;

import java.util.Scanner;

public class exam03 {
	
	public static int sumOf(int a, int b) {
		int max = 0;
		int min = 0;
		
		if (a > b) {
			max = a;
			min = b;
		} else {
			min = a;
			max = b;
		}
		int sum = 0;
		for(int i = min; i<=max; i++) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		int sum = 0;
		
		System.out.print("a 입력: ");
		int a = scan.nextInt();
		System.out.print("b 입력: ");
		int b = scan.nextInt();
		
		System.out.println(sumOf(a, b));
		
//		for(int i = a; i<=b; i++) {
//			sum += i;
//		}
//		System.out.println(sum);
	}

}
//문제3. 정수 a, b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환하는 메서드르 작성하세요.
//sumOf(2, 4) / sumOf(4, 2)