package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AlumnoEntity;
import com.example.demo.repository.AlumnoRepository;
import com.example.demo.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Override
	public AlumnoEntity create(AlumnoEntity alm) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(alm);
	}

	@Override
	public AlumnoEntity update(AlumnoEntity alm) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(alm);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		alumnoRepository.deleteById(id);
		
	}

	@Override
	public AlumnoEntity read(Long id) {
		// TODO Auto-generated method stub
		return alumnoRepository.findById(id).get();
	}

	@Override
	public List<AlumnoEntity> readAll() {
		// TODO Auto-generated method stub
		return alumnoRepository.findAll();
	}
	

}