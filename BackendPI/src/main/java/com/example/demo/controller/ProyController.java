package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.commons.GlobalConstants.API_PROY;

import com.example.demo.entity.ProyEntity;
import com.example.demo.service.ProyService;

@RestController
@RequestMapping(API_PROY)
public class ProyController {

	@Autowired
	private ProyService ProyService;

	@GetMapping("/all")
	public List<ProyEntity> listar() {
		return ProyService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProyEntity> listar2(@PathVariable("id") long id) {
		ProyEntity proy = ProyService.read(id);
		if (proy!=null) {
			return new ResponseEntity<>(proy, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Proy")
	  public ResponseEntity<ProyEntity> createTutorial(@RequestBody ProyEntity p) {
	    try {
	      ProyEntity proy = ProyService.create(new ProyEntity(p.getId(), p.getTitulo(), p.getDescripcion(),p.getTipo(), p.getObjetivo(), p.getEje_estrategico(), p.getZona(), p.getPresupuesto(), p.getPeriodo(), p.getEstado()));

	      return new ResponseEntity<>(proy, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/proy/{id}")
	  public ResponseEntity<ProyEntity> updateTutorial(@PathVariable("id") long id, @RequestBody ProyEntity proy) {
	    ProyEntity Proy = ProyService.read(id);

	    if (Proy!=null) {
	      Proy.setId(proy.getId());
	      Proy.setTitulo(proy.getTitulo());
	      Proy.setDescripcion(proy.getDescripcion());
	      Proy.setTipo(proy.getTipo());
	      Proy.setObjetivo(proy.getObjetivo());
	      Proy.setEje_estrategico(proy.getEje_estrategico());
	      Proy.setZona(proy.getZona());
	      Proy.setPresupuesto(proy.getPresupuesto());
	      Proy.setEstado(proy.getEstado());
	      Proy.setPeriodo(proy.getPeriodo());
	      return new ResponseEntity<>(ProyService.create(Proy), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/Proy/{id}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
	    try {
	      ProyService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}