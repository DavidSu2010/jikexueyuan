package com.bs.mall.action;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;
import java.util.Map;

import org.apache.catalina.User;

import com.bs.mall.entity.Role;
import com.bs.mall.entity.Users;
import com.bs.mall.service.UserService;
import com.bs.mall.utils.Pager;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Users user;
    private UserService userService;
    private String loginErr;
    private Pager pager;
    private int currentPage = 1;
    private List<Users> users;
    
    public String login() {
		Users u = userService.login(user.getUsername(), user.getPassword());
	    if(u == null){
	    	loginErr = "用户名或密码错误";
	    	return Action.LOGIN;
	    }else{
	    	Map<String, Object> session = ActionContext.getContext().getSession();
	    	session.put("us", u);
	    	loginErr = "";
	    	return SUCCESS;
	    }
    
    }
    
    public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		loginErr = "";
		session.remove("us");
		return Action.LOGIN;
	}
    
    public String userList(){
    	int totalSize = userService.getTotal();
    	pager = new Pager(currentPage, totalSize);
    	users = userService.findAllPaging(currentPage, pager.getPageSize());
    	return SUCCESS;
    }
    
    public String editUser() {
		Users u = userService.getUserByName(user.getUsername());
		user.setUsername(u.getUsername());
		user.setPassword(u.getPassword());
		user.setRole(u.getRole());
		return SUCCESS;
	}
    
    public String save(){
    	Users u = new Users();
    	Role role = new Role();
    	u.setUsername(user.getUsername());
    	u.setPassword(user.getPassword());
    	role = userService.getRoleByName(user.getRole().getRoles());
    	u.setRole(role);
    	userService.saveOrUpdate(u);
    	return userList();
    }
    
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getLoginErr() {
		return loginErr;
	}
	public void setLoginErr(String loginErr) {
		this.loginErr = loginErr;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
	}
	
	
	
}
