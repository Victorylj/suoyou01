package com.sky.blue.business.complaint.dao;

import java.util.List;

import com.sky.blue.business.complaint.entity.BlackMobileInfo;
import com.sky.blue.business.complaint.entity.ComplaintStat;
import com.sky.blue.business.stat.entity.Caitsat;
import com.sky.blue.business.stat.entity.CallStat;

public interface IComplaintDao {
	public List<BlackMobileInfo> listBlackMobileInfo(BlackMobileInfo binfo) throws Exception;
	public List<ComplaintStat> listComplaintRate(ComplaintStat obj) throws Exception;
	public int updateCmStatus(ComplaintStat obj) throws Exception;
	
	public List<ComplaintStat> getShowStaus() throws Exception;
}
