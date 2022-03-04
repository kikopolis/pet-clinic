package com.kikopolis.petclinicweb.service.springjpa;

import com.kikopolis.petclinicweb.model.BaseEntity;
import com.kikopolis.petclinicweb.service.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Set;

abstract class AbstractJpa<T extends BaseEntity, ID extends Long, R extends CrudRepository<T, ID>> implements CrudService<T, ID> {
	protected R repository;
	
	@Override
	public T find(ID id) {
		return this.repository.findById(id).orElse(null);
	}
	
	@Override
	public Set<T> findAll() {
		Set<T> entities = new HashSet<>();
		this.repository.findAll().forEach(entities::add);
		return entities;
	}
	
	@Override
	public T save(T object) {
		return this.repository.save(object);
	}
	
	@Override
	public void delete(T object) {
		this.repository.delete(object);
	}
	
	@Override
	public void deleteById(ID id) {
		this.repository.deleteById(id);
	}
}
