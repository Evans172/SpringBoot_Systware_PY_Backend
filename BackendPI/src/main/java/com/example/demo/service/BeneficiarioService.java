package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BeneficiarioEntity;


public interface BeneficiarioService {
	BeneficiarioEntity create(BeneficiarioEntity alm);
	BeneficiarioEntity update(BeneficiarioEntity alm);
	void delete(Long id);
	BeneficiarioEntity read(Long id);
	List<BeneficiarioEntity> readAll();
}