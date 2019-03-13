package com.java.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.java.entity.User;
import com.java.service.UserService;
import com.java.util.ResponseUtil;
import com.java.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
@Controller
public class UserAction  extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mainPage;
	private User qryUser;
	private User user;
	private List<User> userlist;
	private String title;
	private String userId;
	@Resource
	private UserService userService;
	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

	public User getQryUser() {
		return qryUser;
	}

	public void setQryUser(User qryUser) {
		this.qryUser = qryUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String list(){
		userlist=userService.queryUser(qryUser);
		mainPage="userList.jsp";
		return SUCCESS;
	}
	
	public String preSave(){
		mainPage="userPresave.jsp";
		if(StringUtil.isNotEmpty(userId)){
			user=userService.getUserById(Integer.parseInt(userId));
			title="修改用户信息";
		}else{
			title="添加学生信息";
		}
		return SUCCESS;
	}
	
	public String save(){
		if(StringUtil.isNotEmpty(userId)){
			user.setUserId(Integer.parseInt(userId));
			userService.updateUser(user);		
		}else{
			userService.addUser(user);
		}
		return "save";
	}
	
	public String delete() throws Exception{
		userService.deleteUser(Integer.parseInt(userId));
		JSONObject rs=new JSONObject();
		rs.put("success", true);
		ResponseUtil.write(ServletActionContext.getResponse(),rs);
		return null;
		
	}
}