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

import static com.example.demo.commons.GlobalConstants.API_ACTIVIDAD;

import com.example.demo.entity.ActividadEntity;
import com.example.demo.service.ActividadService;

@RestController
@RequestMapping(API_ACTIVIDAD)
public class ActividadController {

	@Autowired
	private ActividadService ActividadService;

	@GetMapping("/all")
	public List<ActividadEntity> listar() {
		return ActividadService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ActividadEntity> listar2(@PathVariable("id") long id) {
		ActividadEntity actividad = ActividadService.read(id);
		if (actividad!=null) {
			return new ResponseEntity<>(actividad, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Actividad")
	  public ResponseEntity<ActividadEntity> createTutorial(@RequestBody ActividadEntity p) {
	    try {
	      ActividadEntity actividad = ActividadService.create(new ActividadEntity(p.getId(), p.getNombre(), p.getFecha(),p.getResponsable()));

	      return new ResponseEntity<>(actividad, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/actividad/{id}")
	  public ResponseEntity<ActividadEntity> updateTutorial(@PathVariable("id") long id, @RequestBody ActividadEntity actividad) {
	    ActividadEntity Actividad = ActividadService.read(id);

	    if (Actividad!=null) {
	      Actividad.setId(actividad.getId());
	      Actividad.setNombre(actividad.getNombre());
	      Actividad.setFecha(actividad.getFecha());
	      Actividad.setResponsable(actividad.getResponsable());
	      return new ResponseEntity<>(ActividadService.create(Actividad), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/Actividad/{id}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
	    try {
	      ActividadService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}