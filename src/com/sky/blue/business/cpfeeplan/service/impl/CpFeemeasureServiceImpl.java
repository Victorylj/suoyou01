package com.sky.blue.business.cpfeeplan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.cpfeeplan.dao.ICpFeemeasureDao;
import com.sky.blue.business.cpfeeplan.entity.CpFeemeasure;
import com.sky.blue.business.cpfeeplan.entity.CpFeemeasureItem;
import com.sky.blue.business.cpfeeplan.service.ICpFeemeasureService;
import com.sky.blue.business.platform.dao.IProvinceDao;
import com.sky.blue.business.platform.entity.Province;


@Service("cpFeemeasureServiceImpl")
public class CpFeemeasureServiceImpl  implements ICpFeemeasureService {
	@Autowired
	private ICpFeemeasureDao cpFeemeasureDao;
	@Autowired
	private IProvinceDao provinceDao;
	@Override
	public List<CpFeemeasure> qryCpFeemeasureList(CpFeemeasure cpFeemeasure)
			throws Exception {
		// TODO Auto-generated method stub
		return cpFeemeasureDao.qryCpFeemeasureList(cpFeemeasure);
	}

	@Override
	public int addCpFeemeasure(CpFeemeasure cpFeemeasure) throws Exception {
		// TODO Auto-generated method stub
		if(cpFeemeasure.getFeemeasure_id()!=null){
			CpFeemeasureItem citem = new CpFeemeasureItem();
			citem.setFeemeasure_id(cpFeemeasure.getFeemeasure_id());
			cpFeemeasureDao.deleteCpFeemeasureItemByMeasureID(citem);
			
			CpFeemeasureItem item = new CpFeemeasureItem();
			item.setFeemeasure_id(cpFeemeasure.getFeemeasure_id());
			item.setFeemeasure_name(cpFeemeasure.getFeemeasure_name());
			item.setFeemeasure_is_pop(cpFeemeasure.getFeemeasure_is_pop());
			item.setFeemeasure_op(cpFeemeasure.getFeemeasure_op());
			item.setFeemeasure_fee(cpFeemeasure.getFeemeasure_fee());
			List<Province> provinceList = provinceDao.getProvinceList(new Province());
			for(int i=0;i<provinceList.size();i++){
				Province pro = provinceList.get(i);
				
				item.setFeemeasure_province(pro.getProvince_id());;
				item.setFeemeasure_province_name(pro.getProvince_name());
				
				cpFeemeasureDao.addCpFeemeasureItem(item);
				System.out.println(pro.getProvince_name());
			}
			
			return cpFeemeasureDao.updateCpFeemeasure(cpFeemeasure);
		}
		int id =cpFeemeasureDao.addCpFeemeasure(cpFeemeasure);
		System.out.println(cpFeemeasure.getFeemeasure_id()+"^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		CpFeemeasureItem item = new CpFeemeasureItem();
		item.setFeemeasure_id(cpFeemeasure.getFeemeasure_id());
		item.setFeemeasure_name(cpFeemeasure.getFeemeasure_name());
		item.setFeemeasure_is_pop(cpFeemeasure.getFeemeasure_is_pop());
		item.setFeemeasure_op(cpFeemeasure.getFeemeasure_op());
		item.setFeemeasure_fee(cpFeemeasure.getFeemeasure_fee());
		List<Province> provinceList = provinceDao.getProvinceList(new Province());
		for(int i=0;i<provinceList.size();i++){
			Province pro = provinceList.get(i);
			
			item.setFeemeasure_province(pro.getProvince_id());;
			item.setFeemeasure_province_name(pro.getProvince_name());
			
			cpFeemeasureDao.addCpFeemeasureItem(item);
			System.out.println(pro.getProvince_name());
		}
		
		return id;
	}

	@Override
	public int deleteCpFeemeasure(CpFeemeasure cpFeemeasure) throws Exception {
		// TODO Auto-generated method stub
		return cpFeemeasureDao.deleteCpFeemeasure(cpFeemeasure);
	}

	@Override
	public List<CpFeemeasureItem> qryCpFeemeasureItemList(
			CpFeemeasureItem cpFeemeasureItem) throws Exception {
		// TODO Auto-generated method stub
		return cpFeemeasureDao.qryCpFeemeasureItemList(cpFeemeasureItem);
	}

	@Override
	public int deleteCpFeemeasureItem(CpFeemeasureItem cpFeemeasureItem)
			throws Exception {
		// TODO Auto-generated method stub
		return cpFeemeasureDao.deleteCpFeemeasureItem(cpFeemeasureItem);
	}

	@Override
	public int addCpFeemeasureItem(CpFeemeasureItem cpFeemeasureItem)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCpFeemeasureItem(CpFeemeasureItem cpFeemeasureItem)
			throws Exception {
		// TODO Auto-generated method stub
		if(cpFeemeasureItem.getFeemeasure_item_id()!=null){
			return cpFeemeasureDao.updateCpFeemeasure(cpFeemeasureItem);
		}
		return 0 ;
	}

}
