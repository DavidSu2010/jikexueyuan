package com.jikexueyuan.action;

import com.jikexueyuan.pojo.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private User us222;
	private User us;
    
	@Override
	public String execute() throws Exception {
		System.out.println(us.getUsername());
		System.out.println(us.getPassword());
		if (us.getUsername().equals("admin") && us.getPassword().equals("123456")) {
			return "success";
		} else {
			return "error";
		}
	}
	
	public User getUs() {
		return us;
	}

	public void setUs(User us) {
		this.us = us;
	}
	

}
