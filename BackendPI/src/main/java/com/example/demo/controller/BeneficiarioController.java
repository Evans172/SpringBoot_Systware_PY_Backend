package com.example.demo.controller;
import static com.example.demo.commons.GlobalConstants.API_BENEFICIARIO;

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

import com.example.demo.entity.BeneficiarioEntity;
import com.example.demo.service.BeneficiarioService;



@RestController
@RequestMapping(API_BENEFICIARIO)
public class BeneficiarioController {

	@Autowired
	private BeneficiarioService beneficiarioService;
	
	@GetMapping("/all")
	public List<BeneficiarioEntity> listar() {
		return beneficiarioService.readAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BeneficiarioEntity> listar2(@PathVariable("id") long id) {
		BeneficiarioEntity prod = beneficiarioService.read(id);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Beneficiario")
	  public ResponseEntity<BeneficiarioEntity> createTutorial(@RequestBody BeneficiarioEntity a) {
	    try {
	      BeneficiarioEntity alm = beneficiarioService.create(new BeneficiarioEntity(a.getId(),a.getNombre(),a.getApellido_pat(),a.getApellido_mat(),a.getDni(),a.getTelefono(),a.getDireccion()));

	      return new ResponseEntity<>(alm, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/beneficiario/{id}")
	  public ResponseEntity<BeneficiarioEntity> updateTutorial(@PathVariable("id") long id, @RequestBody BeneficiarioEntity a) {
	    BeneficiarioEntity beneficiario = beneficiarioService.read(id);

	    if (beneficiario!=null) {
	    	beneficiario.setId(beneficiario.getId());
	    	beneficiario.setNombre(beneficiario.getNombre());
	    	beneficiario.setApellido_pat(beneficiario.getApellido_pat());
	    	beneficiario.setApellido_mat(beneficiario.getApellido_mat());
	    	beneficiario.setDni(beneficiario.getDni());
	    	beneficiario.setTelefono(beneficiario.getTelefono());
	    	beneficiario.setDireccion(beneficiario.getDireccion());
	      return new ResponseEntity<>(beneficiarioService.create(beneficiario), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/beneficiario/{id}")
	  public ResponseEntity<HttpStatus> deleteBeneficiario(@PathVariable("id") long id) {
	    try {
	    	beneficiarioService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}