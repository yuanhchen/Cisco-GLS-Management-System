package com.cisco.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vlans")
public class Vlan {


	@Id
	private int vlan_id;
	private String subnet_ipv4;
	private String subnet_ipv6;
	private String switch_location;
	private String gateway_ipv4;
	private String gateway_ipv6;
	private String previous_subnet_ipv4;
	private String previous_gateway_ipv4;
	

//	@OneToMany(
//			mappedBy = "vlan",
//			cascade = CascadeType.ALL,
//			orphanRemoval = true
//			)
//	@JsonIgnore
//	private List<Rack> racks = new ArrayList<Rack>();
	
	public Vlan() {}

	public Vlan(int vlan_id, String subnet_ipv4, String subnet_ipv6, String switch_location, String gateway_ipv4,
			String gateway_ipv6, String previous_subnet_ipv4, String previous_gateway_ipv4) {
		super();
		this.vlan_id = vlan_id;
		this.subnet_ipv4 = subnet_ipv4;
		this.subnet_ipv6 = subnet_ipv6;
		this.switch_location = switch_location;
		this.gateway_ipv4 = gateway_ipv4;
		this.gateway_ipv6 = gateway_ipv6;
		this.previous_subnet_ipv4 = previous_subnet_ipv4;
		this.previous_gateway_ipv4 = previous_gateway_ipv4;
//		this.racks = racks;
	}

	public int getVlan_id() {
		return vlan_id;
	}

	public void setVlan_id(int vlan_id) {
		this.vlan_id = vlan_id;
	}

	public String getSubnet_ipv4() {
		return subnet_ipv4;
	}

	public void setSubnet_ipv4(String subnet_ipv4) {
		this.subnet_ipv4 = subnet_ipv4;
	}

	public String getSubnet_ipv6() {
		return subnet_ipv6;
	}

	public void setSubnet_ipv6(String subnet_ipv6) {
		this.subnet_ipv6 = subnet_ipv6;
	}

	public String getSwitch_location() {
		return switch_location;
	}

	public void setSwitch_location(String switch_location) {
		this.switch_location = switch_location;
	}

	public String getGateway_ipv4() {
		return gateway_ipv4;
	}

	public void setGateway_ipv4(String gateway_ipv4) {
		this.gateway_ipv4 = gateway_ipv4;
	}

	public String getGateway_ipv6() {
		return gateway_ipv6;
	}

	public void setGateway_ipv6(String gateway_ipv6) {
		this.gateway_ipv6 = gateway_ipv6;
	}

	public String getPrevious_subnet_ipv4() {
		return previous_subnet_ipv4;
	}

	public void setPrevious_subnet_ipv4(String previous_subnet_ipv4) {
		this.previous_subnet_ipv4 = previous_subnet_ipv4;
	}

	public String getPrevious_gateway_ipv4() {
		return previous_gateway_ipv4;
	}

	public void setPrevious_gateway_ipv4(String previous_gateway_ipv4) {
		this.previous_gateway_ipv4 = previous_gateway_ipv4;
	}

//	public List<Rack> getRacks() {
//		return racks;
//	}
//
//	public void setRacks(List<Rack> racks) {
//		this.racks = racks;
//	}

	
	
}
