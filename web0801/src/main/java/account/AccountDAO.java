package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JdbcUtil;

public class AccountDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String ACCOUNT_LIST = "select * from account";
	private String ACCOUNT_INSERT = "insert into account(name, ssn, tel, balance) values(?, ?, ?, 1000)";
	private String ACCOUNT_COUNT = "select count(*) as cnt from account where name=? and ssn=?";
	
	//로그인 확인
	public boolean loginCheck(String name, String ssn) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(ACCOUNT_COUNT);
			stmt.setString(1, name);
			stmt.setString(2, ssn);
			rs = stmt.executeQuery();
			rs.next();
			if (rs.getInt("cnt") == 1) { // rs.getInt(1) 첫번째 칼럼 가져오기: count(*)
				return true;  // 로그인 성공
			}
			} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		return false;   // 로그인 실패
	}
	
	public void insertAccount(AccountDTO dto) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(ACCOUNT_INSERT);
			stmt.setString(1, dto.getName());
			stmt.setString(2, dto.getSsn());
			stmt.setString(3, dto.getSsn());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}
	
//	public List<AccountDTO> getAccountList() {
//		List<AccountDTO> list = new ArrayList<>();
//		
//		conn = JdbcUtil.getConnection();
//		try {
//			stmt = conn.prepareStatement(ACCOUNT_LIST);
//			rs = stmt.executeQuery();
//			while(rs.next()) {
//				AccountDTO dto = new AccountDTO(rs.getInt("num"), rs.getString("name"),
//						rs.getString("ssn"), rs.getString("tel"), rs.getInt("balance"));
//				list.add(dto);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return list;
//	}
}
