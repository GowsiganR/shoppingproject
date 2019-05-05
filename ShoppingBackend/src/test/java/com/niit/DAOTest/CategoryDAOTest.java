package com.niit.DAOTest;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.CategoryDAO;
import com.niit.Sections.Category;

public class CategoryDAOTest {
	static CategoryDAO categoryDAO;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}

	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("YAMAHA");
		category.setCategoryDescription("YAMAHA R15 VISION 2");
		assertTrue("Problem in Category Insertion",categoryDAO.addCategory(category));
	}
}
