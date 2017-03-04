package com.sky.blue.business.cpfeeplan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sky.blue.business.cpfeeplan.dao.ICpFeemeasureDao;
import com.sky.blue.business.cpfeeplan.entity.CpFeemeasure;
import com.sky.blue.business.cpfeeplan.entity.CpFeemeasureItem;
import com.sky.blue.comm.BasicSqlSupport;
@Repository("cpFeemeasureDao")
public class CpFeemeasureDaoImpl extends BasicSqlSupport  implements ICpFeemeasureDao {

	@Override
	public List<CpFeemeasure> qryCpFeemeasureList(CpFeemeasure cpFeemeasure)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listCpFeemeasure", cpFeemeasure);
	}

	@Override
	public int addCpFeemeasure(CpFeemeasure cpFeemeasure) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(cpFeemeasure);
		
		return session.insert("mybatis.mapper.Bussiness.addCpFeemeasure", cpFeemeasure);
	}

	@Override
	public int deleteCpFeemeasure(CpFeemeasure cpFeemeasure) throws Exception {
		// TODO Auto-generated method stub
		String arrIds = cpFeemeasure.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteCpFeemeasure", ids);
	}

	@Override
	public int updateCpFeemeasure(CpFeemeasure cpFeemeasure) throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateCpFeemeasure", cpFeemeasure);
	}

	@Override
	public int addCpFeemeasureItem(CpFeemeasureItem cpFeemeasureItem)
			throws Exception {
		// TODO Auto-generated method stub
		return session.insert("mybatis.mapper.Bussiness.addCpFeemeasureItem", cpFeemeasureItem);

	}

	@Override
	public int updateCpFeemeasureItem(CpFeemeasureItem cpFeemeasureItem)
			throws Exception {
		// TODO Auto-generated method stub
		return session.update("mybatis.mapper.Bussiness.updateCpFeemeasureItem", cpFeemeasureItem);

	}

	@Override
	public List<CpFeemeasureItem> qryCpFeemeasureItemList(
			CpFeemeasureItem cpFeemeasureItem) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("mybatis.mapper.Bussiness.listCpFeemeasureItem", cpFeemeasureItem);

	}

	@Override
	public int deleteCpFeemeasureItem(CpFeemeasureItem cpFeemeasureItem)
			throws Exception {
		// TODO Auto-generated method stub
		String arrIds = cpFeemeasureItem.getArrayIds();
		String[] ids=null;
		if(arrIds!=null&&!"".equals(arrIds)){
			 ids = arrIds.split(",");
		}
		if(ids==null){
			return -1;
		}
		return session.delete("mybatis.mapper.Bussiness.deleteCpFeemeasureItem", ids);
	}

	@Override
	public int deleteCpFeemeasureItemByMeasureID(
			CpFeemeasureItem cpFeemeasureItem) throws Exception {
		// TODO Auto-generated method stub
		return session.delete("mybatis.mapper.Bussiness.deleteCpFeemeasureItemByMeasureID", cpFeemeasureItem);
	}

}
