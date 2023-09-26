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
@Table(name="PROYECCIONES")
public class ProyEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
  	@Column(name = "ID_PROY")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProy")
    @SequenceGenerator(sequenceName = "SEQ_PROY", allocationSize = 1, name = "seqProy")
	private Long id;
  
  	@Column(name = "TITULO")
  	private String titulo;
  	
  	@Column(name = "DESCRIPCION")
  	private String descripcion;

  	@Column(name = "TIPO")
  	private String tipo;

  	@Column(name = "OBJETIVO")
  	private String objetivo;
  	
  	@Column(name = "EJE_ESTRATEGICO")
  	private String eje_estrategico;
  	
  	@Column(name = "ZONA")
  	private String zona;
  	
  	@Column(name = "PRESUPUESTO")
  	private double presupuesto;
  	
  	@Column(name = "PERIODO")
  	private int periodo;

  	@Column(name = "ESTADO")
  	private String estado;
}