package java0710;

public class Ex02 {

	public static void main(String[] args) {
		int x = 0;
		int y = ++x;
//		int y = x++;
		++x;
		x++;
		x = x + 1;
		System.out.println(x);
		System.out.println(y);
		
		int num1 = 10;
		int num2 = 10;
		
		boolean result1 = (num1 == num2);
		boolean result2 = (num1 != num2);
		boolean result3 = (num1 <= num2);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
		char char1 = 'A';
		char char2 = 'B';
		boolean result4 = (char1 < char2);
		System.out.println(result4);
		
//		String str1 = "가나다"; // 리터럴이라 같음
//		String str2 = "가나다";
		String str1 = new String("가나다"); // 주소값이기에 서로 다름
		String str2 = new String("가나다");
		boolean result5 = str1 == str2;
		System.out.println(result5);
	}

}