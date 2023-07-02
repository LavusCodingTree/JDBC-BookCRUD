package com.js.controller;

import com.js.dao.MobileCRUD;
import com.js.dto.Mobile;

public class InsertMobile {

	public static void main(String[] args) {
		Mobile m = new Mobile();
		
		m.setId(5);
		m.setName("M10");
		m.setBrand("POCO");
		m.setPrice(45000);
		
		int result = MobileCRUD.insertMobile(m);
		if(result > 0 ) {
			System.out.println("Mobile is Inserted");
		}else {
			System.out.println("Failed To Insert");
		}
	}
}
