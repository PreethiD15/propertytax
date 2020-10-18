package com.mindtree.PropertyTax.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.PropertyTax.exception.DataNotFoundException;
import com.mindtree.PropertyTax.exception.ResourceNotFoundException;
import com.mindtree.PropertyTax.model.Property_Description;
import com.mindtree.PropertyTax.model.Status;
import com.mindtree.PropertyTax.model.ZoneWiseReport;
import com.mindtree.PropertyTax.model.Zones;
import com.mindtree.PropertyTax.repository.PropertyRepository;
import com.mindtree.PropertyTax.repository.StatusRepository;
import com.mindtree.PropertyTax.repository.ZoneRepository;
import com.mindtree.PropertyTax.service.Property_Tax_Service;

/**
 * @author m1053638
 *
 */
@Service
@Transactional
public class Property_Tax_Service_Impl implements Property_Tax_Service{

	@Autowired
	StatusRepository statusRepository;
	@Autowired
	ZoneRepository zoneRepository;
	@Autowired
	PropertyRepository propertyRepository;
	 @Autowired
	    EntityManager entityManager;
	 
	 //Retrieve the List of Status in Db
	@Override
	public  List<Status> getAllStatus() {
		List<Status> statusList=statusRepository.findAll();
		return statusList;
	}


	 //Retrieve the List of zones in Db
	@Override
	public List<Zones> getAllZones() {
		List<Zones> zoneList=zoneRepository.findAll();
		return zoneList;
	}


	 //Retrieve the List of Property_Description in Db
	@Override
	public List<Property_Description> getAllPropertyDescription() {
		List<Property_Description> propertyList=propertyRepository.findAll();
		return propertyList;
	}

	//Calculate the total tax payable
	@Override
	public float calculateTotalTaxPay(int year, int constructed_year, int square_feet, int zone, int property_Description,
			int Status) throws Exception,ResourceNotFoundException{
		 float totalTax = 0;
		try {
		 float unitAreaValue=0;
		
		  Query query = entityManager.createQuery("select property_value from  Unit_Area_Value where property_description_building_id="+property_Description+" and status_status_id="+Status+" and zone_zonenum_id="+zone);
		 List<Object> listUAV=query.getResultList();
		 if(listUAV == null) {
			 throw new ResourceNotFoundException("Resource for Tax calculation is not Found");
		 }
		 else {
		 for(Object i:listUAV)
		 {
			 unitAreaValue=(float)i;
			 
		  float total1=square_feet*unitAreaValue*10;
		  int ageOfBuilding=year-constructed_year;
		  float applicableDepression=ageOfBuilding/100;
		  float total2=0;
		  if(ageOfBuilding<=60)
			  total2=total1-applicableDepression;
		  else
			  total2=total1-(float)0.6;
		  float total3=(float)(total2*0.20);
		  float total4=(float)(total3*0.24);
		  totalTax=total3+total4;
		 
		  
		}
		 }
		}
		catch (Exception e) {
			throw new Exception();
		}
		
		
		return totalTax;
		   
	}

	//Retrieve the List of Zone wise report
	@Override
	public List<ZoneWiseReport> zoneYearReport(int yearreport) throws Exception,DataNotFoundException {
		List<ZoneWiseReport> zonewisereport = new ArrayList<ZoneWiseReport>();
		try {
		Query query = entityManager.createQuery(
				"Select z.zone_Name,s.Status_name,sum(u.total_amount) from User_Details u join u.zone z join u.Status s where year="
						+ yearreport + "group by z.zonenum_Id,s.Status_id");
		
		List<Object[]> res = query.getResultList();
		 if(res == null) {
			 throw new DataNotFoundException("ZoneWise Data Result is not found");
		 }
		 else {
		Iterator it = res.iterator();
		while (it.hasNext()) {
			Object[] line = (Object[]) it.next();
			ZoneWiseReport zone = new ZoneWiseReport();
			zone.setZone_name((String) line[0]);
			zone.setStatus_name((String) line[1]);
			zone.setTotal_amount((double) line[2]);

			zonewisereport.add(zone);
		}

		 }
	}
		 catch (Exception e) {
				throw new Exception();
			}
		return zonewisereport;
	}
	
}
