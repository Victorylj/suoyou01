package com.sky.blue.business.complaint.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.complaint.dao.IComplaintDao;
import com.sky.blue.business.complaint.entity.BlackMobileInfo;
import com.sky.blue.business.complaint.entity.ComplaintStat;
import com.sky.blue.business.stat.entity.Caitsat;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("complaintDao")
public class ComplaintDaoImpl extends BasicSqlSupport implements IComplaintDao {

	@Override
	public List<BlackMobileInfo> listBlackMobileInfo(BlackMobileInfo binfo)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listComplaintInfo", binfo);
	}

	@Override
	public List<ComplaintStat> listComplaintRate(ComplaintStat obj)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listComplaintRate", obj);
	}

	@Override
	public int updateCmStatus(ComplaintStat obj) throws Exception {
		// TODO Auto-generated method stub
		if(obj.getVtag()==null){
			return session.update("updateCmStatus", obj);
		}else{
			return session.insert("addCmStatus", obj);
		}
	}

	@Override
	public List<ComplaintStat> getShowStaus() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.getShowStaus", null);
	}
}
