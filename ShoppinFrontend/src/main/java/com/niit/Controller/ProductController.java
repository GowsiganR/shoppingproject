package com.niit.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.ProductDAO;
import com.niit.DAO.SupplierDAO;
import com.niit.Sections.Category;
import com.niit.Sections.Product;
import com.niit.Sections.Supplier;

@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="/ProductDisplay")
	public String dispProduct(Model m) {
		List<Product> listProducts = productDAO.getProductList();
		m.addAttribute("listProducts", listProducts);

		return "ProductDisplay";
	}
	
	@RequestMapping(value="/ProductDesc/{productId}")
	public String productDescription(@PathVariable("productId") int proid,Model m) {
		Product product=productDAO.getProduct(proid);
		List<Product> listProducts = productDAO.getProductList();
		m.addAttribute("listProducts", listProducts);
		m.addAttribute("product",product);
	    return "ProductDescription";
	}

    @RequestMapping(value="/Product")
	public String displayProduct(Model m) {
		List<Product> listProducts = productDAO.getProductList();
		m.addAttribute("listProducts", listProducts);
		List<Category> listCategories=categoryDAO.getCategoryList();
		m.addAttribute("listCategories",listCategories);
		List<Supplier> listSuppliers = supplierDAO.getSuppliersList();
		m.addAttribute("listSuppliers", listSuppliers);

		for (Product product : listProducts) {
			System.out.println(product.getProductName() + ",");
		}
		return "AddProduct";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(@RequestParam("proname") String proname, @RequestParam("prodescription") String prodescription,
			@RequestParam("proprice") int proprice,@RequestParam("prostock") int prostock,
			@RequestParam("categoryId") int catid,@RequestParam("supplierId") int supid,@RequestParam("pimage") MultipartFile pimage,Model m) {
		Product product=new Product();
		product.setProductName(proname);
		product.setProductDescription(prodescription);
		product.setPrice(proprice);
		product.setStock(prostock);
		product.setCategoryId(catid);
		product.setSupplierId(supid);
        productDAO.addProduct(product);
        
        String path="C:/Users/gowsigan/eclipse-workspace3/ShoppinFrontend/src/main/webapp/resourcesimages";
		path=path+String.valueOf(product.getProductId())+".jpg";
	
		File image=new File(path);
		if(!pimage.isEmpty())
		{

			try {
				byte[] buffer=pimage.getBytes();	
				FileOutputStream fos=new FileOutputStream(image);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();

			}
			
			catch (Exception e)
			{
				System.out.println("Exception Arised:"+e);
				e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("Problem Occured in File Uploading");
		}
        
        
        List<Product> listProducts = productDAO.getProductList();
		m.addAttribute("listProducts", listProducts);
		List<Category> listCategories=categoryDAO.getCategoryList();
		m.addAttribute("listCategories",listCategories);
		List<Supplier> listSuppliers = supplierDAO.getSuppliersList();
		m.addAttribute("listSuppliers", listSuppliers);

		return "AddProduct";
	}

	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		productDAO.deleteProduct(product);
		
		List<Product> listProducts = productDAO.getProductList();
		m.addAttribute("listProducts", listProducts);
		List<Category> listCategories=categoryDAO.getCategoryList();
		m.addAttribute("listCategories",listCategories);
		List<Supplier> listSuppliers = supplierDAO.getSuppliersList();
		m.addAttribute("listSuppliers", listSuppliers);
		return "AddProduct";
	}

	@RequestMapping(value="/updateProduct/{productId}")
	public String updateCategory(@PathVariable("productId") int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		
		List<Product> listProducts = productDAO.getProductList();
		m.addAttribute("listProducts", listProducts);
		List<Category> listCategories=categoryDAO.getCategoryList();
		m.addAttribute("listCategories",listCategories);
		List<Supplier> listSuppliers = supplierDAO.getSuppliersList();
		m.addAttribute("listSuppliers", listSuppliers);
		m.addAttribute("product",product);
		
		return "updateProduct";
	}
	
	@RequestMapping(value="/updateProductDB/{productId}",method=RequestMethod.POST)
	public String updateProductDatabase(@PathVariable("productId") int proid,@RequestParam("proname") String proname,
			@RequestParam("prodescription") String prodescription,@RequestParam("proprice") int proprice,@RequestParam("prostock") int prostock,
			@RequestParam("categoryId") int catid,@RequestParam("supplierId") int supid,Model m)
	{
		Product product=productDAO.getProduct(proid);
		product.setProductName(proname);
		product.setProductDescription(prodescription);
		product.setPrice(proprice);
		product.setStock(prostock);
		product.setCategoryId(catid);
		product.setSupplierId(supid);
		
		productDAO.updateProduct(product);
		
		List<Product> listProducts = productDAO.getProductList();
		m.addAttribute("listProducts", listProducts);
		List<Category> listCategories=categoryDAO.getCategoryList();
		m.addAttribute("listCategories",listCategories);
		List<Supplier> listSuppliers = supplierDAO.getSuppliersList();
		m.addAttribute("listSuppliers", listSuppliers);
		
		return "AddProduct";
	}
}