package com.cisco.service;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.model.Rack;
import com.cisco.model.RackId;
import com.cisco.repository.RackRepository;


@Service
public class RackService {

	@Autowired
	public RackRepository r;

	public List<Rack> listAll() {
		return r.findAll();
	}
	
	public void save(Rack rack) {
        r.save(rack);
    }
	
	public Rack get( RackId id ) {
		return r.getOne( id );
	}
	
	public void delete( RackId id ) {
		r.deleteById(id);;
	}
	
	public List<Rack> filterByVlanId( List<Rack> input, int vlan_id ) {
		return input.stream().filter( p -> p.getVlan_id() == vlan_id).collect(Collectors.toList()) ;
	}
	
	public List<Rack> filterByBuidling( List<Rack> input, int building ) {
		return input.stream().filter( p -> p.getId().getBuilding() == building).collect(Collectors.toList()) ;
	}

	public List<Rack> filterByLab( List<Rack> input, int lab ) {
		return input.stream().filter( p -> p.getId().getBuilding() == lab).collect(Collectors.toList()) ;
	}

	public List<Rack> filterByRow( List<Rack> input, int row ) {
		return input.stream().filter( p -> p.getId().getBuilding() == row).collect(Collectors.toList()) ;
	}

	public List<Rack> filterByRack( List<Rack> input, int rack ) {
		return input.stream().filter( p -> p.getId().getBuilding() == rack).collect(Collectors.toList()) ;
	}
	
}
