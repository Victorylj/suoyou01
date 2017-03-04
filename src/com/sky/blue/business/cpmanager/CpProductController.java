package com.sky.blue.business.cpmanager;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.blue.business.cpmanager.entity.CpCompany;
import com.sky.blue.business.cpmanager.entity.CpProduct;
import com.sky.blue.business.cpmanager.entity.ProductPackage;
import com.sky.blue.business.cpmanager.service.ICpCompanyService;
import com.sky.blue.business.cpmanager.service.ICpProductService;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.business.platform.entity.Province;
import com.sky.blue.business.platform.service.IProvinceService;
import com.sky.blue.comm.BaseController;
@Controller
public class CpProductController extends BaseController {
	  @Resource(name="cpProductServiceImpl")
	private ICpProductService cpProductService;
		@Resource(name="provinceServiceImpl")
		private IProvinceService provinceService;
	  @Resource(name="cpCompanyServiceImpl")
	private ICpCompanyService cpCompanyService;
	   @RequestMapping("/listCpProduct")
	    public String listCpProduct(HttpServletRequest request,CpProduct cpProduct, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(cpProduct==null){
	        	return "err";
	        }
	        //CpProduct gatewayInfo = new CpProduct();
	        System.out.println("============="+cpProduct.toString());
	        
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<CpProduct> list= cpProductService.qryCpProductList(cpProduct);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	            List<CpCompany> cplist= cpCompanyService.qryCpCompanyList(new CpCompany());
	 	        modelMap.addAttribute("cpList", cplist);
	 	        modelMap.addAttribute("searchObj", cpProduct);
	        } catch (Exception e) {
	        	
	        }
	        return "cpmanager/listCpProduct";
	    }
	   
	   @RequestMapping("/addPackage")
	   public void addPackage(HttpServletRequest request, HttpServletResponse response, ProductPackage productPackage){
		     response.setCharacterEncoding("utf-8");
		     response.setContentType("text/html;charset=UTF-8");
		     cpCompanyService.addPackage(productPackage);
		     PrintWriter out = null;
		     try { 
				out = response.getWriter();
			 } catch (Exception e) {
				e.printStackTrace();
		     }
		     out.print(productPackage.getId());
			 out.flush();
			 out.close();
	   }
	   
	   @RequestMapping("/delPackage")
	   public void delPackage(HttpServletRequest request, HttpServletResponse response, int id){
		   	 response.setCharacterEncoding("utf-8");
		     response.setContentType("text/html;charset=UTF-8");
		     ProductPackage pp = new ProductPackage();
		     pp.setId(id);
		     int num = cpCompanyService.delPackage(pp);
		     PrintWriter out = null;
		     try { 
				
				out = response.getWriter();
			 } catch (Exception e) {
				e.printStackTrace();
		     }
		     out.print(num);
			 out.flush();
			 out.close();
	   }
	   
	   
	   @RequestMapping("/getPackage")
	   public void getPackage(HttpServletRequest request, HttpServletResponse response, int product_id){
		   	 response.setCharacterEncoding("utf-8");
		     response.setContentType("text/html;charset=UTF-8");
		     ProductPackage pp = new ProductPackage();
		     pp.setProduct_id(product_id);
		     List<ProductPackage> li = cpCompanyService.getPackage(pp);
		     PrintWriter out = null;
		     try { 
				
				out = response.getWriter();
			 } catch (Exception e) {
				e.printStackTrace();
		     }
		     out.print(JSONArray.fromObject(li));
			 out.flush();
			 out.close();
	   }
	   
	    @RequestMapping("/addCpProduct")
	    public String addCpProduct(HttpServletRequest request,CpProduct cpProduct, ModelMap modelMap)
	            throws Exception {
	        if(cpProduct==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //CpProduct gatewayInfo = new CpProduct();
	       
	        
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        cpProduct.setCreate_name(dbUser.getUserName());
	        System.out.println(cpProduct.toString());  
	        String prostrs = arrayToString(cpProduct.getProvince());
	        cpProduct.setProvincestr(prostrs);
	        int id =cpProductService.addCpProduct(cpProduct);
	        System.out.println(id+"  ============");
	        return "redirect:/listCpProduct.do";
	    }
	     
	    @RequestMapping("/deleteCpProduct")
	    public void deleteCpProduct(HttpServletRequest request, HttpServletResponse response,CpProduct cpProduct,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+cpProduct.getArrayIds());
	    		int i= cpProductService.deleteCpProduct(cpProduct);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    @RequestMapping("/editCpProduct")
	    public String editCpProduct (HttpServletRequest request,CpProduct cpProduct, ModelMap modelMap)
	            throws Exception {
	        if(cpProduct==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //CpProduct gatewayInfo = new CpProduct();
	        CpProduct cpProductObj=new CpProduct();
	        if(cpProduct.getProduct_id()!=null){
	        	List<CpProduct> list= cpProductService.qryCpProductList(cpProduct);
	         cpProductObj= list.get(0);
	        }else{
	        	 List<CpCompany> list= cpCompanyService.qryCpCompanyList(new CpCompany());
	 	        modelMap.addAttribute("cpList", list);
	        }

	        List<Province> proList= provinceService.getProvinceList(new Province());
	        modelMap.addAttribute("proList", proList); 
	        
	        System.out.println(cpProduct.toString());  
	        
	        modelMap.addAttribute("paramObj", cpProductObj);
	        return "cpmanager/editCpProduct";
	    }
	    
	    @RequestMapping("/checkproductname")
	    public String checkproductname(HttpServletRequest request, HttpServletResponse response) 
	    		throws Exception{
	    	String product_name = request.getParameter("product_name");
	    	
	    	CpProduct cpProduct = new CpProduct();
	    	cpProduct.setProduct_name(product_name);
	    	List<CpProduct> cpProducts = cpProductService.qryCpProductList(cpProduct);
	    	if (!cpProducts.isEmpty() && !(cpProducts == null)) {
				response.getWriter().print("product_name");
			}else {
				response.getWriter().print("ok");
			}
	    	return null;
	    }
}
