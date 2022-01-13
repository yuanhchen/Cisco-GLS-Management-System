package com.cisco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cisco.model.Vlan;

@Repository
public interface VlanRepository extends JpaRepository<Vlan, Integer> {

	
}
