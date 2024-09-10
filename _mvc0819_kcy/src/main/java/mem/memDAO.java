package mem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class memDAO {
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public memDAO() {
		session = sqlsession_f.openSession(true);
	}

	public memDTO memLogin(memDTO mdto) {
		return session.selectOne("MemberMapper.selectLogin", mdto);
	}

	public memDTO memCheck(String id) {
		return session.selectOne("MemberMapper.selectCheck", id);
	}

	public void memSignup(memDTO mdto) {
		session.insert("MemberMapper.insertMem", mdto);
	}

	public void memUpdate(memDTO mdto) {
		session.update("MemberMapper.updateMem", mdto);
	}
	
	public void memDelete(String id) {
		session.delete("MemberMapper.deleteMem", id);
	}
}
