package java0709;

import java.util.Scanner;

public class Ex03 {
	
	public static int getCount(String msg, Scanner sc) {
		System.out.print(msg);
		String input = sc.nextLine();
		return Integer.parseInt(input);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n1 = getCount("첫 번째 숫자 입력: ", scan);
		int n2 = getCount("두 번째 숫자 입력: ", scan);
		int n3 = 0;
		
		if (n1 > n2) {
			n3 = n1;
		} else if (n2 > n1) {
			n3 = n2;
		} else {
			n3 = 0;
		}
		System.out.println(n3);
	}

}
// 문제3. 두 개의 값을 받아서 큰 수를 출력하세요. (단, 같으면 0으로 출력)