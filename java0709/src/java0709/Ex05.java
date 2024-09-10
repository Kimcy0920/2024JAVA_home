package java0709;

import java.util.Scanner;

public class Ex05 {

	public static int getCount(String msg, Scanner sc) {
		System.out.print(msg);
		String input = sc.nextLine();
		return Integer.parseInt(input);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		loop: for (;;) {
			int score = getCount("학점 입력: ", scan);
			String str = "";
			if (0 <= score && score <= 100) {
				switch(score/10) {
				case 10:
				case 9:
					str = "A";
					break;
				case 8:
					str = "B";
					break;
				case 7:
					str = "C";
					break;
				case 6:
					str = "D";
				default:
					str = "F";
				}
				System.out.println("등급: " + str);
				break loop;
			} else {
				System.out.println("0~100점 사이로 입력하세요.");
			}
		}
	}

}
// 문제6. 100점이 만점인 학점을 입력 받아서 90점 이상이면 A, 80점 이상이면 B, 70점 이상이면 C, 60점 이상이면 D, 60점 미만이면 F를 구하는 프로그램을 작성하세요.
// (입력받은 점수는 0점에서 100점 사이의 값만 넣어야함)