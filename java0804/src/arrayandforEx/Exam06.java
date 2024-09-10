package arrayandforEx;
import java.util.Scanner;

public class Exam06 {

	public static void main(String[] args) {
		boolean run = true;
		int stuNum = 0;
		int[] scores = null;
		int sum = 0;
		double avg = 0.0;
		int max = 0;
		
		Scanner scan = new Scanner(System.in);
		
		while(run) {
			System.out.println("--------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택> ");
			
			int selNo = Integer.parseInt(scan.nextLine());
			
			if(selNo == 1) {
				System.out.print("학생수> ");
				stuNum = Integer.parseInt(scan.nextLine());;
				scores = new int[stuNum];
			} else if (selNo == 2) {
				for (int i=0; i<stuNum; i++) {
					System.out.print("scores[" + i + "]" + ">");
					scores[i] = Integer.parseInt(scan.nextLine());
				}
			} else if (selNo == 3) {
				for (int i=0; i<scores.length; i++) {
					System.out.println("scores[" + i + "]" + "> " + scores[i]);
				}
			} else if (selNo == 4) {
				for (int i=0; i<scores.length; i++) {
					sum += scores[i];
					max = (max < scores[i]) ? scores[i] : max;
					// max가 score[i]보다 크면 max는 scores[i]
					// max가 score[i]보다 작으면 max 그대로
				}
				avg = (double) sum / scores.length;

				System.out.println("최고점수: " + max);
				System.out.println("평균점수: " + avg);
			} else if (selNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}

}
