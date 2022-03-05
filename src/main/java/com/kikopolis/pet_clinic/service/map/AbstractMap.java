package com.kikopolis.pet_clinic.service.map;

import com.kikopolis.pet_clinic.model.base.BaseEntity;
import com.kikopolis.pet_clinic.service.CrudService;

import java.util.*;

abstract class AbstractMap<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {
	protected Map<Long, T> map = new HashMap<>();
	
	public T find(ID id) {
		return this.map.get(id);
	}
	
	public Set<T> findAll() {
		return new HashSet<>(this.map.values());
	}
	
	public T save(T object) {
		if (object == null) {
			throw new RuntimeException("Object cannot be null");
		}
		if (object.getId() == null) {
			object.setId(this.getNextId());
		}
		this.map.put(object.getId(), object);
		return object;
	}
	
	public void delete(T object) {
		this.map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
	public void deleteById(ID id) {
		this.map.remove(id);
	}
	
	private Long getNextId() {
		try {
			return Collections.max(this.map.keySet()) + 1;
		} catch (NoSuchElementException e) {
			return 1L;
		}
	}
}
