package java0709;

public class Ex01 {
	
	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
		
		System.out.println("x = " + a);
		System.out.println("y = " + b);
		System.out.println("");
	}
	
	public static void main(String[] args) {
		
		int x = 10;
		int y = 20;
		int temp = 0;
		
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("");
		
		swap(x, y);
		
		temp = x;
		x = y;
		y = temp;
		
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}
}
//문제1. x = 10, y = 20일 때 두 변수의 값을 바꿔보세요. (swap)