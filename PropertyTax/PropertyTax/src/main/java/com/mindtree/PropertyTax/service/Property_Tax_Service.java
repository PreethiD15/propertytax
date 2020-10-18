package com.mindtree.PropertyTax.service;

import java.util.List;

import com.mindtree.PropertyTax.exception.DataNotFoundException;
import com.mindtree.PropertyTax.exception.ResourceNotFoundException;
import com.mindtree.PropertyTax.model.Property_Description;
import com.mindtree.PropertyTax.model.Status;
import com.mindtree.PropertyTax.model.ZoneWiseReport;
import com.mindtree.PropertyTax.model.Zones;

/**
 * @author m1053638
 *
 */
public interface Property_Tax_Service {
	
	// Retrieve the List of Status in Db

	List<Status> getAllStatus();

	// Retrieve the List of Zones in Db
	
	List<Zones> getAllZones();

	// Retrieve the List of Property_Description in Db
	
	List<Property_Description> getAllPropertyDescription();

	// Calculate the total tax to payable
	
	float calculateTotalTaxPay(int year, int constructed_year, int square_feet, int zone, int property_Description,
			int Status) throws Exception, ResourceNotFoundException;

	// Generate the Zone wise report based on the year
	
	List<ZoneWiseReport> zoneYearReport(int year) throws Exception, DataNotFoundException;
}
