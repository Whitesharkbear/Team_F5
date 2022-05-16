package com.web.f5.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.f5.service.ReservationService;
import com.web.f5.service.ReviewService;
import com.web.f5.service.StoreService;
import com.web.f5.vo.ReservationVO;
import com.web.f5.vo.ReviewVO;
import com.web.f5.vo.StoreVO;
@Controller
public class StoreController {

	@Autowired
	ReviewService reviewService;
	@Autowired
	StoreService storeService;
	@Autowired
	ReservationService reservationService;
		

		@RequestMapping(value = "/store_join.do", method = RequestMethod.GET)
		public String Store_join() {
			
			return "store/store_join";
		}
	
		@RequestMapping(value = "/store.do" , method = RequestMethod.GET)
		public ModelAndView store(String rpage) {
			ModelAndView mv = new ModelAndView();
			int startCount = 0;
			int endCount = 0;
			int pageSize = 4;
			int pageCount = 0;
			int dbCount=0;
			int reqPage=1;
			
			dbCount = storeService.totalCountResult();
			if(dbCount % pageSize == 0){
				pageCount = dbCount/pageSize;
			}else{
				pageCount = dbCount/pageSize+1;
			}
			if(rpage != null){
				reqPage = Integer.parseInt(rpage);
				startCount = (reqPage-1) * pageSize+1;
				endCount = reqPage *pageSize;
			}else{
				startCount = 1;
				endCount = pageSize;
			}
			ArrayList<StoreVO> list = new ArrayList<StoreVO>();
			list = storeService.select(startCount, endCount);
			mv.setViewName("store/store");
			mv.addObject("dbCount",dbCount);
			mv.addObject("pageSize",pageSize);
			mv.addObject("reqPage",reqPage);
			mv.addObject("list", list);
			return mv;
		}
	
		@RequestMapping(value = "/store_information.do" , method = RequestMethod.GET)
		public ModelAndView store_infor(String store_idx,String rpage) {
			StoreVO vo = new StoreVO();
			ModelAndView mv = new ModelAndView();
			int startCount = 0;
			int endCount = 0;
			int pageSize = 5;
			int pageCount = 0;
			int dbCount=0;
			int reqPage=1;
			
			dbCount = storeService.totalCountResult();
			if(dbCount % pageSize == 0){
				pageCount = dbCount/pageSize;
			}else{
				pageCount = dbCount/pageSize+1;
			}
			if(rpage != null){
				reqPage = Integer.parseInt(rpage);
				startCount = (reqPage-1) * pageSize+1;
				endCount = reqPage *pageSize;
			}else{
				startCount = 1;
				endCount = pageSize;
			}
			vo = storeService.selectResult(store_idx);
			ArrayList<ReviewVO> list = reviewService.selectListResult(startCount,endCount);
			mv.addObject("vo",vo);
			mv.addObject("list",list);
			mv.setViewName("store/store_information");
			return mv;
		}
		@RequestMapping(value = "/store_join.do", method = RequestMethod.POST)
		public ModelAndView Store_join(StoreVO vo) {
			ModelAndView mv = new ModelAndView();
			int result = storeService.insertResult(vo);
			
			if(result == 1) {
				mv.setViewName("redirect:/store.do");
			}else {
				//에러페이지;
			}
			return mv;
		}
		@RequestMapping(value = "/store_information.do" , method = RequestMethod.POST)
		public ModelAndView store_infor(ReviewVO rvo,ReservationVO revo,HttpSession session) {
			ModelAndView mv = new ModelAndView();
			int result = 0,reviewResult = 0;
			if(revo.getReservation_date() != null) {
		    	revo.setMember_id((String)session.getAttribute("member_id"));
			    result = reservationService.insertResult(revo);
			}
			if(rvo.getReview_content() !=null) {
				rvo.setMember_id((String)session.getAttribute("member_id"));
				System.out.println(rvo.getMember_id());
				reviewResult = reviewService.insertResult(rvo);
			}
			if(result == 1 || reviewResult==1) {
				System.out.println("성공");
				mv.setViewName("store/store_information.do?store_idx="+rvo.getStore_idx());
				return mv;
			}else {
				System.out.println("실패");
				mv.setViewName("store/store_information.do?store_idx="+rvo.getStore_idx());
				return mv;
			}
		}
}
