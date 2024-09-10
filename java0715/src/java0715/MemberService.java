package java0715;

public class MemberService {
	
	boolean login (String id, String pw) {
		if(id == "hong" && pw == "12345") {
			return true;
		} else {
			return false;
		}
	}
	
	void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}
}
