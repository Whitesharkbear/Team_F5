package com.web.f5.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.f5.dao.ReservationDAO;
import com.web.f5.vo.ReservationVO;

public class ReservationServiceImpl implements ReservationService{

	@Autowired
	ReservationDAO reservationDao;
	
	public int insertResult(ReservationVO vo) {
		return reservationDao.insert(vo);
	}
}
