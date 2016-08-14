package com.xhc.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xhc.entity.Users;
import com.xhc.service.UsersService;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = -1799577135387097221L;
	public Users users;

	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	public String userList() {
		UsersService userService = new UsersService();
		List<Users> list = userService.findAll();
		ServletRequest request = ServletActionContext.getRequest();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		session.setAttribute("users", list);
		return "mgr";
	}

	/**
	 * 用户注册
	 * 
	 * @return
	 */
	public String register() {
		UsersService us = new UsersService();
		us.save(users);
		return "reg_sussess";

	}

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	public String login() {
		UsersService us = new UsersService();
		List<Users> list = new ArrayList<Users>();
		String username = users.getUser_name();
		String password = users.getPassword();
		users = us.findByName(username);
		if (users.getUser_name() == null) {
			return "fail";
		} else {
			if (users.getPassword().equals(password)) {
				if (users.isIsadmin()) {
					return userList();
				} else {
					ServletRequest request = ServletActionContext.getRequest();
					HttpServletRequest req = (HttpServletRequest) request;
					HttpSession session = req.getSession();
					session.setAttribute("users", users);
					return "success";
				}
			}
		}
		return "fail";

	}

	/**
	 * 根据主键查询用户信息
	 * 
	 * @return
	 */
	public String get() {
		UsersService us = new UsersService();
		Users user = new Users();
		user = us.get(users.getId());
		ServletRequest request = ServletActionContext.getRequest();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		session.setAttribute("users", user);
		if (us != null) {
			return "mgr_info";
		} else {
			return userList();
		}

	}

	/**
	 * 根据主键删除用户信息
	 * 
	 * @return
	 */
	public String delete() {
		UsersService us = new UsersService();
		int id = users.getId();
		Users user = us.get(id);
		if (!user.isIsadmin()) {
			us.delete(id);
		}
		return userList();
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
}
