package java0709;

import java.util.Scanner;

public class Ex06 {

	public static int getCount(String msg, Scanner scan) {
		System.out.print(msg);
		String input = scan.nextLine();
		return Integer.parseInt(input);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = getCount("정수 입력: ", scan);
		int n = 0;
		
		if (num > 0) {
			n = num;
		} else {
//			n = num * -1;
//			n = -num;
			n -= num;
		}
		System.out.println(n);
	}

}
// 문제6. 정수의 값을 입력받고 입력받은 값이 양의 정수이면 그냥 출력하고, 음의 정수이면 양의 정수로 변환하여 출력하세요.