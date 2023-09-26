package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ActividadEntity;



public interface ActividadService {
	ActividadEntity create(ActividadEntity prod);
	ActividadEntity update(ActividadEntity prod);
	void delete(Long id);
	ActividadEntity read(Long id);
	List<ActividadEntity>readAll();
}