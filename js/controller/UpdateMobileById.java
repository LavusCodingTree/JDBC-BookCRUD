package com.js.controller;

import com.js.dao.MobileCRUD;
import com.js.dto.Mobile;

public class UpdateMobileById {

	public static void main(String[] args) {
		Mobile m = new Mobile();
		m.setName("F5");
		m.setBrand("Oppo");
		m.setPrice(20000);

		MobileCRUD mc = new MobileCRUD();
		int res = mc.UpdateMobileById(2, m);
		if (res == 1) {
			System.out.println("Updated Sucessfully");
		} else {
			System.out.println("Failed To Update");
		}
	}
}
