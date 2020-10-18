package com.mindtree.PropertyTax.serviceTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mindtree.PropertyTax.model.Property_Description;
import com.mindtree.PropertyTax.model.Status;
import com.mindtree.PropertyTax.model.Zones;
import com.mindtree.PropertyTax.repository.PropertyRepository;
import com.mindtree.PropertyTax.repository.StatusRepository;
import com.mindtree.PropertyTax.repository.Unit_Area_ValueRepository;
import com.mindtree.PropertyTax.repository.UserRepository;
import com.mindtree.PropertyTax.repository.ZoneRepository;
import com.mindtree.PropertyTax.service.Property_Tax_Service;

/**
 * @author m1053638
 *
 */
@SpringBootTest
public class Property_Tax_ServiceTest {

	@Autowired
	private Property_Tax_Service property_Tax_Service;

	@MockBean
	private UserRepository userRepository;

	@MockBean
	private ZoneRepository zoneRepository;

	@MockBean
	private StatusRepository statusRepository;
	
	@MockBean 
	private PropertyRepository propertyRepository;
	

	@MockBean 
	private Unit_Area_ValueRepository unit_Area_ValueRepository;
	
	// Zone List Test
	@Test
	public void zoneListTest()
	{
		List<Zones> zones=new ArrayList<Zones>();
		zones.add(new Zones(1,"Zone A"));
		zones.add(new Zones (2,"Zone B"));
		try {
			Mockito.when(property_Tax_Service.getAllZones()).thenReturn(zones);
			assertEquals(2,property_Tax_Service.getAllZones().size());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// Status List Test
	@Test
	public void StatusListTest()
	{
		List<Status> status=new ArrayList<Status>();
		status.add(new Status(1,"Tenanted"));
		status.add(new Status(2,"Owner"));
		try {
			Mockito.when(property_Tax_Service.getAllStatus()).thenReturn(status);
			assertEquals(2,property_Tax_Service.getAllStatus().size());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	// Property Description List Test
	@Test
	public void propertyDescriptionListRest()
	{
		List<Property_Description> propertydescription=new ArrayList<Property_Description>();
		propertydescription.add(new Property_Description(1,"building 1"));
		propertydescription.add(new Property_Description (2,"building 2"));
		try {
			Mockito.when(property_Tax_Service.getAllPropertyDescription()).thenReturn(propertydescription);
			assertEquals(2,property_Tax_Service.getAllPropertyDescription().size());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
