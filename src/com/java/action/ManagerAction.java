package com.java.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.java.entity.Manager;
import com.java.service.ManagerService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class ManagerAction extends ActionSupport implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private ManagerService managerService;
	private Manager manager;
	private String error;
	private HttpServletRequest request;
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public String login(){
		HttpSession session=request.getSession();
		Manager currentAdmin=managerService.login(manager);
		if(currentAdmin!=null){
			session.setAttribute("currentAdmin", currentAdmin);
			return SUCCESS;
			
		}else{
			error="用户名或密码不存在";
			return ERROR;
		}
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
}
