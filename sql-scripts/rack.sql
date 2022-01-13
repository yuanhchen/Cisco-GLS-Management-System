DROP TABLE IF EXISTS racks;
DROP TABLE IF EXISTS vlans;


CREATE TABLE vlans (
	vlan_id NUMERIC(10) NOT NULL PRIMARY KEY,
	switch_location VARCHAR(50),
	
	subnet_ipv4 VARCHAR(50),
	subnet_ipv6 VARCHAR(50),
	gateway_ipv4 VARCHAR(50),
	gateway_ipv6 VARCHAR(50),
	previous_subnet_ipv4 VARCHAR(50),
	previous_gateway_ipv4 VARCHAR(50)
);
CREATE TABLE racks (
	
	vlan_id NUMERIC(10) NOT NULL,
	building NUMERIC(10) NOT NULL,
	lab NUMERIC(10) NOT NULL,
	row_num NUMERIC(10) NOT NULL,
	rack_num NUMERIC(10) NOT NULL,
	reserved_rack_ip_ipv4 VARCHAR(100),
	reserved_rack_ip_ipv6 VARCHAR(100),
	previous_reserved_rack_ip_ipv4 VARCHAR(100),
	
	primary key (building, lab, row_num, rack_num),
	CONSTRAINT fk_rack
		  FOREIGN KEY(vlan_id) 
		  REFERENCES vlans(vlan_id)
	ON DELETE CASCADE
);

INSERT INTO vlans (vlan_id, subnet_ipv4, switch_location, gateway_ipv4) 
	VALUES (111, '5.1.0.0/16', 'oot1-lab1-sw1', '5.1.0.1');
INSERT INTO racks(vlan_id, building, lab, row_num, rack_num,reserved_rack_ip_v4, reserved_rack_ip_v6) 
	VALUES (111, 1,2,3,4, '5.1.1.x', '5.1.1.x');
	
SELECT * FROM vlans ORDER BY vlan_id;
SELECT * FROM racks ORDER BY building, lab, row_num, rack_num;

DELETE FROM vlans;
DELETE FROM racks;



/* join two tables using their foreign key */

SELECT * FROM vlans, racks
WHERE vlans.vlan_id = racks.vlan_id;


