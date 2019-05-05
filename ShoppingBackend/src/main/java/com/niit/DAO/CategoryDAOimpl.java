package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Sections.Category;

@Repository("categoryDAO")
public class CategoryDAOimpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().save(category);
	    
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
	}
}
	@Transactional
	@Override
	public boolean updateCategory(Category category) {
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.print("Exception arised "+e);
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteCategory(Category category) {
		try
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.print("Exception arised "+e);
			return false;
		}
	}

	@Override
	public Category getCategory(int categoryId) {
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,categoryId);
		session.close();
		return category;
	}
	@Override
	public List<Category> getCategoryList() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> listCategories=(List<Category>)query.list();
		return listCategories;
	
	}
}