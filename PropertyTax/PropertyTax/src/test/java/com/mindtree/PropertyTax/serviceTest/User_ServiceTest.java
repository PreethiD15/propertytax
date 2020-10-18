package com.mindtree.PropertyTax.serviceTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mindtree.PropertyTax.model.Property_Description;
import com.mindtree.PropertyTax.model.Status;
import com.mindtree.PropertyTax.model.User_Details;
import com.mindtree.PropertyTax.model.ZoneWiseReport;
import com.mindtree.PropertyTax.model.Zones;
import com.mindtree.PropertyTax.repository.UserRepository;
import com.mindtree.PropertyTax.service.Property_Tax_Service;
import com.mindtree.PropertyTax.service.User_Service;
/**
 * @author m1053638
 *
 */
@SpringBootTest
public class User_ServiceTest {
	@Autowired
	private User_Service user_Service;
	@Autowired
	private Property_Tax_Service property_Tax_Service;

	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void userListTest()
	{
		Zones zone=new Zones(110,"zone A");
		Status status =new Status(10,"Status A");
		Property_Description property=new Property_Description(101,"building 1");
		User_Details user=new User_Details(1,2020,"preethi","preethi@gmail.com","chennai",1200,0,zone,property,status,0);
		try {
			float tax = property_Tax_Service.calculateTotalTaxPay(2020, 2018, 1200, zone.getZonenum_Id(), property.getBuilding_Id(), status.getStatus_id());
			 
			  float unitAreaValue=(float) 5.0;
			float total1=1200*unitAreaValue*10;
			  int ageOfBuilding=2020-2018;
			  float applicableDepression=2/100;
			  float total2=0;
			  if(ageOfBuilding<=60)
				  total2=total1-applicableDepression;
			  else
				  total2=total1-(float)0.6;
			  float total3=(float)(total2*0.20);
			  float total4=(float)(total3*0.24);
			  float totalTax = total3+total4;
			 
			  assertEquals(14884,totalTax);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void zonewisereportTest()
	{
		List<ZoneWiseReport> zonewisereport=new ArrayList<ZoneWiseReport>();
		int year=2020;
		zonewisereport.add(new ZoneWiseReport("Zone A","Owner",(float) 1484.0));
		zonewisereport.add(new ZoneWiseReport("Zone A","Tenanted",(float) 1484.0));
		try {
			Mockito.when(property_Tax_Service.zoneYearReport(year));
			assertEquals(2,property_Tax_Service.zoneYearReport(year).size());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	

}
