package com.sky.blue.business.logon.dao;

import java.util.List;

import com.sky.blue.business.logon.entity.Group;


public interface IGroupDao {
	public List<Group> qryGroupList(Group group) throws Exception;
	public int addGroup(Group group) throws Exception;
	public int deleteGroup(Group group) throws Exception;
	public int updateGroup(Group group) throws Exception;
}
