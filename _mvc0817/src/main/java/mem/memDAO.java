package mem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JdbcUtil;

public class memDAO {
		private PreparedStatement stmt = null;
		private Connection conn = null;
		private ResultSet rs = null;
		memDTO dto;
		
		String mem_LOGIN = "select * from mem where id=? and pw=?";
		String mem_SIGNUP = "insert into mem(id, pw, name, tel) values(?, ?, ?, ?)";
		String mem_CHECK = "select * from mem where id=?";
		String mem_UPDATE = "update mem set pw=?, name=?, tel=? where id=?";
		
		public memDTO memLogin(String id, String pw) {
			conn = JdbcUtil.getConnection();
			try {
				stmt = conn.prepareStatement(mem_LOGIN);
				stmt.setString(1, id);
				stmt.setString(2, pw);
				rs = stmt.executeQuery();
				if (rs.next()) {
					dto = new memDTO(rs.getString("id"), rs.getString("pw"),
							rs.getString("name"), rs.getString("tel"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(stmt, conn, rs);
			}
			return dto;
		}
		
		public memDTO memCheck(String id) {
			conn = JdbcUtil.getConnection();
			try {
				stmt = conn.prepareStatement(mem_CHECK);
				stmt.setString(1, id);
				rs = stmt.executeQuery();
				rs.next();
				if (rs.next()) {
					dto = new memDTO(rs.getString("id"), rs.getString("pw"),
							rs.getString("name"), rs.getString("tel"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(stmt, conn, rs);
			}
			return dto;
		}
		
		public void memSignup(memDTO dto2) {
			conn = JdbcUtil.getConnection();
			try {
				stmt = conn.prepareStatement(mem_SIGNUP);
				stmt.setString(1, dto2.getId());
				stmt.setString(2, dto2.getPw());
				stmt.setString(3, dto2.getName());
				stmt.setString(4, dto2.getTel());
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(stmt, conn);
			}
		}
		
		public void memUpdate(memDTO dto) {
			conn = JdbcUtil.getConnection();
			try {
				stmt = conn.prepareStatement(mem_UPDATE);
				stmt.setString(1, dto.getPw());
				stmt.setString(2, dto.getName());
				stmt.setString(4, dto.getTel());
				stmt.setString(3, dto.getId());
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(stmt, conn);
			}
		}
}
