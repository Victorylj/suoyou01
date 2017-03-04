package com.sky.blue.business.complaint.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.complaint.dao.IComplaintDao;
import com.sky.blue.business.complaint.entity.BlackMobileInfo;
import com.sky.blue.business.complaint.entity.ComplaintStat;
import com.sky.blue.business.complaint.service.IComplaintService;

@Service("complaintServiceImpl")
public class ComplaintServiceImpl implements IComplaintService {
	@Autowired
	private IComplaintDao complaintDao;


	@Override
	public List<BlackMobileInfo> listBlackMobileInfo(BlackMobileInfo binfo)
			throws Exception {
		// TODO Auto-generated method stub
		return complaintDao.listBlackMobileInfo(binfo);
	}


	@Override
	public List<ComplaintStat> listComplaintRate(ComplaintStat obj)
			throws Exception {
		// TODO Auto-generated method stub
		return complaintDao.listComplaintRate(obj);
	}


	@Override
	public int updateCmStatus(ComplaintStat obj) throws Exception {
		// TODO Auto-generated method stub
		return complaintDao.updateCmStatus(obj);
	}


	@Override
	public List<ComplaintStat> getShowStaus() throws Exception {
		// TODO Auto-generated method stub
		return complaintDao.getShowStaus();
	}
	
}
