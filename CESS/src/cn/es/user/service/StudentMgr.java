package cn.es.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.es.user.dao.UserDao;
import cn.es.user.model.Student;


public class StudentMgr {
	private UserDao userDao = null;

	public Student checkUser(String username, String password) {
		return null;
	}

	public Student updateUserInfo(Student student) {
		return null;
	}
	
	public boolean changeUserPws(int userId,String newPsw) {
		return false;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
