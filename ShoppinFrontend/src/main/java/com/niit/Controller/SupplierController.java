package com.niit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.SupplierDAO;
import com.niit.Sections.Supplier;



@Controller

public class SupplierController {
	@Autowired
	SupplierDAO supplierDAO;

	@RequestMapping(value="/Supplier")
	public String displaySupplier(Model m) {
		List<Supplier> listSuppliers = supplierDAO.getSuppliersList();
		m.addAttribute("listSuppliers", listSuppliers);

		for (Supplier supplier : listSuppliers) {
			System.out.println(supplier.getSupplierName() + ",");
		}
		
		return "AddSupplier";
	}

	@RequestMapping(value = "/AddSupplier", method = RequestMethod.POST)
	public String insertSupplierData(@RequestParam("name") String name, @RequestParam("supploc") String supploc,
			Model m) {
		Supplier supplier = new Supplier();
		supplier.setSupplierName(name);
		supplier.setSupplierLocation(supploc);

		supplierDAO.addSupplier(supplier);

		List<Supplier> listSuppliers = supplierDAO.getSuppliersList();
		m.addAttribute("listSuppliers", listSuppliers);
		return "AddSupplier";
	}

	@RequestMapping("/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		
		supplierDAO.deleteSupplier(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.getSuppliersList();
		m.addAttribute("listSuppliers", listSuppliers);
		return "AddSupplier";
	}

	@RequestMapping("/updateSupplier/{supplierId}")
	public String updateSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		
		
		List<Supplier> listSuppliers=supplierDAO.getSuppliersList();
		m.addAttribute("listSuppliers", listSuppliers);
		m.addAttribute("supplier",supplier);
		
		return "updateSupplier";
	}
	
	@RequestMapping(value="/updateSupplierDB/{supplierId}",method=RequestMethod.POST)
	public String updateSupplierDatabase(@PathVariable("supplierId") int supid,@RequestParam("supname") String supname,
			@RequestParam("supploc") String supploc,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supid);
		supplier.setSupplierName(supname);
		supplier.setSupplierLocation(supploc);
		
		supplierDAO.updateSupplier(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.getSuppliersList();
		m.addAttribute("listSuppliers", listSuppliers);
		
		return "AddSupplier";
	}
}

