package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtil;

public class BdDAO {
	// JDBC 관련 변수 
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String BOARD_LIST = "select * from board";
	private String BOARD_INSERT = "insert into board(writer, title, content, regtime, hits) values(?,?,?,now(),0)";
	private String BOARD_VIEW = "select * from board where num=?";
	private String BOARD_UPDATE = "update board set writer=?, title=?, content=?, regtime=now() where num=?";
	private String BOARD_DELETE = "delete from board where num=?";
	private String BOARD_WRITE = "select * from board where num=?";
	private String BOARD_HITS = "update board set hits = hits + 1 where num=?";
	
	public void hitsBoard(int num) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_HITS);
			stmt.setInt(1, num);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}
	
	// 게시판 글 삭제
	public void deleteBoard(int num) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, num);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 게시판 글 수정
	public void updateBoard(BdDTO dto) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, dto.getWriter());
			stmt.setString(2, dto.getTitle());
			stmt.setString(3, dto.getContent());
			stmt.setInt(4, dto.getNum());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}
	
	//게시판 등록
	public void insertBoard(BdDTO dto) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, dto.getWriter());
			stmt.setString(2, dto.getTitle());
			stmt.setString(3, dto.getContent());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}
	
	// 게시판 조회
	public BdDTO getView(int num) {
		BdDTO dto = null;
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_VIEW);
			stmt.setInt(1, num);
			rs = stmt.executeQuery();
			if (rs.next()) {
				dto = new BdDTO(rs.getInt("num"), rs.getString("writer"),
						rs.getString("title"), rs.getString("content"),
						rs.getString("regtime"), rs.getInt("hits"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn, rs); // close
		}
		return dto;
	}
	
	//게시판 목록 조회
	public List<BdDTO> getBoardList() { // getBoardList 메소드
		List<BdDTO> list = new ArrayList<>(); // return타입 List
		
		conn = JdbcUtil.getConnection(); // 접속 코드
		try {
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				BdDTO dto = new BdDTO(rs.getInt("num"), rs.getString("writer"),
						rs.getString("title"), rs.getString("content"),
						rs.getString("regtime"), rs.getInt("hits"));
				list.add(dto); // DTO에서 칼럼을 라인별로 읽어와 배열 list에 add시킴.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn, rs); // close
		}
		return list;
	}
	
	public BdDTO getWrite(int num) {
		BdDTO dto = null;
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_WRITE);
			stmt.setInt(1, num);
			rs = stmt.executeQuery();
			if (rs.next()) {
				dto = new BdDTO(rs.getInt("num"), rs.getString("writer"),
						rs.getString("title"), rs.getString("content"),
						rs.getString("regtime"), rs.getInt("hits"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn, rs); // close
		}
		return dto;
	}
}