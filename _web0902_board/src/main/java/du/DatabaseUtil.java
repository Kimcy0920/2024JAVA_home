package du;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3307/spring5fs";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static List<Board> getAllBoard() {
        List<Board> board = new ArrayList<>();
        String query = "SELECT * FROM board";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int num = rs.getInt("num");
                String writer = rs.getString("writer");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String regtime = rs.getString("regtime");
                int hits = rs.getInt("hits");
                board.add(new Board(num, writer, title, content, regtime, hits));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return board;
    }

    public static Optional<Board> getBoardByNum(int num) {
        String query = "SELECT * FROM board WHERE num = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, num);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String writer = rs.getString("writer");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String regtime = rs.getString("regtime");
                int hits = rs.getInt("hits");
                return Optional.of(new Board(num, writer, title, content, regtime, hits));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public static Board addBoard(String writer, String title, String content, String regtime, int hits) {
        String query = "INSERT INTO board (writer, title, content, regtime, hits) VALUES (?, ?, ?, now(), 0)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, writer);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int num = rs.getInt(1);
                return new Board(num, writer, title, content, regtime, hits);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean updateBoard(int num, String writer, String title, String content) {
        String query = "UPDATE board SET writer = ?, title = ?, content = ? WHERE num = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, writer);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            pstmt.setInt(4, num);
            int affectedRows = pstmt.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean deleteItem(int num) {
        String query = "DELETE FROM board WHERE num = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, num);
            int affectedRows = pstmt.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}