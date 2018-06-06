package com.crud.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.crud.entity.PersonForm;

@Repository
@Transactional
public class Dao {

@Autowired
SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//save Roles
			public void save(PersonForm personForm){
				getSession().save(personForm);
			}
			
	

}
