package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Sections.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOimpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.print("Exception arised "+e);
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.print("Exception arised "+e);
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.print("Exception arised "+e);
			return false;
		}
	}

	@Override
	public List<Product> getProductList() {
		Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Product");
	List<Product> listProducts=(List<Product>)query.list();
	return listProducts;
	}

	@Override
	public Product getProduct(int productId) {
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productId);
		session.close();
		return product;
	}


}

