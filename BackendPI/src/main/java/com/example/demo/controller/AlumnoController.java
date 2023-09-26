package com.example.demo.controller;
import static com.example.demo.commons.GlobalConstants.API_ALUMNO;

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

import com.example.demo.entity.AlumnoEntity;
import com.example.demo.service.AlumnoService;



@RestController
@RequestMapping(API_ALUMNO)
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping("/all")
	public List<AlumnoEntity> listar() {
		return alumnoService.readAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AlumnoEntity> listar2(@PathVariable("id") long id) {
		AlumnoEntity prod = alumnoService.read(id);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Alumno")
	  public ResponseEntity<AlumnoEntity> createTutorial(@RequestBody AlumnoEntity a) {
	    try {
	      AlumnoEntity alm = alumnoService.create(new AlumnoEntity(a.getId(),a.getCodigo(),a.getNombre(),a.getApellido_pat(),a.getApellido_mat(),a.getDni(),a.getEmail(),a.getTelefono()));

	      return new ResponseEntity<>(alm, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/alumno/{id}")
	  public ResponseEntity<AlumnoEntity> updateTutorial(@PathVariable("id") long id, @RequestBody AlumnoEntity a) {
	    AlumnoEntity alumno = alumnoService.read(id);

	    if (alumno!=null) {
	    	alumno.setId(alumno.getId());
	    	alumno.setNombre(alumno.getNombre());
	    	alumno.setApellido_pat(alumno.getApellido_pat());
	    	alumno.setApellido_mat(alumno.getApellido_mat());
	    	alumno.setDni(alumno.getDni());
	    	alumno.setEmail(alumno.getEmail());
	    	alumno.setTelefono(alumno.getTelefono());
	      return new ResponseEntity<>(alumnoService.create(alumno), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/alumno/{id}")
	  public ResponseEntity<HttpStatus> deleteAlumno(@PathVariable("id") long id) {
	    try {
	    	alumnoService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}