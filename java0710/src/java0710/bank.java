package java0710;

import java.util.Scanner;

public class bank {

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		int money = 0;
		Scanner scan = new Scanner(System.in);
		
		while(run) {
			System.out.println("----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------");
			System.out.print("선택> ");
			int num = Integer.parseInt(scan.nextLine());
			
			if (num == 1) {
				System.out.print("예금액> ");
				money = Integer.parseInt(scan.nextLine());
				balance += money;
				System.out.println(balance + "원");
			}
			if (num == 2) {
				System.out.print("출금액> ");
				money = Integer.parseInt(scan.nextLine());
				balance -= money;
			}
			if (num == 3) {
				System.out.print("잔고> " + balance);
				System.out.println();
			}
			if (num == 4) {
				run = false;
				break;
			}
		}
		System.out.println("종료");
	}

}