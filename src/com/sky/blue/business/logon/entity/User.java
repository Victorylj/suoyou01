package com.sky.blue.business.logon.entity;

import java.util.Arrays;
import java.util.Date;

import com.sky.blue.business.beans.BaseEntity;




public class User extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     *锁定用户对应的状态值 
     */
    public static final int USER_LOCK = 1;
    /**
     * 用户解锁对应的状态值
     */
    public static final int USER_UNLOCK = 0;
    /**
     * 管理员类型
     */
    public static final int FORUM_ADMIN = 2;
    /**
     * 普通用户类型
     */
    public static final int NORMAL_USER = 1;
    
    
    private Integer userId;

	private String userName;
	private String account;
  
    private Integer userType = NORMAL_USER;

	private String lastIp;
	
	
	private Date lastVisit;
    
	private String password;

	private Integer locked ;

	private Integer credit;
	private String roles[];
	private String ref_roles;
	private Integer group_id;
	
	private String create_name;
	
	
	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public String getRef_roles() {
		return ref_roles;
	}

	public void setRef_roles(String ref_roles) {
		this.ref_roles = ref_roles;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	
	public String getCreate_name() {
		return create_name;
	}

	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", account=" + account + ", userType=" + userType
				+ ", lastIp=" + lastIp + ", lastVisit=" + lastVisit
				+ ", password=" + password + ", locked=" + locked + ", credit="
				+ credit + ", roles=" + Arrays.toString(roles) + ", ref_roles="
				+ ref_roles + ", group_id=" + group_id + "]";
	}

	



}
