package com.mindtree.PropertyTax.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * @author m1053638
 *
 */
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User_Details implements Comparable<User_Details> {
@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY) 
@Column(name = "user_Id")
int user_Id;
@Column(name = "year")
@Length(min = 4, message = "year must have at least 4 characters")
int year;

@Column(name = "owner_Name")
@Length(min = 5, message = "owner Name must have at least 5 characters")
String owner_Name;

@Column(name = "email")
@Length(min = 5, message = "Email must have at least 5 characters and @ ")
String email;

@Column(name = "address")
@Length(min = 5, message = "Address must have at least 5 characters and @ ")
String address;

@Column(name = "constructed_year")
@Length(min = 4, message = "year must have at least 4 characters")
int constructed_year;

@Column(name = "square_feet")
@Length(min = 4, message = "square_feet must have at least 4 characters")
int square_feet;
@Column(name = "total_amount")
@Length(min = 4, message = "total_amount must have at least 4 characters")
float total_amount;
@OneToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
private Zones zone;
@OneToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
private Property_Description property_Description;
@OneToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
private Status Status;
@OneToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
private Unit_Area_Value unit_Area_Value;

//constructor

public User_Details(int i, int j, String string, String string2, String string3, int k, int l, Zones zone2, Property_Description property, com.mindtree.PropertyTax.model.Status status2, int m) {

}

public User_Details(int user_Id, int year, String owner_Name, String email, String address, int constructed_year,
		int square_feet, float total_amount, Zones zone1, Property_Description property_Description,
		com.mindtree.PropertyTax.model.Status status, Unit_Area_Value unit_Area_Value) {
	super();
	this.user_Id = user_Id;
	this.year = year;
	this.owner_Name = owner_Name;
	this.email = email;
	this.address = address;
	this.constructed_year = constructed_year;
	this.square_feet = square_feet;
	this.total_amount = total_amount;
	this.zone = zone;
	this.property_Description = property_Description;
	Status = status;
	this.unit_Area_Value = unit_Area_Value;
}

//getter and setter

public int getUser_Id() {
	return user_Id;
}

public void setUser_Id(int user_Id) {
	this.user_Id = user_Id;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

public String getOwner_Name() {
	return owner_Name;
}

public void setOwner_Name(String owner_Name) {
	this.owner_Name = owner_Name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public int getConstructed_year() {
	return constructed_year;
}

public void setConstructed_year(int constructed_year) {
	this.constructed_year = constructed_year;
}

public int getSquare_feet() {
	return square_feet;
}

public void setSquare_feet(int square_feet) {
	this.square_feet = square_feet;
}

public float getTotal_amount() {
	return total_amount;
}

public void setTotal_amount(float total_amount) {
	this.total_amount = total_amount;
}

public Zones getZone() {
	return zone;
}

public void setZone(Zones zone) {
	this.zone = zone;
}

public Property_Description getProperty_Description() {
	return property_Description;
}

public void setProperty_Description(Property_Description property_Description) {
	this.property_Description = property_Description;
}

public Status getStatus() {
	return Status;
}

public void setStatus(Status status) {
	Status = status;
}

public Unit_Area_Value getUnit_Area_Value() {
	return unit_Area_Value;
}

public void setUnit_Area_Value(Unit_Area_Value unit_Area_Value) {
	this.unit_Area_Value = unit_Area_Value;
}

@Override
public String toString() {
	return "User_Details [user_Id=" + user_Id + ", year=" + year + ", owner_Name=" + owner_Name + ", email=" + email
			+ ", address=" + address + ", constructed_year=" + constructed_year + ", square_feet=" + square_feet
			+ ", total_amount=" + total_amount + ", zone=" + zone + ", property_Description=" + property_Description
			+ ", Status=" + Status + ", unit_Area_Value=" + unit_Area_Value + "]";
}

//hashcode and equals

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Status == null) ? 0 : Status.hashCode());
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + constructed_year;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((owner_Name == null) ? 0 : owner_Name.hashCode());
	result = prime * result + ((property_Description == null) ? 0 : property_Description.hashCode());
	result = prime * result + square_feet;
	result = prime * result + Float.floatToIntBits(total_amount);
	result = prime * result + ((unit_Area_Value == null) ? 0 : unit_Area_Value.hashCode());
	result = prime * result + user_Id;
	result = prime * result + year;
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
	User_Details other = (User_Details) obj;
	if (Status == null) {
		if (other.Status != null)
			return false;
	} else if (!Status.equals(other.Status))
		return false;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (constructed_year != other.constructed_year)
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (owner_Name == null) {
		if (other.owner_Name != null)
			return false;
	} else if (!owner_Name.equals(other.owner_Name))
		return false;
	if (property_Description == null) {
		if (other.property_Description != null)
			return false;
	} else if (!property_Description.equals(other.property_Description))
		return false;
	if (square_feet != other.square_feet)
		return false;
	if (Float.floatToIntBits(total_amount) != Float.floatToIntBits(other.total_amount))
		return false;
	if (unit_Area_Value == null) {
		if (other.unit_Area_Value != null)
			return false;
	} else if (!unit_Area_Value.equals(other.unit_Area_Value))
		return false;
	if (user_Id != other.user_Id)
		return false;
	if (year != other.year)
		return false;
	if (zone == null) {
		if (other.zone != null)
			return false;
	} else if (!zone.equals(other.zone))
		return false;
	return true;
}

@Override
public int compareTo(User_Details user) {
	return this.user_Id >user.user_Id? 1 : this.user_Id <user.user_Id ? -1 : 0;

}


}
