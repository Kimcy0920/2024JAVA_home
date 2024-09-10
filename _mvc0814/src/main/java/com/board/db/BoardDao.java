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
		return session.selectOne("BoardMapper.selectCountRecords");
		// numRecords
	}

	// 게시글 리스트 읽기
	public List<BoardDto> selectList(int start, int listSize) {
		return session.selectList("BoardMapper.selectLimit");
	}

	// 지정된 글 번호를 가진 레코드 읽기
	// hitsIncreased가 true이면 해당 글의 조회수를 1 증가시킴
	// false이면 조회수를 증가시키지 않음
	public BoardDto selectOne(int num, boolean hitsIncreased) {
		session.selectOne("BoardMapper.selectOne", num);
		// 이글의 조회수를 증가시켜야 하는 경우
		// (글 보기 화면을 위해 읽을 때)이면 조회수 1 증가
		if (hitsIncreased) {
			session.update("BoardMapper.updateHits", num);
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