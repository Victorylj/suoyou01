package com.sky.blue.business.logon.service;

import java.util.List;

import com.sky.blue.business.logon.entity.Group;


public interface IGroupService {
	public List<Group> qryGroupList(Group group) throws Exception;
	public int addGroup(Group group) throws Exception;
	public int deleteGroup(Group group) throws Exception;
}
