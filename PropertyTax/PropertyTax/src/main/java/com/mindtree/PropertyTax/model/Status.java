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
public class Status implements Comparable<Status> {
@Id
@Column(name = "Status_Id")
@Length(min = 2, message = "statusid must have at least 2 characters")
int Status_id;
@Column(name = "Status_Name")
@Length(min = 5, message = "status name must have at least 5 characters")
String Status_name;

//constructor
public Status() {
	
}
public Status(int status_id, String status_name) {
	super();
	Status_id = status_id;
	Status_name = status_name;
}

//getter and setter

public int getStatus_id() {
	return Status_id;
}
public void setStatus_id(int status_id) {
	Status_id = status_id;
}
public String getStatus_name() {
	return Status_name;
}
public void setStatus_name(String status_name) {
	Status_name = status_name;
}

@Override
public String toString() {
	return "Status [Status_id=" + Status_id + ", Status_name=" + Status_name + "]";
}

//hashcode and equals

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Status_id;
	result = prime * result + ((Status_name == null) ? 0 : Status_name.hashCode());
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
	Status other = (Status) obj;
	if (Status_id != other.Status_id)
		return false;
	if (Status_name == null) {
		if (other.Status_name != null)
			return false;
	} else if (!Status_name.equals(other.Status_name))
		return false;
	return true;
}
@Override
public int compareTo(Status status) {
	return this.Status_id >status.Status_id? 1 : this.Status_id <status.Status_id ? -1 : 0;
} 


}
