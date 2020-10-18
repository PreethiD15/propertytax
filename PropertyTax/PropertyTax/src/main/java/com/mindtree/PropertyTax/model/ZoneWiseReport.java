package com.mindtree.PropertyTax.model;
/**
 * @author m1053638
 *
 */
public class ZoneWiseReport {
String Zone_name;
String Status_name;
float Total_amount;

//constructor
public ZoneWiseReport() {
	
}

public ZoneWiseReport(String zone_name, String status_name, float total_amount) {
	super();
	Zone_name = zone_name;
	Status_name = status_name;
	Total_amount = total_amount;
}

//getter and setter

public String getZone_name() {
	return Zone_name;
}
public void setZone_name(String zone_name) {
	Zone_name = zone_name;
}
public String getStatus_name() {
	return Status_name;
}
public void setStatus_name(String status_name) {
	Status_name = status_name;
}
public float getTotal_amount() {
	return Total_amount;
}
public void setTotal_amount(float total_amount) {
	Total_amount = total_amount;
}


public void setTotal_amount(double d) {
	Total_amount = (float) d;
	}


@Override
public String toString() {
	return "ZoneWiseReport [Zone_name=" + Zone_name + ", Status_name=" + Status_name + ", Total_amount=" + Total_amount
			+ "]";
}
	


}
