package com.cisco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.model.Vlan;
import com.cisco.repository.RackRepository;
import com.cisco.repository.VlanRepository;


@Service
public class VlanService {

	@Autowired
	public VlanRepository r;
	
	@Autowired
	public RackRepository r2;

	public List<Vlan> listAll() {
		List<Vlan> temp = r.findAll();
		
		// temp.forEach( v -> v.setRack( r2.findByVlan_id( v.getVlan_id()) ));
		
		return temp;
	}
	
	public Vlan save(Vlan vlan) {
        return r.save(vlan);
    }
	
	public Vlan get( Integer id ) {
		return r.getOne( id );
	}
	
	public Optional<Vlan> findbyId(Integer id) {
		return r.findById(id);
	}
	
	public void delete( int id ) {
		r.deleteById(id);;
	}
	
}
