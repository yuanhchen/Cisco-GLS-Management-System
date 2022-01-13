package com.cisco.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cisco.model.Rack;
import com.cisco.model.RackId;

@Repository
public interface RackRepository extends JpaRepository<Rack, RackId> {
	
}
