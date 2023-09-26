package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ProyEntity;



public interface ProyService {
	ProyEntity create(ProyEntity prod);
	ProyEntity update(ProyEntity prod);
	void delete(Long id);
	ProyEntity read(Long id);
	List<ProyEntity>readAll();
}