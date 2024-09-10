package com.board.db;

import java.sql.*;
import java.time.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardDao {
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public BoardDao() {
		session = sqlsession_f.openSession(true);
	}

	// 현재 시간을 문자열 형태로 반환
	private String getCurrentTime() {
		return LocalDate.now() + " " + LocalTime.now().toString().substring(0, 8);
	}

	// 게시글 갯수 얻기
	public int getNumRecords() {
		return session.selectOne("BoardMapper.getNumRecords");
		// numRecords
	}

	// 게시글 리스트 읽기
	public List<BoardDto> selectList(int start, int listSize) {
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("listSize", listSize);
		return session.selectList("BoardMapper.selectList", map);
	}

	public void updateHits(int num) {
		session. update("BoardMapper.updateHits", num);
	}
	
	public BoardDto selectOne(int num, boolean hitsIncreased) {
		if (hitsIncreased) {
			updateHits(num);
		}
		return session.selectOne("BoardMapper.selectOne", num);
	}

	// DTO에 담긴 내용으로 새로운 레코드 저장
	public void insertOne(BoardDto dto) {
		session.insert("BoardMapper.insertOne", dto);
	}

	// DTO에 담긴 내용으로 게시글 데이터 업데이트
	public void updateOne(BoardDto dto) {
		session.update("BoardMapper.updateOne", dto);
	}

	// 지정된 글 번호의 레코드 삭제
	public void deleteOne(int num) {
		session.delete("BoardMapper.deleteOne", num);
	}
}