package com.mindtree.PropertyTax.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
public class Unit_Area_Value  {
 @Id
@Column(name = "property_zid")
@Length(min = 2, message = "property zone id must have at least 2 characters")
 String property_zid;
@Column(name = "property_value")
@Length(min = 2, message = "unit area value must have at least 2 characters")
 float property_value;

 @OneToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
 private Status status;
 
 @OneToOne (fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
 private Zones zone;
 
 @OneToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
 private Property_Description property_description;
 
 //constructor
public Unit_Area_Value() {
	
}
public Unit_Area_Value(String property_zid, float property_value, Status status, Zones zone,
		Property_Description property_description) {
	super();
	this.property_zid = property_zid;
	this.property_value = property_value;
	this.status = status;
	this.zone = zone;
	this.property_description = property_description;
}

//getter and setter

public String getProperty_zid() {
	return property_zid;
}
public void setProperty_zid(String property_zid) {
	this.property_zid = property_zid;
}
public float getProperty_value() {
	return property_value;
}
public void setProperty_value(float property_value) {
	this.property_value = property_value;
}
public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}
public Zones getZone() {
	return zone;
}
public void setZone(Zones zone) {
	this.zone = zone;
}
public Property_Description getProperty_description() {
	return property_description;
}
public void setProperty_description(Property_Description property_description) {
	this.property_description = property_description;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((property_description == null) ? 0 : property_description.hashCode());
	result = prime * result + Float.floatToIntBits(property_value);
	result = prime * result + ((property_zid == null) ? 0 : property_zid.hashCode());
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	result = prime * result + ((zone == null) ? 0 : zone.hashCode());
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
	Unit_Area_Value other = (Unit_Area_Value) obj;
	if (property_description == null) {
		if (other.property_description != null)
			return false;
	} else if (!property_description.equals(other.property_description))
		return false;
	if (Float.floatToIntBits(property_value) != Float.floatToIntBits(other.property_value))
		return false;
	if (property_zid == null) {
		if (other.property_zid != null)
			return false;
	} else if (!property_zid.equals(other.property_zid))
		return false;
	if (status == null) {
		if (other.status != null)
			return false;
	} else if (!status.equals(other.status))
		return false;
	if (zone == null) {
		if (other.zone != null)
			return false;
	} else if (!zone.equals(other.zone))
		return false;
	return true;
}
 

}
