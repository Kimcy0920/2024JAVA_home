package java0711;

import java.util.Scanner;

public class exam06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("n 입력: ");
		int n = scan.nextInt();
		System.out.print("w 입력: ");
		int w = scan.nextInt();

		if (n > w) {
			for(int i=0; i<n; i++) {
				if(i % w == 0) {
					System.out.println();
				}
				System.out.print("*");
			}
		} else {
			System.out.println("n이 w보다 작습니다.");
		}
		
	}

}
//문제6. *를 n개를 출력하되 w개 마다 줄을 바꿔서 출력하는 프로그램을 작성하세요.
//n = 14, w = 5 (n > w, w > 0)
//*****
//*****
//****