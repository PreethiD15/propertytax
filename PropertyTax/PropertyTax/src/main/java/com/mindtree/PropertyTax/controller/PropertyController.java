package com.mindtree.PropertyTax.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.PropertyTax.exception.DataNotFoundException;
import com.mindtree.PropertyTax.exception.ResourceNotFoundException;
import com.mindtree.PropertyTax.model.ZoneWiseReport;
import com.mindtree.PropertyTax.service.Property_Tax_Service;
/**
 * @author m1053638
 *
 */
@Controller
public class PropertyController {
	@Autowired
	Property_Tax_Service property_Tax_Service;

	private static final Logger logger = LoggerFactory.getLogger(PropertyController.class);

	/**
	 * @param year
	 * @param constructed_year
	 * @param square_feet
	 * @param zone
	 * @param property_Description
	 * @param Status
	 * @return totaltax amount or 0
	 */
	@PostMapping("totaltax")
	@ResponseBody
	public float calculateTotalTax(@RequestParam int year, @RequestParam int constructed_year,
			@RequestParam int square_feet, @RequestParam int zone, @RequestParam int property_Description,
			@RequestParam int Status) {
		try {
			float total_amount = property_Tax_Service.calculateTotalTaxPay(year, constructed_year, square_feet, zone,
					property_Description, Status);
			return total_amount;
		} catch (ResourceNotFoundException e) {
			logger.error("PropertyTax data is not found");
			return 0;
		} catch (Exception e) {
			logger.error("PropertyTax is not found");
			return 0;
		} finally {
			logger.info("Total payable added and saved successfully");
		}
	}

	/**
	 * @param yearreport
	 * @param map
	 * @return zone wise calculation list
	 */
	@RequestMapping("taxReport")

	public String generateReport(@RequestParam int yearreport, ModelMap map) {
		try
		{
		List<ZoneWiseReport> zoneReport = property_Tax_Service.zoneYearReport(yearreport);
		map.put("allZoneReport", zoneReport);
		System.out.println(zoneReport);
		return "ZoneWise_Calculation";
		}
		 catch (DataNotFoundException e) {
				logger.error("Zone wise report data is not found");
				return "Errorpage";
			} catch (Exception e) {
				logger.error("Error in ZoneReport");
				return "Errorpage";
			} finally {
				logger.info("Zone Wise Report is generated successfully");
			}
		
	}
}
