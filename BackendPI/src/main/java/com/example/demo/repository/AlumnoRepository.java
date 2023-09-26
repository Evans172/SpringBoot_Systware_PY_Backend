package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AlumnoEntity;


public interface AlumnoRepository extends JpaRepository<AlumnoEntity,Long>{

}