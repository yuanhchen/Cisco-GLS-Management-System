package com.cisco.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.model.Rack;
import com.cisco.service.RackService;
import com.fasterxml.jackson.annotation.JsonIgnore;


@RestController
public class RackController {

	@Autowired
	private RackService s;
	
	@JsonIgnore()
	@GetMapping("/racks")
	public List<Rack> getAll(
			@RequestParam(required = false) Integer vlanId,
			@RequestParam(required = false) Integer building,
			@RequestParam(required = false) Integer lab,
			@RequestParam(required = false) Integer row,
			@RequestParam(required = false) Integer rack ) {
		
		List<Rack> result = s.listAll();

		if ( vlanId != null )
			result = s.filterByVlanId( result, vlanId );
		if ( building != null )
			result = s.filterByBuidling( result, building);
		if ( lab != null )
			result = s.filterByLab( result, lab);
		if ( row != null )
			result = s.filterByRow( result, row);
		if ( rack != null )
			result = s.filterByRack( result, rack);
		
		return result;
	}
	
	@GetMapping("/racks/{id}")
	public Rack getOne(@PathVariable String id) {
		return s.get( Rack.parseRackId(id));
	}
	
	@PostMapping("/racks")
	public void add( @RequestBody Rack rack) {
		s.save(rack);
	}
	
	@PutMapping("/racks/{id}")
    public ResponseEntity<?> update(@RequestBody Rack rack, @PathVariable String id) {
        try {
        	
        	s.get(Rack.parseRackId(id)); // checks if the given id exists
        	rack.setId(id);
            s.save(rack);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
	
	@DeleteMapping("/racks/{id}")
    public void deleteOne(@PathVariable String id) {
        s.delete(Rack.parseRackId(id));
    }
	
}
