package com.niit.Configure;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.CategoryDAOimpl;
import com.niit.DAO.ProductDAO;
import com.niit.DAO.ProductDAOimpl;
import com.niit.DAO.SupplierDAO;
import com.niit.DAO.SupplierDAOimpl;
import com.niit.Sections.Category;
import com.niit.Sections.Product;
import com.niit.Sections.Supplier;

 	
@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement  

public class DBConfigure {    
 	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		System.out.println("data source");
	DriverManagerDataSource dataSource = new DriverManagerDataSource();   
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl("jdbc:h2:tcp://localhost/~/ecommdb");	
	dataSource.setUsername("lol");
	dataSource.setPassword("lol");
	 
	    return dataSource;
	}

	private Properties getHibernateProperties() {	
		System.out.println("get hibernate");
		Properties properties = new Properties();
	    	properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");	
		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		System.out.println("session factory");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource); 
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(Category.class);
		sessionBuilder.addAnnotatedClasses(Supplier.class);          
		sessionBuilder.addAnnotatedClasses(Product.class);
		
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
	{
		System.out.println("Transaction manager");
	HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	return transactionManager;
	}
	
	  @Bean(name="categoryDAO") public CategoryDAO getCategoryDAO() { return new
	  CategoryDAOimpl();} 
	  @Bean(name="supplierDAO") public SupplierDAO getSupplierDAO() { return new
			  SupplierDAOimpl();}
	  @Bean(name="productDAO") public ProductDAO getProductDAO() { return new
			  ProductDAOimpl();}
	 
}
