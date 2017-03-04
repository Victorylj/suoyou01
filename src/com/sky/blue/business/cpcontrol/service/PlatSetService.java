package com.sky.blue.business.cpcontrol.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.cpcontrol.dao.PlatSetDao;
import com.sky.blue.business.cpmanager.entity.SearchBean;


@Service("platSetService")
public class PlatSetService {
	@Autowired
	private PlatSetDao platSetDao;
	 public List<Map<String, Object>> getTaskTypeInfo( Map<String,Object> map) {
		return platSetDao.getTaskTypeInfo(map);
		}
	 public List<Map<String, Object>> getTaskTypeInfo2( Map<String,Object> map) {
		 return platSetDao.getTaskTypeInfo2(map);
	 }
	 public List<Map<String, Object>> getThtlist( Map<String,Object> map) {
		 return platSetDao.getThtlist(map);
	 }
	 public  List<SearchBean> seachCprodList( Map<String,Object> map) {
		 return platSetDao.seachCprodList(map);
	 }
	 public  List<SearchBean> seachCompanyList( Map<String,Object> map) {
		 return platSetDao.seachCompanyList(map);
	 }
	 public int saveOrupdateSubstate( Map<String,Object> map) {
		 int insr=0;
		 /*if(platSetDao.getTasById(map).size()==0){
			 insr=platSetDao.saveSubstate(map);
		 }else{
		 };*/
		 insr=platSetDao.updateSubstate(map);
		 
		 return insr;
	 }
	 public int updateSubtht( Map<String,Object> map) {
		 int insr=0;
		 insr=platSetDao.updateSubtht(map);
		 return insr;
	 }
	 public int changgeTht( Map<String,Object> map) {
		 int insr=0;
		 insr=platSetDao.changgeTht(map);
		 return insr;
	 }
}
