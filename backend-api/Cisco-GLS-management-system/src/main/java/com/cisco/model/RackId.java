package com.cisco.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RackId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4008796499846117685L;
	private int building;
	private int lab;
	private int row_num;
	private int rack_num;
	
	public RackId() {}
	
	public RackId(int building, int lab, int row_num, int rack_num) {
		super();
		this.building = building;
		this.lab = lab;
		this.row_num = row_num;
		this.rack_num = rack_num;
	}

	public int getBuilding() {
		return building;
	}

	public void setBuilding(int building) {
		this.building = building;
	}

	public int getLab() {
		return lab;
	}

	public void setLab(int lab) {
		this.lab = lab;
	}

	public int getRow_num() {
		return row_num;
	}

	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}

	public int getRack_num() {
		return rack_num;
	}

	public void setRack_num(int rack_num) {
		this.rack_num = rack_num;
	}
	
	
}
