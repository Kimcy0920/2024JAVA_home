package arrayandforEx;

public class Exam04 {

	public static void main(String[] args) {
		int max = 0;
		int[] array = {1,5,3,8,2};
		
		for (int i=array[0]; i<array.length-1; i++) {
			max = array[i+1];
			if (i > max) {
				max = array[i];
			}
		}
		
		System.out.println("max: " + max);
	}

}
