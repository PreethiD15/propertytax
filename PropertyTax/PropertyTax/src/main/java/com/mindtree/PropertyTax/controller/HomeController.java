package com.mindtree.PropertyTax.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindtree.PropertyTax.model.Property_Description;
import com.mindtree.PropertyTax.model.Status;
import com.mindtree.PropertyTax.model.Zones;
import com.mindtree.PropertyTax.service.Property_Tax_Service;
/**
 * @author m1053638
 *
 */
@Controller
public class HomeController {

	@Autowired
	Property_Tax_Service property_Tax_Service;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


	/**
	 * @return "Home jsp page"
	 */
	@RequestMapping("home")
	public String home() {
		logger.info("Home Page is Generated");
		return "Home";
	}

	/**
	 * @return "Payment jsp page"
	 */
	@RequestMapping("payment")
	public String Payment() {
		logger.info("Tax Payment Page is Generated");
		return "Payment";

	}

	/**
	 * @return "Payment jsp page"
	 */
	@GetMapping("payment")
	public String paymentPage(ModelMap map) {
		List<Status> statusList = property_Tax_Service.getAllStatus();
		map.put("allStatus", statusList);
		List<Zones> zoneList = property_Tax_Service.getAllZones();
		map.put("allZone", zoneList);
		List<Property_Description> propertyList = property_Tax_Service.getAllPropertyDescription();
		map.put("allProperty", propertyList);
		logger.info("Populated the Status,zones,PropertyDescription in the Payment Page");
		return "Payment";

	}

	/**
	 * @return "ZoneWise_Calculation jsp page"
	 */
	@RequestMapping("zonewiseamount")
	public String zonePage(Model model) {
		logger.info("Zone Page is Generated");
		return "ZoneWise_Calculation";

	}
}
