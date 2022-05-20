package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.vo.CgvMemberVO;


public class CgvMemberDAO implements CgvObjectDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "mapper.member";
	
	
	/**
	 * ȸ������ �� ���̵� �ߺ�üũ : idCheck(String id)
	 */
	public int idCheck(String id) {
		return sqlSession.selectOne(namespace+".id_check", id);
	}
	
	/**
	 * ȸ������ - insert(CgvMemberVO vo) 
	 * �θ��� CgvObjectDAO���� ��ӹ޾� ����
	 */
	@Override
	public int insert(Object obj) {
		//Ŭ���� ����ȯ : Object ---> CgvMemberVO
		CgvMemberVO vo = (CgvMemberVO)obj;
		return sqlSession.insert(namespace+".insert", vo);		
	}
	
	/**
	 * �α��� - select(CgvMemberVO vo)
	 */
	public int select(CgvMemberVO vo) {		
		return sqlSession.selectOne(namespace+".login",vo);		
	}
	
	
	/**
	 * ����¡ ó�� - ��ü row ī��Ʈ
	 */
	@Override
	public int execTotalCount() {
		return sqlSession.selectOne(namespace+".count");
	}
	
	
	/**
	 * ȸ��Ż�� ��û/���
	 */
	public int updateJoinStatus(String id, String status) {
		int result = 0;
		int value = Integer.parseInt(status);
		if(value == 0) {
			//��û
			result = sqlSession.update(namespace+".status1", id);
		}else {
			//���
			result = sqlSession.update(namespace+".status2", id);
		}		
		return result;	
	}
	
	
	/**
	 * ȸ�� �� ����
	 */
	@Override
	public Object select(String id) {
		return sqlSession.selectOne(namespace+".content", id); //CgvMemberVO
	}
	
	/**
	 * ȸ�� ��ü ����Ʈ - ����¡ ó��
	 */
	@Override
	public List<Object> select(int startCount, int endCount){
		//�ΰ� �̻��� �Ķ���ʹ� �ݵ�� ��ü���·� ������!!! 
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList(namespace+".list", param);
	}
	
	@Override
	public String selectFile(String id) {
		return "";
	}
	
	@Override
	public int delete(String id) {
		return 0;
	}
	
	@Override
	public int update(Object obj) { 
		return 0;
	}
	
	@Override
	public void updateHits(String id){}
		
}







