package com.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.Dao;
import com.crud.entity.PersonForm;

@Service
public class ManageService {
	
	@Autowired
	Dao d;
	
	public void save(PersonForm personForm){
		d.save(personForm);
	}
	

}
