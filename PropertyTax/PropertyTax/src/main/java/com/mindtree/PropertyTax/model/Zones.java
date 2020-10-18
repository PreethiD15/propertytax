package com.mindtree.PropertyTax.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * @author m1053638
 *
 */

@Entity
@Table
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Zones implements Comparable<Zones> {
	@Id
	@Column(name = "zonenum_Id")
	@Length(min = 3, message = "Zone Id must have at least 3 characters")
	int zonenum_Id;
	@Column(name = "zone_Name")
	@Length(min = 3, message = "Zone Name must have at least 3 characters")
	String zone_Name;

	//constructor
	public Zones() {

	}

	public Zones(int zonenum_Id, String zone_Name) {
		super();
		this.zonenum_Id = zonenum_Id;
		this.zone_Name = zone_Name;
	}

	//getter and setter
	
	public int getZonenum_Id() {
		return zonenum_Id;
	}

	public void setZonenum_Id(int zonenum_Id) {
		this.zonenum_Id = zonenum_Id;
	}

	public String getZone_Name() {
		return zone_Name;
	}

	public void setZone_Name(String zone_Name) {
		this.zone_Name = zone_Name;
	}

	@Override
	public String toString() {
		return "Zones [zonenum_Id=" + zonenum_Id + ", zone_Name=" + zone_Name + "]";
	}
	
	//hashcode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((zone_Name == null) ? 0 : zone_Name.hashCode());
		result = prime * result + zonenum_Id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zones other = (Zones) obj;
		if (zone_Name == null) {
			if (other.zone_Name != null)
				return false;
		} else if (!zone_Name.equals(other.zone_Name))
			return false;
		if (zonenum_Id != other.zonenum_Id)
			return false;
		return true;
	}

	@Override
	public int compareTo(Zones zone) {
		return this.zonenum_Id > zone.zonenum_Id ? 1 : this.zonenum_Id < zone.zonenum_Id ? -1 : 0;
	}

}
