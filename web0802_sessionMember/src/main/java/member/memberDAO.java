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
	memberDTO dto;
	
	String member_LOGIN = "select * from member where id=? and pw=?";
	String member_SIGNUP = "insert into member(id, pw, name) values(?, ?, ?)";
	String member_CHECK = "select * from member where id=?";
	String member_UPDATE = "update member set pw=?, name=? where id=?";
	
	public memberDTO memberLogin(String id, String pw) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(member_LOGIN);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			rs = stmt.executeQuery();
			if (rs.next()) {
				dto = new memberDTO(rs.getString("id"),
					rs.getString("pw"), rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn, rs);
		}
		return dto;
	}
	
	public memberDTO memberCheck(String id) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(member_CHECK);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			rs.next();
			if (rs.next()) {
				dto = new memberDTO(rs.getString("id"),
					rs.getString("pw"), rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn, rs);
		}
		return dto;
	}
	
	public void memberSignup(memberDTO dto2) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(member_SIGNUP);
			stmt.setString(1, dto2.getId());
			stmt.setString(2, dto2.getPw());
			stmt.setString(3, dto2.getName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}
	
	public void memberUpdate(memberDTO dto) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(member_UPDATE);
			stmt.setString(1, dto.getPw());
			stmt.setString(2, dto.getName());
			stmt.setString(3, dto.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}
}
