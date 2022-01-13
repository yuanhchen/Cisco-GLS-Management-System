package com.cisco.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="racks")
public class Rack {
	
	@Id
	@Embedded
	private RackId id;

	private String reserved_rack_ip_ipv4; 
	private String reserved_rack_ip_ipv6; 
	private String previous_reserved_rack_ip_ipv4;
	
	// reference to the value of its foreign key: vlan_id
//	@Column(name = "vlan_id", insertable = false, updatable = false  )
	private long vlan_id;
	
//	@ManyToOne(cascade = CascadeType.ALL, optional = false)
//	@JoinColumn(name = "vlan_id", referencedColumnName="vlan_id")
//	@JsonIgnore
//	private Vlan vlan;
	
	public Rack() {}
	
	

	public Rack(RackId id, String reserved_rack_ip_ipv4, String reserved_rack_ip_ipv6,
		String previous_reserved_rack_ip_ipv4, long vlan_id) {
	super();
	this.id = id;
	this.reserved_rack_ip_ipv4 = reserved_rack_ip_ipv4;
	this.reserved_rack_ip_ipv6 = reserved_rack_ip_ipv6;
	this.previous_reserved_rack_ip_ipv4 = previous_reserved_rack_ip_ipv4;
	this.vlan_id = vlan_id;
}



	public long getVlan_id() {
		return this.vlan_id;
	}

//	public Vlan getVlan() {
//		return vlan;
//	}
//
//	public void setVlan(Vlan vlan) {
//		this.vlan = vlan;
//	}

	public RackId getId() {
		return id;
	}
	@JsonProperty("id")
	public void setId(RackId id) {
		this.id = id;
	}
	public void setId(String id) {
		this.id = parseRackId(id);;
	}
	
	public static RackId parseRackId(String id) {
		
		int building = 0, lab = 0, row = 0, rack = 0;
		
		String[] temp = id.split("-");
		if ( temp.length == 4 ) {
			building = Integer. parseInt(temp[0]);
			lab = Integer. parseInt(temp[1]);
			row = Integer. parseInt(temp[2]);
			rack = Integer. parseInt(temp[3]);
		}
		return new RackId( building, lab, row, rack );
	}
	

	public String getReserved_rack_ip_ipv4() {
		return reserved_rack_ip_ipv4;
	}

	public void setReserved_rack_ip_ipv4(String reserved_rack_ip_ipv4) {
		this.reserved_rack_ip_ipv4 = reserved_rack_ip_ipv4;
	}

	public String getReserved_rack_ip_ipv6() {
		return reserved_rack_ip_ipv6;
	}

	public void setReserved_rack_ip_ipv6(String reserved_rack_ip_ipv6) {
		this.reserved_rack_ip_ipv6 = reserved_rack_ip_ipv6;
	}

	public String getPrevious_reserved_rack_ip_ipv4() {
		return previous_reserved_rack_ip_ipv4;
	}

	public void setPrevious_reserved_rack_ip_ipv4(String previous_reserved_rack_ip_ipv4) {
		this.previous_reserved_rack_ip_ipv4 = previous_reserved_rack_ip_ipv4;
	}
	
	
	

	
	
	
	
}
