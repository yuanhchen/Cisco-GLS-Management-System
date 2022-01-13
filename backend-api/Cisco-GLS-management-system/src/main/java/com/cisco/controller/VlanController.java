package com.cisco.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.exception.NotFoundException;
import com.cisco.model.Vlan;
import com.cisco.service.VlanService;


@RestController
public class VlanController {

	@Autowired
	private VlanService s;
	
	@GetMapping("/vlans")
	public List<Vlan> getAll() {
		return s.listAll();
	}
	
	@GetMapping("/vlans/{id}")
	public Vlan getAll(@PathVariable Integer id) {
		Optional<Vlan> optVlan = s.findbyId(id);
		if ( optVlan.isPresent() ) {
			return optVlan.get();
		} else {
			throw new NotFoundException("Vlan not found with id: " + id);
		}
	}
	
	
	
	@PostMapping("/vlans")
	public ResponseEntity<?> add( @RequestBody Vlan vlan) {
		
		Boolean vlanExist = s.listAll()
								.stream()
								.anyMatch(p -> p.getVlan_id() == vlan.getVlan_id());
		
		if ( !vlanExist ) {
			s.save(vlan);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/vlans/{id}")
    public Vlan update(@RequestBody Vlan vlan, @PathVariable Integer id) {
		
		Boolean vlanExist = s.listAll().stream().anyMatch(p -> p.getVlan_id() == id);
		
		if ( vlanExist ) {
			vlan.setVlan_id(id);
			return s.save(vlan);
		}
		
		return null;
    }
	
	@DeleteMapping("/vlans/{id}")
    public void delete(@PathVariable Integer id) {
        s.delete(id);
    }
	
}
