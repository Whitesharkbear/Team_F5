package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.vo.CgvNoticeVO;

public class CgvNoticeDAO implements CgvObjectDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.notice";
	
	// nsfile
	@Override
	public String selectFile(String nid) {
		return sqlSession.selectOne(namespace+".nsfile", nid);
		/*
		String result = "";
		String sql = "select nsfile from cgv_notice where nid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, nid);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		*/
	}
	
	// 전체 row 카운트
	@Override
	public int execTotalCount() {
		return sqlSession.selectOne(namespace+".count");
		/*
		int count = 0;
		String sql = "select count(*) from cgv_notice";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
			//close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return count; 
		*/
	}
	
	
	// 공지사항 삭제
	@Override
	public int delete(String nid) {
		return sqlSession.delete(namespace+".delete", nid);
		/*
		int result = 0;
		String sql = "delete from cgv_notice where nid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, nid);
			
			result = pstmt.executeUpdate();
			
			//close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		*/
	}
	
	
	// 공지사항 업데이트
	@Override
	public int update(Object obj) {
		
		CgvNoticeVO vo = (CgvNoticeVO)obj;
		
		return sqlSession.update(namespace+".update", vo);
		
		/*
		int result = 0;
		String sql = "";
		
		
		try {
			
			if(vo.getNfile() != "") {
				sql = "update cgv_notice set ntitle=?, ncontent=?, nfile=?, nsfile=? where nid=?";			
				getPreparedStatement(sql);
				pstmt.setString(1, vo.getNtitle());
				pstmt.setString(2, vo.getNcontent());
				pstmt.setString(3, vo.getNfile());
				pstmt.setString(4, vo.getNsfile());
				pstmt.setString(5, vo.getNid());
			} else {
				sql = "update cgv_notice set ntitle=?, ncontent=? where nid=?";
				getPreparedStatement(sql);
				pstmt.setString(1, vo.getNtitle());
				pstmt.setString(2, vo.getNcontent());
				pstmt.setString(3, vo.getNid());
			}
			
			result = pstmt.executeUpdate();
			
			//close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		*/
	}
	
	
	// 공지사항 조회수 업데이트
	@Override
	public void updateHits(String nid) {
		sqlSession.update(namespace+".updateHits", nid);
		/*
		String sql = "update cgv_notice set nhits=nhits+1 where nid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, nid);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
	}
	
	
	// 공지사항 상세리스트
	@Override
	public CgvNoticeVO select(String nid) {
		return sqlSession.selectOne(namespace+".content", nid);
		/*
		CgvNoticeVO vo = new CgvNoticeVO();
		String sql="select nid, ntitle, nhits, ndate, ncontent, nsfile nfile from cgv_notice where nid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, nid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setNid(rs.getString(1));
				vo.setNtitle(rs.getString(2));
				vo.setNhits(rs.getInt(3));
				vo.setNdate(rs.getString(4));
				vo.setNcontent(rs.getString(5));
				vo.setNsfile(rs.getString(6));
				vo.setNfile(rs.getString(7));
			}
			
			//close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
		*/
	}
	
	// 공지사항 리스트
	@Override
	public List<Object> select(int startCount, int endCount) {
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		return sqlSession.selectList(namespace+".list", param);
		/*
		ArrayList<CgvNoticeVO> list = new ArrayList<CgvNoticeVO>();
		String sql = "select rno, nid, ntitle, nhits, ndate"
				+ " from (select rownum rno, nid, ntitle, nhits, to_char(ndate,'yyyy/mm/dd') ndate"
				+ " from(select nid, ntitle, nhits, ndate from cgv_notice order by ndate desc)"
				+ ") where rno between ? and ?";
		
		
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, startCount);
			pstmt.setInt(2, endCount);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CgvNoticeVO vo = new CgvNoticeVO();
				vo.setRno(rs.getInt(1));
				vo.setNid(rs.getString(2));
				vo.setNtitle(rs.getString(3));
				vo.setNhits(rs.getInt(4));
				vo.setNdate(rs.getString(5));
				
				list.add(vo);
			}
			//close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		*/
	}
	
	
	// 공지사항 등록
	@Override
	public int insert(Object obj) {
		CgvNoticeVO vo = (CgvNoticeVO)obj;
		return sqlSession.insert(namespace+".insert", vo);
		/*
		int result = 0;
		String sql = "insert into cgv_notice values('n_'||SEQU_CGV_NOTICE_NID.nextval,?,?,0,sysdate,?,?)";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, vo.getNtitle());
			pstmt.setString(2, vo.getNcontent());
			pstmt.setString(3, vo.getNfile());
			pstmt.setString(4, vo.getNsfile());
			
			result = pstmt.executeUpdate();
			
			//close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		*/
	}
	
	
}









