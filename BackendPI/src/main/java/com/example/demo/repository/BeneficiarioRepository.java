package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BeneficiarioEntity;


public interface BeneficiarioRepository extends JpaRepository<BeneficiarioEntity, Long>{

}