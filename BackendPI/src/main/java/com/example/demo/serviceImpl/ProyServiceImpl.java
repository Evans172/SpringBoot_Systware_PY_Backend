package com.example.demo.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProyEntity;
import com.example.demo.repository.ProyRepository;
import com.example.demo.service.ProyService;
@Service
public class ProyServiceImpl implements ProyService{
	
	@Autowired
	private ProyRepository ProyRepository;

	@Override
	public ProyEntity create(ProyEntity proy) {
		// TODO Auto-generated method stub
		return ProyRepository.save(proy);
	}


	@Override
	public ProyEntity update(ProyEntity proy) {
		// TODO Auto-generated method stub
		return ProyRepository.save(proy);
	}

	@Override
	public void delete(Long id) {
		ProyRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProyEntity read(Long id) {
		// TODO Auto-generated method stub
		return ProyRepository.findById(id).get();
	}


	@Override
	public List<ProyEntity> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
