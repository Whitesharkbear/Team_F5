package com.web.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.vo.CgvMemberVO;

public class CgvMemberDAO implements CgvObjectDAO {
	
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.member";
	
	//회원가입 시 아이디 중복체크
	public int idCheck(String id) {
		
		return sqlSession.selectOne(namespace + ".id_check", id);
		
		/*
		int result = 0;
		String sql = "select count(*) from cgv_member where id=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
			}
			//close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		*/
	}
	
	
	//회원가입 - insert(CgvMemberVO vo)
	// 부모인 CgvObjectDAO에서 상속받아 구현
	@Override
		public int insert(Object obj) {
			// 클래스 형변환 : Object ---> CgvMemberVO
			CgvMemberVO vo = (CgvMemberVO)obj;
			return sqlSession.insert(namespace+".insert", vo);
			
			/*
			int result = 0;
			String sql = "insert into cgv_member values(?,?,?,?,?,?,?,?,sysdate,0)";
			getPreparedStatement(sql);
			
			try {
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPass());
				pstmt.setString(3, vo.getName());
				pstmt.setString(4, vo.getGender());
				pstmt.setString(5, vo.getEmail());
				pstmt.setString(6, vo.getHp());
				pstmt.setString(7, vo.getHobbylist());
				pstmt.setString(8, vo.getIntro());
				
				result = pstmt.executeUpdate();
				
				//close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return result;
			*/
		}
	
	
		//회원 전체수
	@Override
	public int execTotalCount() {
		
		return sqlSession.selectOne(namespace+".count");
		
		/*
		int count = 0;
		String sql = "select count(*) from cgv_member";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
			// close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return count;
		*/
	}
	
	
	// 회원탈퇴 신청/취소
	public int updateJoinStatus(String id, String status) {
		
		int result = 0;
		if(Integer.parseInt(status) == 0) {
			// 신청
			result = sqlSession.update(namespace+".status1", id);
		} else {
			// 취소
			result = sqlSession.update(namespace+".status2", id);
		}
		
		return result;
		
		/*
		int result = 0;
		String sql = "";
		
		if(Integer.parseInt(status) == 0) {
			// 신청
			sql = "update cgv_member set join_status=1 where id=?";
		} else {
			// 취소
			sql = "update cgv_member set join_status=0 where id=?";
		}
		
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			
			//close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		*/
	}
	
	
	// 회원 상세정보
	@Override
	public Object select(String id) {
		return sqlSession.selectOne(namespace+".content", id);
		/*
		CgvMemberVO vo = new CgvMemberVO();
		String sql = "select id, name, gender, hobbylist, hp, join_status from cgv_member where id=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setId(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setGender(rs.getString(3));
				vo.setHobbylist(rs.getString(4));
				vo.setHp(rs.getString(5));
				vo.setJoin_status(rs.getInt(6));
			}
			//close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
		*/
	}
	
	
	// 회원 전체 리스트
	@Override
	public List<Object> select(int startCount, int endCount) {
		// 두개 이상의 파라미터는 반드시 객체형태로 전송함!!!
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		// 결과를 리턴하는 방식: 
		return sqlSession.selectList(namespace+".list", param);
		
		
		/*
		ArrayList<CgvMemberVO> list = new ArrayList<CgvMemberVO>();
		String sql = "select rno, id, name, hp, gender, mdate, join_status" 
				+ " from (select rownum rno, id, name, hp, gender, to_char(mdate,'yyyy-mm-dd') mdate, join_status" 
				+ " from (select id, name, hp, gender, mdate, join_status from cgv_member"
				+ " order by mdate desc)"
				+ ") where rno between ? and ?";
		
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, startCount);
			pstmt.setInt(2, endCount);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CgvMemberVO vo = new CgvMemberVO();
				vo.setRno(rs.getInt(1));
				vo.setId(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setHp(rs.getString(4));
				vo.setGender(rs.getString(5));
				vo.setMdate(rs.getString(6));
				vo.setJoin_status(rs.getInt(7));
				
				list.add(vo);
			}
			//close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
		*/
	}
	
	
	
	
	//로그인 - select(CgvMemberVO vo)
	public int select(CgvMemberVO vo) {
		return sqlSession.selectOne(namespace+".login", vo);
		
		/*
		int result = 0;
		String sql = "select count(*) from cgv_member where id=? and pass=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
			//close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		*/
	}


	@Override
	public void updateHits(String id) {}


	@Override
	public int update(Object obj) {
		return 0;
	}


	@Override
	public int delete(String id) {
		return 0;
	}


	@Override
	public String selectFile(String id) {
		return "";
	}
	
	
		
	
}
