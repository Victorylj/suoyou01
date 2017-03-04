package com.sky.blue.business.logon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.logon.dao.IUserDao;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.business.logon.entity.UserRoleLink;
import com.sky.blue.business.logon.service.IUserService;
import com.sky.blue.exception.UserExistException;
@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;

	@Override
	public int register(User user) throws UserExistException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try {
				if(user.getUserId()!=null){
					
						userDao.deleteRoleUserLink(user);
					
					String[] roles = user.getRoles();
					if(roles!=null){
						for(String str:roles){
							UserRoleLink userRoleLink = new UserRoleLink();
							userRoleLink.setUser_id(user.getUserId());
							userRoleLink.setRole_id(Integer.parseInt(str));
							userDao.addRoleUserLink(userRoleLink);
						}
					}
					return userDao.updateUser(user);
				}else{
					int i = userDao.register(user);
					int user_id=user.getUserId();
					String[] roles = user.getRoles();
					if(roles!=null){
						for(String str:roles){
							UserRoleLink userRoleLink = new UserRoleLink();
							userRoleLink.setUser_id(user_id);
							userRoleLink.setRole_id(Integer.parseInt(str));
							userDao.addRoleUserLink(userRoleLink);
						}
					}
					
				}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return 0;		

	}

	@Override
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserName(userName);
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUser(user);
	}

	@Override
	public void lockUser(String userName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unlockUser(String userName) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> queryUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loginSuccess(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getUsers(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUsers(user);
	}

}
