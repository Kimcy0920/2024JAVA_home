package java0709;

import java.util.Scanner;

public class Ex02 {

	public static int getCount(String msg, Scanner sc) {
		System.out.print(msg);
		String input = sc.nextLine();
		return Integer.parseInt(input);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int apple = getCount("사과 갯수: ", scan);
//		System.out.print("사과 갯수: ");
//		String input = scan.nextLine();
//		int apple = Integer.parseInt(input);
		
		int people = getCount("친구 수: ", scan);
//		System.out.print("친구 수: ");
//		input = scan.nextLine();
//		int people = Integer.parseInt(input);
		
		int remainder = apple % (people + 1);
		System.out.printf("남은 사과 갯수: %d", remainder);
	}

}
// 문제2. 사과가 10개가 있습니다. 2명의 친구가 있습니다. (본인을 포함하면 총 3명)
// 사과를 똑같이 나눠 먹으면 몇 개의 사과가 남을까요?
// (Scanner 이용, 반복문[빠져나갈 때], 1인당 사과를 먹은 개수, 오류체크, 메서드)