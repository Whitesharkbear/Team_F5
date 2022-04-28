package com.web.f5.admin.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	@RequestMapping ( value = "admin/admin.do", method = RequestMethod.GET )
	public String admin() {
		
		Random rnd =new Random();
		StringBuffer buf =new StringBuffer();
		
		for ( int i = 0; i < 10; i++ ) {
			
		    if ( rnd.nextBoolean() ) {
		    	
		        buf.append( (char)( (int)( rnd.nextInt(26) ) + 97 ) );
		    }else{
		        buf.append( ( rnd.nextInt(5) ) ); 
		    }
		}
		
		System.out.println("난수 --->" + buf);
		
		return "/admin/dashboard";
	}
}
