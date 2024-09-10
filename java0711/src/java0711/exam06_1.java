package java0711;

import java.util.Scanner;

public class exam06_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a, b;
		
		System.out.println("*를 n개 출력하되 w개마다 줄을 바꿔서 출력합니다.");
		
		do {
			System.out.print("n값: ");
			a = scan.nextInt();
		} while (a <= 0);
		
		do {
			System.out.print("w값: ");
			b = scan.nextInt();
		} while (a < b || b <= 0); // a가 b보다 작다, b가 0보다 작거나 같다

		for (int i = 0; i < a / b; i++) {
			System.out.print("*".repeat(b));	
			}
		if (a % b != 0) {
			System.out.println();
		}
		System.out.println("완료!!");

	}

}
