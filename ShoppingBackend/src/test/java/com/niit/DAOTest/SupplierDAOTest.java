package com.niit.DAOTest;

import static org.junit.Assert.*;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.SupplierDAO;
import com.niit.Sections.Supplier;


public class SupplierDAOTest {
	static SupplierDAO supplierDAO;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	
	
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("True Retailer");
		supplier.setSupplierLocation("Chennai");
	    assertTrue("Problem in Supplier Insertion",supplierDAO.addSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void getSupplierTest()
	{
		assertNotNull("Problem in get Supplier",supplierDAO.getSupplier(2));
	}
	
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(2);
		assertTrue("Problem in Deletion:",supplierDAO.deleteSupplier(supplier));
	}

	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(1);
	    supplier.setSupplierId(1);
		supplier.setSupplierName("FasterTheSeller");
		assertTrue("Problem in Updation",supplierDAO.updateSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void listSupplierTest()
	{
		List<Supplier> listSuppliers=supplierDAO.getSuppliersList();
		assertNotNull("No Suppliers",listSuppliers);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.print(supplier.getSupplierId()+":::");
			System.out.print(supplier.getSupplierName()+":::");
			System.out.println(supplier.getSupplierLocation());
		}
	}
}