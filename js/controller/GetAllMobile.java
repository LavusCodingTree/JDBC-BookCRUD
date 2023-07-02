package com.js.controller;

import java.util.ArrayList;

import com.js.dao.MobileCRUD;
import com.js.dto.Mobile;

public class GetAllMobile {

	public static void main(String[] args) {
		MobileCRUD mc = new MobileCRUD();
		ArrayList<Mobile> mobiles = mc.getAllMobile();
		if(mobiles.size()>0) {
			for(Mobile m : mobiles) {
				System.out.println(m);
				System.out.println("==================");
			}
		}else {
			System.out.println("No Mobiles Available");
		}
	}
	
}
