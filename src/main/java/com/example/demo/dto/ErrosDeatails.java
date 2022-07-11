package com.example.demo.dto;

import java.util.Date;

public class ErrosDeatails {

	private Date timeStamp;
	private String msg;
	private String detail;
	
	public ErrosDeatails(Date timeStamp, String msg, String detail) {
		super();
		this.timeStamp = timeStamp;
		this.msg = msg;
		this.detail = detail;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
