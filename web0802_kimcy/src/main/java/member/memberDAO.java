package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JdbcUtil;

public class memberDAO {
	private PreparedStatement stmt = null;
	private Connection conn = null;
	private ResultSet rs = null;
	
	String member_SIGNIN = "select * from member where id=? and pw=?"; // 로그인 시 id, pw 일치 여부
	String member_SIGNUP = "insert into member(id, pw, name) values(?, ?, ?)"; // 회원가입 id, pw, name 입력
}
