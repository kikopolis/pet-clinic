package com.kikopolis.petclinicweb.service;

import java.util.Set;

public interface CrudService<T, ID> {
	T find(ID id);
	
	Set<T> findAll();
	
	T save(T object);
	
	void delete(T object);
	
	void deleteById(ID id);
}
