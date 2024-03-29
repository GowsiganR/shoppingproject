package com.niit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.CategoryDAO;
import com.niit.Sections.Category;


@Controller
public class CategoryController {
	@Autowired
	CategoryDAO categoryDAO;
	
	
	@RequestMapping("/getcatpage")
	public String displayCategory(Model m)
	  {
			List<Category> listCategories = categoryDAO.getCategoryList();
			m.addAttribute("listCategories", listCategories);

			for (Category category : listCategories) {
				System.out.println(category.getCategoryName() + ",");
			}
			return "AddCategory";
	}

	   @RequestMapping(value = "/AddCategory", method = RequestMethod.POST)
	    public String insertCategoryData(@RequestParam("name") String name, @RequestParam("catdescription") String description,Model m) {
		Category category = new Category();
		category.setCategoryName(name);
		category.setCategoryDescription(description);
		categoryDAO.addCategory(category);
		
		List<Category> listCategories = categoryDAO.getCategoryList();
		m.addAttribute("listCategories", listCategories);
		return "AddCategory";
}
	   @RequestMapping(value="/deleteCategory/{categoryId}")
		public String deleteCategory(@PathVariable("categoryId") int categoryId,Model m)
		{
			Category category=categoryDAO.getCategory(categoryId);
			
			categoryDAO.deleteCategory(category);
			
			List<Category> listCategories=categoryDAO.getCategoryList();
			m.addAttribute("listCategories",listCategories);
			return "AddCategory";
		}

		@RequestMapping(value="/updateCategory/{categoryId}")
		public String updateCategory(@PathVariable("categoryId") int categoryId,Model m)
		{
			Category category=categoryDAO.getCategory(categoryId);
			
			
			List<Category> listCategories=categoryDAO.getCategoryList();
			m.addAttribute("listCategories",listCategories);
			m.addAttribute("category",category);
			
			return "updateCategory";
		}
		
		@RequestMapping(value="/updateCategoryDB/{categoryId}",method=RequestMethod.POST)
		public String updateCategoryDatabase(@PathVariable("categoryId") int catid,@RequestParam("catname") String catname,
				@RequestParam("catdesc") String catdesc,Model m)
		{
			Category category=categoryDAO.getCategory(catid);
			category.setCategoryName(catname);
			category.setCategoryDescription(catdesc);
			
			categoryDAO.updateCategory(category);
			
			List<Category> listCategories=categoryDAO.getCategoryList();
			m.addAttribute("listCategories",listCategories);
			
			return "AddCategory";
		}
	}
	   