package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ALUMNO")
public class AlumnoEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
  	@Column(name = "ID_ALUMNO")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAlumno")
    @SequenceGenerator(sequenceName = "SEQ_ALUMNO", allocationSize = 1, name = "seqAlumno")
	private Long id;
	
	@Column(name = "CODIGO")
  	private String codigo;
  
  	@Column(name = "NOMBRE")
  	private String nombre;
  	
  	@Column(name = "APELLIDO_PAT")
  	private String apellido_pat;
  	
  	@Column(name = "APELLIDO_MAT")
  	private String apellido_mat;	
  
  	@Column(name = "DNI")
  	private String dni;
  	
  	@Column(name = "EMAIL")
  	private String email;
  	
  	@Column(name = "TELEFONO")
  	private String telefono;
}