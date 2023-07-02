package com.js.controller;

import com.js.dao.MobileCRUD;

public class DeleteMobileById {
	public static void main(String[] args) {
		int result = MobileCRUD.deleteById(1);
		
		if(result != 0) {
			System.out.println("Deleted Sucessfully");
		}else {
			System.out.println("Failed To Delete");
		}
	}

}
