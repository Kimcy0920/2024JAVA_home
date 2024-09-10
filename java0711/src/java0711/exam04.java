package java0711;

import java.util.Scanner;

public class exam04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자입력: ");
		int n = scan.nextInt();
		
		int sum = 0;
		
//		for(int i=1; i<=n; i++) {
//			sum += i;
//			if (i<n) {
//				System.out.print(i + " + ");
//			} else {
//				System.out.print(i + " = ");
//			}
//		}
//		System.out.println(sum);
		
		
		for (int i = 1; i < n; i++) {
			System.out.print(i + " + ");
			sum += i;
		}
		System.out.print(n + " = ");
		sum += n;
		System.out.println(sum);
	}

}
//문제4. 1부터 n까지의 합과 그 값을 구하는 과정을 출력하는 프로그램을 작성하세요.
//n = 5일 경우, 1 + 2 + 3 + 4 + 5 = 15