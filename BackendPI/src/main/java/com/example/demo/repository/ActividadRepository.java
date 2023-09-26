package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ActividadEntity;


public interface ActividadRepository extends JpaRepository<ActividadEntity, Long> {

}
