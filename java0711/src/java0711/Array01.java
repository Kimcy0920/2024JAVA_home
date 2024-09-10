package java0711;

public class Array01 {

	public static void main(String[] args) {
		int score1[] = new int[] {83, 90, 87}; // s1, s2 둘 다 같음
		int score2[] = {83, 90, 87};
		double sum = 0.0;
		double avg = 0;
		
//		System.out.println(score1[score1.length-1]);
//		
//		for (int i = 0; i < score1.length; i++) {	
//			sum += score1[i];
//			// score1의 총점을 출력하세요.
//		}
//		System.out.println("총점: " + sum);
//		
//		avg = sum / score1.length;
//		// score1의 평균을 출력하세요.
//		System.out.println("평균: " + avg);
		
		int myArr1[] = new int[5]; // 배열의 생성(초기화) /기본/
		// new 명령어로 인해 초기화됨
		for (int i = 0; i < 5; i++) {
			System.out.println(myArr1[i]);
			// 초기화되어 0만 출력
		}
		
		double myArr2[] = new double[5];

		for (int i = 0; i < 5; i++) {
			System.out.println(myArr2[i]);
		}
		
		boolean myArr3[] = new boolean[5];

		for (int i = 0; i < 5; i++) {
			System.out.println(myArr3[i]);
		}
	}

}