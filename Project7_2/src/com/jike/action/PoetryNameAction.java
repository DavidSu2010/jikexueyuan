package com.jike.action;

import java.util.List;

import javax.servlet.ServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jikexueyuan.poetry.entity.Poetry;
import com.jikexueyuan.poetry.service.PoetryService;
import com.jikexueyuan.poetry.service.impl.PoetryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class PoetryNameAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String content;

	@Override
	public String execute() throws Exception {

		ServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		// String content=request.getParameter("title");

		System.out.println(content);

		PoetryService poetryService = new PoetryServiceImpl();
		List<Poetry> pList = null;
		pList = poetryService.searchPoetryByName(content);
		request.setAttribute("pList", pList);

		return "success";
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
