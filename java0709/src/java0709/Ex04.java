package java0709;

import java.util.Scanner;

public class Ex04 {

	public static int getCount(String msg, Scanner sc) {
		System.out.print(msg);
		String input = sc.nextLine();
		return Integer.parseInt(input);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
			int n1 = getCount("숫자 입력: ", scan);
			int n2 = getCount("숫자 입력: ", scan);
			int n3 = getCount("숫자 입력: ", scan);
			int num = 0;
			
			if (n1 > n2 && n1 > n3) {
				num = n1;
			} else if (n2 > n1 && n2 > n3) {
				num = n2;
			} else {
				num = n3;
			}
			
			System.out.println("최대값: " + num);
	}

}
// 문제4. 3개의 정수 값을 받아서 최대값을 구하여 출력하시오.