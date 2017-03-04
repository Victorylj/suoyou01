package com.sky.blue.business.cpfeeplan.dao;

import java.util.List;

import com.sky.blue.business.cpfeeplan.entity.CpFeemeasure;
import com.sky.blue.business.cpfeeplan.entity.CpFeemeasureItem;


public interface ICpFeemeasureDao {
	public List<CpFeemeasure> qryCpFeemeasureList(CpFeemeasure cpFeemeasure) throws Exception;
	public int addCpFeemeasure(CpFeemeasure cpFeemeasure) throws Exception;
	public int deleteCpFeemeasure(CpFeemeasure cpFeemeasure) throws Exception;
	public int updateCpFeemeasure(CpFeemeasure cpFeemeasure) throws Exception;
	
	public List<CpFeemeasureItem> qryCpFeemeasureItemList(CpFeemeasureItem cpFeemeasureItem) throws Exception;
	public int deleteCpFeemeasureItem(CpFeemeasureItem cpFeemeasureItem) throws Exception;
	public int addCpFeemeasureItem(CpFeemeasureItem cpFeemeasureItem) throws Exception;
	public int updateCpFeemeasureItem(CpFeemeasureItem cpFeemeasureItem) throws Exception;
	public int deleteCpFeemeasureItemByMeasureID(CpFeemeasureItem cpFeemeasureItem) throws Exception;
}
