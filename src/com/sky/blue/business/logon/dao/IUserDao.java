package com.sky.blue.business.logon.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.logon.entity.ModuleRoleLink;
import com.sky.blue.business.logon.entity.Role;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.business.logon.entity.UserRoleLink;
import com.sky.blue.exception.UserExistException;

/**
 * User对象Dao
 */

public interface IUserDao  {
	
    /**
     * 根据用户名查询User对象
     * @param userName 用户名
     * @return 对应userName的User对象，如果不存在，返回null。
     */
	public User getUserByUserName(String userName);
	
	public User getUser(User user) throws Exception;
	/**
	 * 根据用户名为模糊查询条件，查询出所有前缀匹配的User对象
	 * @param userName 用户名查询条件
	 * @return 用户名前缀匹配的所有User对象
	 */
	public List<User> queryUserByUserName(String userName);
	
 	public int  register(User user) throws UserExistException;
	public List<User> getUsers(User user) throws Exception;
	public int updateUser(User user) throws Exception;
	public int deleteRoleUserLink(User user) throws Exception;
	public int addRoleUserLink(UserRoleLink userRolelink) throws Exception;
}
