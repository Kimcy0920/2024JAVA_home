package java0711;

public class Max {

	public static void main(String[] args) {
		int a[] = {1, 3, 10, 2, 8};
		int max = a[0]; // max = 0이 아닌 a[0]->1을 넣음.
		
			for (int i = 1; i < a.length; i++) { // max가 a[0]임으로 i = 1로 시작
				if(max <= a[i]) {
					max = a[i];
				}
		}
		//최대값 구하기
		System.out.println("최대값: " + max);
	}

}