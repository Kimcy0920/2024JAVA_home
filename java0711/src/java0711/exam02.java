package java0711;

import java.util.Scanner;

public class exam02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		int sum = 0;
		
		System.out.print("숫자 입력: ");
		int n = scan.nextInt();
		
		for(int i=1; i<=n; i++) {
			sum += i;
			
		}
		System.out.println(sum);
	}

}
//문제2. for문을 이용하여 1부터 n까지의 합을 구하세요. (n은 입력받은 정수)