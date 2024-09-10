package file;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class FileDAO {
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public FileDAO() {
		session = sqlsession_f.openSession(true);
	}
	
	public List<FileDTO> getAllwebhard() {
		return session.selectList("fileMapper.selectAllwebhard");
	}
	
	public FileDTO getFileByNum(int num) {
		return session.selectOne("fileMapper.selectFileByNum", num);
	}
	
	public void insertFile(FileDTO dto) {
		session.insert("fileMapper.insertFile", dto);
	}
	
	public void deleteFile(int num) {
		session.delete("fileMapper.deleteFile", num);
	}
}
