package com.sky.blue.business.logon.service;

import java.util.List;

import com.sky.blue.business.logon.entity.User;
import com.sky.blue.exception.UserExistException;


/**
 * 用户管理服务器，负责查询用户、注册用户、锁定用户等操作
 *
 */
public interface IUserService {
	
	
	/**
	 * 注册一个新用户,如果用户名已经存在此抛出UserExistException的异常
	 * @param user 
	 */
	public int register(User user) throws UserExistException;
	/**
     * 更新用户
     * @param user 
	 * @throws Exception 
     */
    public void update(User user) throws Exception;
	

	   /**
     * 根据用户名/密码查询 User对象
     * @param userName 用户名
     * @return User
     */
    public User getUserByUserName(String userName);
	
	/**
	 * 根据userId加载User对象
	 * @param userId
	 * @return
	 */
	public User getUserById(int userId);
	
	public User getUser(User user) throws Exception;
	
	/**
	 * 将用户锁定，锁定的用户不能够登录
	 * @param userName 锁定目标用户的用户名
	 */
	public void lockUser(String userName);
	
	/**
	 * 解除用户的锁定
	 * @param userName 解除锁定目标用户的用户名
	 */
	public void unlockUser(String userName);
	
	/**
	 * 根据用户名为条件，执行模糊查询操作 
	 * @param userName 查询用户名
	 * @return 所有用户名前导匹配的userName的用户
	 */
	public List<User> queryUserByUserName(String userName);
	/**
	 * 获取所有用户
	 * @return 所有用户
	 */
	public List<User> getAllUsers();
	
	public List<User> getUsers(User user) throws Exception;
	
	
	/**
	 * 登陆成功
	 * @param user
	 */
	public void loginSuccess(User user) ;
	
}
