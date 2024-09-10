package java0710;

public class Ex05 {

	public static void main(String[] args) {
		int a = 10;
		int b = -10;
		long c = 10;
		
		System.out.printf("[%32s] %d\n", Integer.toBinaryString(a), a); // [%32s] 칸수
		System.out.printf("[%32s] %d\n", Integer.toBinaryString(b), b); // Integer.toBinaryString 2진수로 변환
		System.out.printf("[%32s] %d\n", Integer.toBinaryString(a&b), a&b);
		System.out.printf("[%32s] %d\n", Integer.toBinaryString(a|b), a|b);
		System.out.printf("[%32s] %d\n", Long.toBinaryString(c), c);
	}

}