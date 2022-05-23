package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.vo.CgvBoardVO;

public class CgvBoardDAO implements CgvObjectDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.board";
	
	//bsfile
	@Override
	public String selectFile(String bid) {
		return sqlSession.selectOne(namespace+".bsfile", bid);
		/*
		String result = "";
		String sql = "select bsfile from cgv_board where bid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, bid);
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
	
	
	// 페이징처리 - 전체 row 카운드
	@Override
	public int execTotalCount() {
		
		return sqlSession.selectOne(namespace + ".count");
		
		/*
		int count = 0;
		String sql = "select count(*) from cgv_board";
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
	
	
	// 게시글 삭제 : delete
	@Override
	public int delete(String bid) {
		return sqlSession.delete(namespace+".delete", bid);
		/*
		int result = 0;
		String sql = "delete from cgv_board where bid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, bid);
			result = pstmt.executeUpdate();
			
			//close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		*/
	}
	
	
	// 게시판 수정
	@Override
	public int update(Object obj) {
		
		//int result = 0;
		//String sql = "";
		CgvBoardVO vo = (CgvBoardVO)obj;
		/*
		if(vo.getBsfile() != "") {
			result = sqlSession.update(namespace+".update1", vo);
		} else {
			result = sqlSession.update(namespace+".update2", vo);
		}*/
		
		return sqlSession.update(namespace+".update", vo);
		
		/*
		try {
			if(vo.getBfile() != "") {
				sql = "update cgv_board set btitle=?, bcontent=?, bfile=?, bsfile=? where bid=?";	
				getPreparedStatement(sql);
				pstmt.setString(1, vo.getBtitle());
				pstmt.setString(2, vo.getBcontent());
				pstmt.setString(3, vo.getBfile());
				pstmt.setString(4, vo.getBsfile());
				pstmt.setString(5, vo.getBid());
			} else {			
				sql = "update cgv_board set btitle=?, bcontent=? where bid=?";
				getPreparedStatement(sql);
				pstmt.setString(1, vo.getBtitle());
				pstmt.setString(2, vo.getBcontent());
				pstmt.setString(3, vo.getBid());
			}
			
			//System.out.println(sql);
			result = pstmt.executeUpdate();
			
			//close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		*/
	}
	
	
	// 조회수 업데이트
	@Override
	public void updateHits(String bid) {
		
		sqlSession.update(namespace+".update_hits", bid);
		
		/*
		String sql = "update cgv_board set bhit=bhit+1 where bid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, bid);	// 파라미터 매핑
			pstmt.executeUpdate();		// 쿼리실행
			
			//close();		// 다음 실행문인 게시글 상세보기를 수행하기 위해 close를 사용하지 않음
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
	
	
	// 게시글 상세보기
	@Override
	public Object select(String bid) {
		
		return sqlSession.selectOne(namespace+".content", bid);
		
		/*
		CgvBoardVO vo = new CgvBoardVO();
		String sql = "select bid, btitle, bcontent, bhit, bdate, bsfile, bfile from cgv_board"
				+ " where bid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, bid);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setBid(rs.getString(1));
				vo.setBtitle(rs.getString(2));
				vo.setBcontent(rs.getString(3));
				vo.setBhits(rs.getInt(4));
				vo.setBdate(rs.getString(5));
				vo.setBsfile(rs.getString(6));
				vo.setBfile(rs.getString(7));
			}
			//close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
		*/

	}
	
	// 리스트 출력
	@Override
	public List<Object> select(int startCount, int endCount) {
		
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList(namespace+".list", param);
		
		/*
		ArrayList<CgvBoardVO> list = new ArrayList<CgvBoardVO>();
		String sql = "select rno, bid, btitle, bhit, bdate from"
				+ " (select rownum rno, bid, btitle, bhit, to_char(bdate,'yyyy/mm/dd') bdate"
				+ " from(select bid, btitle, bhit, bdate from  cgv_board order by bdate desc))"
				+ " where rno between ? and ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, startCount);
			pstmt.setInt(2, endCount);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CgvBoardVO vo = new CgvBoardVO();
				vo.setRno(rs.getInt(1));
				vo.setBid(rs.getString(2));
				vo.setBtitle(rs.getString(3));
				vo.setBhits(rs.getInt(4));
				vo.setBdate(rs.getString(5));
				
				//list에 추가하기!!!
				list.add(vo);
			}
			//close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		*/
	}
	
	// 게시글 등록
	@Override
	public int insert(Object obj) {
		
		CgvBoardVO vo = (CgvBoardVO)obj;
		return sqlSession.insert(namespace+".insert", vo);
		
		/*
		int result = 0;
		String sql = "insert into cgv_board values('b_'||sequ_cgv_board_bid.nextval,?,?,0,sysdate,?,?)";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, vo.getBtitle());
			pstmt.setString(2, vo.getBcontent());
			pstmt.setString(3, vo.getBfile());
			pstmt.setString(4, vo.getBsfile());
			
			result = pstmt.executeUpdate();
			//close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		*/
	}
	
}
