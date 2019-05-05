package com.niit.DAO;

import java.util.List;

import com.niit.Sections.Category;

public interface CategoryDAO {
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	public List<Category> getCategoryList();
	public Category getCategory(int categoryId);

}
