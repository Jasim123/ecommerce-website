package com.shopit.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



import com.google.gson.Gson;
import com.shopit.dao.AdminProductDAO;
import com.shopit.dao.CategoryDaoImpl;
import com.shopit.dao.CategoryDao;
import com.shopit.model.Category;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//import com.dao.AddCategoryDAO;
import com.shopit.dao.AdminProductDAO;
import com.shopit.dao.SupplierDao;
import com.shopit.model.AdminProduct;
import com.shopit.model.Category;
import com.shopit.model.Supplier;
@Controller
public class AdminProductController {
	
	@Autowired
	CategoryDao catDAO;
	@Autowired
	SupplierDao supDAO;
	@Autowired
	AdminProductDAO adProdDAO;
	
	@RequestMapping(value="/AdminProducts",method = RequestMethod.GET)
	public ModelAndView showAdminProduct() 
	{
		
		ModelAndView mv = new ModelAndView("AdminProductPage","AdminProduct",new AdminProduct());
		String catjsonlist=catDAO.list();
		
		
		mv.addObject("data",catjsonlist);
		
		String supjsonlist=supDAO.listSupplier();
		mv.addObject("data2",supjsonlist);
		String adprod=adProdDAO.listAdProd();
		mv.addObject("data3",adprod);
	//int id=adProdDAO.sortId();
		//mv.addObject("adpid",id);
		mv.addObject("check",true);
		return mv;
	}
	@RequestMapping(value="/AdminProducts",method=RequestMethod.POST)
	public ModelAndView addAdminProduct(AdminProduct aprod)
	{
		System.out.println("in addAdminProduct post1");
		adProdDAO.adProdSave(aprod); 
		System.out.println("in addAdminProduct post2");
		String adprd=adProdDAO.listAdProd();
		ModelAndView mv = new ModelAndView("AdminProductPage","AdminProduct",new AdminProduct());
		mv.addObject("data3",adprd);
		String catjsonlist=catDAO.list();
		
		mv.addObject("data",catjsonlist);
		System.out.println("in addAdminProduct post3");
		String supjsonlist=supDAO.listSupplier();
		System.out.println("in addAdminProduct post4");
		mv.addObject("data2",supjsonlist);
		mv.addObject("check",true);
		System.out.println("in addAdminProduct post5");
		int id=adProdDAO.sortId();
		
		System.out.println("in addAdminProduct post6"+id);
		mv.addObject("adpid",id);
		System.out.println("in addAdminProduct post7");
		
		String path="D:\\harsha\\dtproj2\\Chips\\src\\main\\webapp\\Resources\\images\\";
		path=path+String.valueOf(aprod.getAproductId())+".jpg";
		System.out.println("in addAdminProduct post8");
		File f=new File(path);
		System.out.println("in addAdminProduct post9");
		System.out.println("in addAdminProduct post9"+aprod);
		MultipartFile filedet=aprod.getPimage();
		System.out.println("in addAdminProduct post10"+filedet);
		if(!filedet.isEmpty())
		{
			System.out.println("in addAdminProduct post10");
			try
			{
			  byte[] bytes=filedet.getBytes();
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
             			BufferedOutputStream bs=new BufferedOutputStream(fos);
             			bs.write(bytes);
             			bs.close();
            			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
			}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
			
		}

		return mv;
		
	}
	@RequestMapping(value="/deladprod",method = RequestMethod.GET)
	public ModelAndView delAdProd(@RequestParam("adpid")int adpid) 
	{
		
		adProdDAO.deleteAdProd(adpid);
		
		String adpjson=adProdDAO.listAdProd();
			ModelAndView m = new ModelAndView("AdminProductPage","AdminProduct",new AdminProduct());
		m.addObject("check",true);
		m.addObject("data3",adpjson);
		int id=adProdDAO.sortId();
		m.addObject("adpid",id);
		String catjsonlist=catDAO.list();
		
		m.addObject("data",catjsonlist);
		String supjsonlist=supDAO.listSupplier();
		m.addObject("data2",supjsonlist);
		return m;
	}
	@RequestMapping(value="/UpdateAdmprod",method=RequestMethod.GET)
	public ModelAndView updateProd(@RequestParam("adpid")int pid)
	{
		
		
		AdminProduct ad =adProdDAO.DispRecord(pid);
		ModelAndView m = new ModelAndView("AdminProductPage","AdminProduct",ad);
		
		System.out.println("pro idddddddddddddddddddddd"+ad.getAproductId());
		m.addObject("check",false);
		String catjsonlist=catDAO.list();
		
		
		m.addObject("data",catjsonlist);
		String supjsonlist=supDAO.listSupplier();
		m.addObject("data2",supjsonlist);
		String apdjsonlist=adProdDAO.listAdProd();
		m.addObject("data3",apdjsonlist);
		System.out.println(supjsonlist);
		return m;
		
	}

	@RequestMapping(value="/UpdateAdmprod",method=RequestMethod.POST)
	public ModelAndView updateProd(AdminProduct ap)
	{

		adProdDAO.upAdProd(ap);
		String apdjsonlist=adProdDAO.listAdProd();
		ModelAndView m = new ModelAndView("AdminProductPage","AdminProduct",new AdminProduct());
		m.addObject("check",true);
		m.addObject("data3",apdjsonlist);
		String catjsonlist=catDAO.list();
		
		
		
		m.addObject("data",catjsonlist);
		String supjsonlist=supDAO.listSupplier();
		m.addObject("data2",supjsonlist);
	
		int id=adProdDAO.sortId();
		m.addObject("adpid",id);
		return m;
		
	}

}
