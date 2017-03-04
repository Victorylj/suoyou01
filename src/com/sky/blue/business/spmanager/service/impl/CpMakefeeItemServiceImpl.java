package com.sky.blue.business.spmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.blue.business.platform.dao.IProvinceDao;
import com.sky.blue.business.platform.entity.Province;
import com.sky.blue.business.spmanager.dao.ICpMakefeeItemDao;
import com.sky.blue.business.spmanager.dao.ISpCommandDao;
import com.sky.blue.business.spmanager.entity.CpMakefeeItem;
import com.sky.blue.business.spmanager.service.ICpMakefeeItemService;
@Service("cpMakefeeItemServiceImpl")
public class CpMakefeeItemServiceImpl  implements ICpMakefeeItemService {
	@Autowired
	private ICpMakefeeItemDao cpMakefeeItemDao;
	@Autowired
	private IProvinceDao provinceDao;
	@Autowired
	private ISpCommandDao spCommandDao;
	
	@Override
	public List<CpMakefeeItem> qryCpMakefeeItemList(CpMakefeeItem cpMakefeeItem)
			throws Exception {
		// TODO Auto-generated method stub
		return cpMakefeeItemDao.qryCpMakefeeItemList(cpMakefeeItem);
	}
	
	@Override
	public int qryCpMakefeeItemCount(CpMakefeeItem cpMakefeeItem)
			throws Exception {
		// TODO Auto-generated method stub
		return cpMakefeeItemDao.qryCpMakefeeItemCount(cpMakefeeItem);
	}
	
	@Override
	public int addCpMakefeeItem(CpMakefeeItem cpMakefeeItem) throws Exception {
		// TODO Auto-generated method stub
		List<Province> provinceList = provinceDao.getProvinceList(new Province());
		if(cpMakefeeItem.getCp_item_id()!=null){
			if(cpMakefeeItem.getOpen_province_id()==99&&cpMakefeeItem.getFeecode_id()!=null&&cpMakefeeItem.getCommand_id()!=null){
				if(cpMakefeeItem.getFeecode_id()>0&&cpMakefeeItem.getCommand_id()>0){
					cpMakefeeItem.setCp_item_id(null);
					CpMakefeeItem obj = new CpMakefeeItem();
					obj.setFeecode_id(cpMakefeeItem.getFeecode_id());
					obj.setCommand_id(cpMakefeeItem.getCommand_id());
					obj.setCommand_share(cpMakefeeItem.getCommand_share());
					//更新指令
					String cmd=cpMakefeeItem.getCommand();
					if(!"".equals(cmd)&&cmd!=null){
						cpMakefeeItem.setCommand_length(cmd.length());
					}
					
					
					
					//更新所有计费项
					List<CpMakefeeItem> list =cpMakefeeItemDao.qryCpMakefeeItemList(obj);
					System.out.println(list.size()+" =============================================");
					for(CpMakefeeItem o:list){
						cpMakefeeItem.setCp_item_id(o.getCp_item_id());
						cpMakefeeItem.setOpen_province_id(o.getOpen_province_id());
						cpMakefeeItem.setOpen_province_name(o.getOpen_province_name());
						cpMakefeeItem.setHide_city(o.getHide_city());
						String proid= String.valueOf(o.getOpen_province_id());
						if(cpMakefeeItem.getOpenProvinceStr().contains(proid)){
							cpMakefeeItem.setItem_status("0");
							cpMakefeeItem.setItem_stat("0");
						}else{
							cpMakefeeItem.setItem_status("1");
						}
						System.out.println("&&&&&&&&&&&&&&"+cpMakefeeItem.toString());
						if(o.getOpen_province_id()==99){
							//cpMakefeeItem.setCommand_status(Integer.parseInt(cpMakefeeItem.getItem_status()));
							spCommandDao.updateSpCommand(cpMakefeeItem);
						}
						cpMakefeeItemDao.updateCpMakefeeItem(cpMakefeeItem);
					}
				}
			}else{
				cpMakefeeItemDao.updateCpMakefeeItem(cpMakefeeItem);
			}
			return 0;
		}
		
		String cmd=cpMakefeeItem.getCommand();
		if(!"".equals(cmd)&&cmd!=null){
			cpMakefeeItem.setCommand_length(cmd.length());
		}
		spCommandDao.addSpCommand(cpMakefeeItem);
		
		for(int i=0;i<provinceList.size();i++){
			
			Province pro = provinceList.get(i);
			String proId = String.valueOf(pro.getProvince_id());
			if(cpMakefeeItem.getOpenProvinceStr()!=null&&!"".equals(cpMakefeeItem.getOpenProvinceStr())){
				System.out.println(proId+"===="+cpMakefeeItem.getOpenProvinceStr());
				if(cpMakefeeItem.getOpenProvinceStr().contains(proId)){
					cpMakefeeItem.setItem_status("0");
					cpMakefeeItem.setItem_stat("0");
				}else{
					cpMakefeeItem.setItem_status("1");
				}
					
			}else{
				cpMakefeeItem.setItem_status("1");
			}
			cpMakefeeItem.setOpen_province_id(pro.getProvince_id());
			cpMakefeeItem.setOpen_province_name(pro.getProvince_name());
			cpMakefeeItemDao.addCpMakefeeItem(cpMakefeeItem);
			System.out.println(pro.getProvince_name());
		}
		return provinceList.size();
	}

	@Override
	public int closeOrOpenCpMakefeeItem(CpMakefeeItem cpMakefeeItem) throws Exception {
		// TODO Auto-generated method stub
		//if(cpMakefeeItem.getOpen_province_id()==99){
			//spCommandDao.closeOrOpenSpCommand(cpMakefeeItem);
		//}
		return cpMakefeeItemDao.closeOrOpenCpMakefeeItem(cpMakefeeItem);
	}

	@Override
	public List<CpMakefeeItem> getOpenCommandCount(CpMakefeeItem cpMakefeeItem) throws Exception {
		// TODO Auto-generated method stub
		return cpMakefeeItemDao.getOpenCommandCount( cpMakefeeItem);
	}


}
