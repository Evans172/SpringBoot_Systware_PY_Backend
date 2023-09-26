package com.example.demo.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ActividadEntity;
import com.example.demo.repository.ActividadRepository;
import com.example.demo.service.ActividadService;
@Service
public class ActividadServiceImpl implements ActividadService{
	
	@Autowired
	private ActividadRepository ActividadRepository;

	@Override
	public ActividadEntity create(ActividadEntity actividad) {
		// TODO Auto-generated method stub
		return ActividadRepository.save(actividad);
	}


	@Override
	public ActividadEntity update(ActividadEntity actividad) {
		// TODO Auto-generated method stub
		return ActividadRepository.save(actividad);
	}

	@Override
	public void delete(Long id) {
		ActividadRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActividadEntity read(Long id) {
		// TODO Auto-generated method stub
		return ActividadRepository.findById(id).get();
	}


	@Override
	public List<ActividadEntity> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
