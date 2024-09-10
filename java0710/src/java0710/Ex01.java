package java0710;

public class Ex01 {

	public static void main(String[] args) {
//		교재 p94
		
//		byte b1 = 65;
//		char c1 = b1; // 컴파일 에러
//		System.out.println(c1);
		
//		byte b1 = -65;
//		char c1 = (char)b1; // 강제 타입 변환
//		System.out.println(c1);
//		char는 2byte이며 음수 포함X 고로 (char) 강제 타입 변환을 통해 변경

//		int x = 200;
//		byte y = (byte) x; // byte -138~137, 200은 범위 밖
//		System.out.println(y);
		
		double d1 = 3.14;
		int z = (int) d1; // 실수형을 정수형으로 변경.
		System.out.println(z);
		
		byte a1 = 10;
		byte b2 = 20; // byte c3 = a1 + b2; 연산 시 int타입으로 하기때문에 컴파일 에러
		
		int z1 = a1 + b2;
		System.out.println(z1);
		
		float result = (float)(1.5 + 2.3); // float는 f를 붙여야함 혹은 왼쪽 코드처럼 작성
		double res2 = 1.5 + 2.3;
		System.out.println(result);
		System.out.println(res2);
		
		
		
		int x1 = 1;
		int x2 = 3;
		int x3 = x1 / x2;
		System.out.println(x3); // double res3 = x1 / x2; 0.0출력
		double res3 = x1 / x2; //
		System.out.println(res3);
		
		String s1 = "가나다" + 3; // 문자열에 숫자 더하기
		System.out.println(s1); 
		
		String s2 = 3 + "가나다"; // 숫자에 문자열 더하기
		System.out.println(s2);
		
		int v1 = Integer.parseInt("100") + 3;
		System.out.println(v1);
		
		double v2 = Double.parseDouble("100.345") + 3;
		System.out.println(v2);
		
		String str1 = 10 + ""; // 문자열 10으로 변경
		System.out.println(str1);
		String str2 = String.valueOf(10); // 문자열 10으로 변경
		System.out.println(str2);
		
		// p.107 기본문제 풀기
	}

}