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
@Table(name="ACTIVIDADES")
public class ActividadEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
  	@Column(name = "ID_ACTIVIDAD")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqActividad")
    @SequenceGenerator(sequenceName = "SEQ_ACTIVIDAD", allocationSize = 1, name = "seqActividad")
	private Long id;
  
  	@Column(name = "NOMBRE")
  	private String nombre;
  	
  	@Column(name = "FECHA")
  	private String fecha;
  	
  	@Column(name = "RESPONSABLE")
  	private String responsable;

}