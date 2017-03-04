package com.sky.blue.business.cpfeeplan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.cpfeeplan.dao.ICpMakefeeLinkDao;
import com.sky.blue.business.cpfeeplan.entity.CpMakefeeLink;
import com.sky.blue.business.cpfeeplan.service.ICpMakefeeLinkService;
import com.sky.blue.business.spmanager.entity.CpMakefeeItem;


@Service("cpMakefeeLinkServiceImpl")
public class CpMakefeeLinkServiceImpl  implements ICpMakefeeLinkService {
	@Autowired
	private ICpMakefeeLinkDao cpMakefeeLinkDao;
	@Override
	public List<CpMakefeeLink> qryCpMakefeeLinkList(CpMakefeeLink cpMakefeeLink)
			throws Exception {
		// TODO Auto-generated method stub
		return cpMakefeeLinkDao.qryCpMakefeeLinkList(cpMakefeeLink);
	}

	@Override
	public int addCpMakefeeLink(CpMakefeeLink cpMakefeeLink) throws Exception {
		// TODO Auto-generated method stub
		int count=0;
		if(cpMakefeeLink.getProvince()==99 && cpMakefeeLink.getFeemeasure_id()!=null){
			CpMakefeeLink delObj = new CpMakefeeLink();
			//删除措施的全部措施项关联
			delObj.setFeemeasure_id(cpMakefeeLink.getFeemeasure_id());
		    cpMakefeeLinkDao.updateCpMakefeeLink(delObj);
		    
		    int len = cpMakefeeLink.getMakeFeeItem().length;       
	        for(int i=0;i<len;i++){
	        	CpMakefeeItem item = cpMakefeeLink.getMakeFeeItem()[i];
	        	if(item!=null){
	        		if(item.getCp_item_id()!=null){
	        			CpMakefeeLink cpMakefeeLinkPram=cpMakefeeLink;
	        			cpMakefeeLinkPram.setCommand_id(item.getCommand_id());
	        			cpMakefeeLinkPram.setFeecode_id(item.getFeecode_id());
	        			List<CpMakefeeLink> cList =cpMakefeeLinkDao.getCpMakefeeLinks(cpMakefeeLinkPram);
	        			for(int j=0;j<cList.size();j++){
	        				CpMakefeeLink link = cList.get(j);
	        				link.setCp_item_count(item.getItem_count());
	        				cpMakefeeLinkDao.addCpMakefeeLink(link);
	        			}
	        		}
	        	}
	        	System.out.println(cpMakefeeLink.getMakeFeeItem()[i].toString());
	        }
		    
		}else{
	    cpMakefeeLinkDao.updateCpMakefeeLink(cpMakefeeLink);
		int len = cpMakefeeLink.getMakeFeeItem().length;
        
        for(int i=0;i<len;i++){
        	CpMakefeeItem item = cpMakefeeLink.getMakeFeeItem()[i];
        	if(item!=null){
        		if(item.getCp_item_id()!=null){
        			cpMakefeeLink.setCp_item_id(item.getCp_item_id());
        			cpMakefeeLink.setCp_item_count(item.getItem_count());
        			cpMakefeeLinkDao.addCpMakefeeLink(cpMakefeeLink);
        			count++;
        		}
        	}
        	System.out.println(cpMakefeeLink.getMakeFeeItem()[i].toString());
        }
		}
		return count;
	}

	@Override
	public int deleteCpMakefeeLink(CpMakefeeLink cpMakefeeLink) throws Exception {
		// TODO Auto-generated method stub
		return cpMakefeeLinkDao.deleteCpMakefeeLink(cpMakefeeLink);
	}

}
