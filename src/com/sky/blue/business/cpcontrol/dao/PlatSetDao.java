package com.sky.blue.business.cpcontrol.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.comm.BasicSqlSupport;


@Repository("platSetDao")
public class PlatSetDao extends BasicSqlSupport{
	

	public List<Map<String, Object>> getTaskTypeInfo(Map<String, Object> map) {
		return session.selectList("mybatis.mapper.Product.getTaskTypeInfo", map);
	}
	public List<Map<String, Object>> getTaskTypeInfo2(Map<String, Object> map) {
		return session.selectList("mybatis.mapper.Product.getTaskTypeInfo2", map);
	}
	public List<Map<String, Object>> getThtlist(Map<String, Object> map) {
		return session.selectList("mybatis.mapper.Product.getThtlist", map);
	}
	public  List<SearchBean> seachCprodList(Map<String, Object> map) {
		return session.selectList("mybatis.mapper.Product.seachCprodList", map);
	}
	public  List<SearchBean> seachCompanyList(Map<String, Object> map) {
		return session.selectList("mybatis.mapper.Product.seachCompanyList", map);
	}
	public List<Map<String, Object>> getTasById(Map<String, Object> map) {
		return session.selectList("mybatis.mapper.Product.getTasById", map);
	}
	public int updateSubstate(Map<String, Object> map) {
		return session.insert("mybatis.mapper.Product.updateSubstate", map);
	}
	public int updateSubtht(Map<String, Object> map) {
		return session.insert("mybatis.mapper.Product.updateSubtht", map);
	}
	public int changgeTht(Map<String, Object> map) {
		return session.insert("mybatis.mapper.Product.changgeTht", map);
	}
	public int saveSubstate(Map<String, Object> map) {
		return session.insert("mybatis.mapper.Product.saveSubstate", map);
	}
}
