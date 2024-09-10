package arrayandforEx;

public class For {

	public static void main(String[] args) {
		int[] scores = {95,71,84,93,87};
		int sum = 0;
		
		for (int score : scores) {
//			 (2)타입변수  : (1)배열
			sum += score; // (3)실행문
		}
		System.out.println("점수 총합: " + sum);
		
		double avg = (double) sum / scores.length;
		System.out.println("점수 평균: " + avg);
	}

}
