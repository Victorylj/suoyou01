package com.sky.blue.business.logon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.logon.dao.IGroupDao;
import com.sky.blue.business.logon.entity.Group;
import com.sky.blue.business.logon.service.IGroupService;

@Service("groupServiceImpl")
public class GroupServiceImpl implements IGroupService {
	@Autowired
	private IGroupDao groupDao;

	@Override
	public List<Group> qryGroupList(Group group) throws Exception {
		// TODO Auto-generated method stub
		return groupDao.qryGroupList(group);
	}

	@Override
	public int addGroup(Group group) throws Exception {
		// TODO Auto-generated method stub
		if (group.getGroup_id() != null) {
			return groupDao.updateGroup(group);
		}
		return groupDao.addGroup(group);
	}

	@Override
	public int deleteGroup(Group group) throws Exception {
		// TODO Auto-generated method stub
		return groupDao.deleteGroup(group);
	}

}
