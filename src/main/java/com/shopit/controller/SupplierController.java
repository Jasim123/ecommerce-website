package com.shopit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopit.dao.SupplierDao;
import com.shopit.model.Supplier;

@Controller
public class SupplierController 
{

	@Autowired
	SupplierDao supDAO;
	
	
	@RequestMapping(value="/SupplierView",method = RequestMethod.GET)
	public ModelAndView showSupplier() 
	{  
		String supjsonlist=supDAO.listSupplier();
		ModelAndView mv = new ModelAndView("SupplierView","Supplier",new Supplier());
	//	int id=supDAO.SortId();
		mv.addObject("data",supjsonlist);
		mv.addObject("check", true);
		//mv.addObject("supid",id);
		return mv;
	}
	@RequestMapping(value="/SupplierView",method = RequestMethod.POST)
	public ModelAndView addSupplier(Supplier sup) 
	{
		supDAO.saveorupdate(sup);
		String supjsonlist=supDAO.listSupplier();
		ModelAndView mv = new ModelAndView("SupplierView","Supplier",new Supplier());
		mv.addObject("data",supjsonlist);
		mv.addObject("check",true);
		int id=supDAO.SortId();
		mv.addObject("supid",id);
		return mv;
	}
	@RequestMapping(value="/delsupplier",method = RequestMethod.GET)
	public ModelAndView delSupplier(@RequestParam("sid")int sid) 
	{
		
		
		supDAO.delete(sid);
		String supjsonlist=supDAO.listSupplier();
		ModelAndView m = new ModelAndView("SupplierView","Supplier",new Supplier());
		m.addObject("check",true);
		m.addObject("data",supjsonlist);
		//int id=supDAO.SortId();
		//m.addObject("supid",id);
		return m;
	}
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.GET)
	public ModelAndView Updatesupp(@RequestParam("sid")int sid)
	{
		
		
		Supplier sup =supDAO.DispRecord(sid);
		ModelAndView m = new ModelAndView("SupplierView","Supplier",sup);
		m.addObject("check",false);
		return m;
		
	}

	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public ModelAndView updatesupp(Supplier s)
	{

		supDAO.updateRecord(s);
		String supjsonlist=supDAO.listSupplier();
		ModelAndView m = new ModelAndView("SupplierView","Supplier",new Supplier());
		m.addObject("check",true);
		m.addObject("data",supjsonlist);
		//int id=supDAO.SortId();
		//m.addObject("supid",id);
		return m;
		
	}

	
}
