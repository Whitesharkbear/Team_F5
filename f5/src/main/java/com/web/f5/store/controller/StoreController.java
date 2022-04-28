package com.web.f5.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class StoreController {


	
	
		@RequestMapping(value = "/store.do" , method = RequestMethod.GET)
		public String store() {
			return "store/store";
		}
	
		@RequestMapping(value = "/store_information.do" , method = RequestMethod.GET)
		public String store_infor() {
			return "store/store_information";
		}
		@RequestMapping(value = "/store_information2.do" , method = RequestMethod.GET)
		public String store_infor2() {
			return "store/store_information2";
		}
		@RequestMapping(value = "/store_goods.do" , method = RequestMethod.GET)
		public String store_goods() {
			return "store/store_goods";
		}
	
}
