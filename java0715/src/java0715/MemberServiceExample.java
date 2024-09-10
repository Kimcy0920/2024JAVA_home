package java0715;

public class MemberServiceExample {

	public static void main(String[] args) {
		MemberService ms = new MemberService();
		boolean result = ms.login("hong", "12345");
		if(result) {
			System.out.println("로그인 되었습니다.");
			ms.logout("hong");
		} else {
			System.out.println("id 또는 pw가 틀렸습니다.");
		}

	}

}
