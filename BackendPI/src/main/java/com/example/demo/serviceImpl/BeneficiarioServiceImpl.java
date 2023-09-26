package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BeneficiarioEntity;
import com.example.demo.repository.BeneficiarioRepository;
import com.example.demo.service.BeneficiarioService;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService{

	
	@Autowired
	private BeneficiarioRepository beneficiarioRepository;
	
	@Override
	public BeneficiarioEntity create(BeneficiarioEntity alm) {
		// TODO Auto-generated method stub
		return beneficiarioRepository.save(alm);
	}

	@Override
	public BeneficiarioEntity update(BeneficiarioEntity alm) {
		// TODO Auto-generated method stub
		return beneficiarioRepository.save(alm);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		beneficiarioRepository.deleteById(id);
		
	}

	@Override
	public BeneficiarioEntity read(Long id) {
		// TODO Auto-generated method stub
		return beneficiarioRepository.findById(id).get();
	}

	@Override
	public List<BeneficiarioEntity> readAll() {
		// TODO Auto-generated method stub
		return beneficiarioRepository.findAll();
	}
	

}