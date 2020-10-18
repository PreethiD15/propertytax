package com.mindtree.PropertyTax.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * @author m1053638
 *
 */
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Property_Description implements Comparable<Property_Description> {
	@Id
	int building_Id;
	String building_Type;

	//constructor
	public Property_Description() {

	}

	public Property_Description(int building_Id, String building_Type) {
		super();
		this.building_Id = building_Id;
		this.building_Type = building_Type;
	}

	//getter and setter
	
	public int getBuilding_Id() {
		return building_Id;
	}

	public void setBuilding_Id(int building_Id) {
		this.building_Id = building_Id;
	}

	public String getBuilding_Type() {
		return building_Type;
	}

	public void setBuilding_Type(String building_Type) {
		this.building_Type = building_Type;
	}

	//toString method
	
	@Override
	public String toString() {
		return "Property_Description [building_Id=" + building_Id + ", building_Type=" + building_Type + "]";
	}

	// hashcode and equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + building_Id;
		result = prime * result + ((building_Type == null) ? 0 : building_Type.hashCode());
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
		Property_Description other = (Property_Description) obj;
		if (building_Id != other.building_Id)
			return false;
		if (building_Type == null) {
			if (other.building_Type != null)
				return false;
		} else if (!building_Type.equals(other.building_Type))
			return false;
		return true;
	}

	@Override
	public int compareTo(Property_Description property) {
		return this.building_Id > property.building_Id ? 1 : this.building_Id < property.building_Id ? -1 : 0;
	}

}
