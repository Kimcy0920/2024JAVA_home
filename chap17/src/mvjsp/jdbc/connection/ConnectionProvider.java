package mvjsp.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:apache:commons:dbcp:/board");
		// 기존처럼 url을 작성하지 않고 dbcp로 보냄. dbcp는 lib에 있는 jar파일
	}
}
