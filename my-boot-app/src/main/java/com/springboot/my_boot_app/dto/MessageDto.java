package com.springboot.my_boot_app.dto;

import org.springframework.stereotype.Component;

@Component
public class MessageDto {

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	} 
	
	
}
