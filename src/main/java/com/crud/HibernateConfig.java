package com.crud;

import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String HIBERNATE_HBM2DDL_AUTO;
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/takeone");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean(){
		LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("com.crud");
		Properties prop=new Properties();
		prop.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		prop.put("spring.jpa.show-sql", "true");
		prop.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
		sessionFactoryBean.setHibernateProperties(prop);
		return sessionFactoryBean;
		
	}
	@Bean
	public HibernateTransactionManager transactionManager(){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(localSessionFactoryBean().getObject());
		return transactionManager;
	}
	
	

}