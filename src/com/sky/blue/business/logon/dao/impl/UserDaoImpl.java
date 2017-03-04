package com.sky.blue.business.logon.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.logon.dao.IUserDao;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.business.logon.entity.UserRoleLink;
import com.sky.blue.comm.BasicSqlSupport;
import com.sky.blue.exception.UserExistException;
@Repository("userDao")
public class UserDaoImpl  extends BasicSqlSupport  implements IUserDao {

	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return session.selectOne("",userName);
	}

	@Override
	public List<User> queryUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("mybatis.mapper.Bussiness.getUser", user);
	}

	@Override
	public int register(User user) throws UserExistException {
		// TODO Auto-generated method stub
		return session.insert("mybatis.mapper.Bussiness.addUser",user);
	}

	@Override
	public List<User> getUsers(User user) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.getUserList", user);
	}

	@Override
	public int deleteRoleUserLink(User user) throws Exception {
		// TODO Auto-generated method stub
		return session.delete("mybatis.mapper.Bussiness.deleteRoleUserLink", user);

	}

	@Override
	public int addRoleUserLink(UserRoleLink userRolelink) throws Exception {
		// TODO Auto-generated method stub
		return session.insert("mybatis.mapper.Bussiness.addRoleUserLink", userRolelink);

	}

	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateUser", user);
	}

}
