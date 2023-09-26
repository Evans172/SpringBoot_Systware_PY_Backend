package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AlumnoEntity;

public interface AlumnoService {
	AlumnoEntity create(AlumnoEntity alm);
	AlumnoEntity update(AlumnoEntity alm);
	void delete(Long id);
	AlumnoEntity read(Long id);
	List<AlumnoEntity> readAll();
}