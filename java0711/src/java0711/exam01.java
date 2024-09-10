package java0711;

import java.util.Scanner;

public class exam01 {
	
	public static int med(int a, int b, int c) {
		if ((b >= a && c <= a) || (b <= a && c >= a)) {
			// b가 a보다 크거나 같고, c가 a보다 작거나 같다 or b가 a보다 작거나 같고, c가 a보다 크거나 같다
			return a;
		} else if ((a > b && c < b) || (a < b && c > b)) {
			// a가 b보다 크고, c가 b보다 작다 or a가 b보다 작고 c가 b보다 크다
			return b;
		}
		return c;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int mid = 0;
		
		System.out.print("a 값: ");
		int a = scan.nextInt();
		System.out.print("b 값: ");
		int b = scan.nextInt();
		System.out.print("c 값: ");
		int c = scan.nextInt();
		
		System.out.println("중앙값은 " + med(a, b, c) + "입니다.");
	}
}
//문제. 3개의 정수값을 입력받아 중앙값을 구하고 출력하세요.
// 다시 공부해 너무 멍청하다 진짜