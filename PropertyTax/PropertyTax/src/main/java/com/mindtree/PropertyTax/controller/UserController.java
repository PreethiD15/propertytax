package com.mindtree.PropertyTax.controller;



import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindtree.PropertyTax.exception.InvalidDataException;
import com.mindtree.PropertyTax.model.User_Details;
import com.mindtree.PropertyTax.repository.ZoneRepository;
import com.mindtree.PropertyTax.service.User_Service;
/**
 * @author m1053638
 *
 */
@Controller
public class UserController {
	@Autowired
User_Service user_Service;
	@Autowired
	ZoneRepository zoneRepository;


	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * @param user_Details
	 * @param result
	 * @return Home page or  Error page
	 */
	@RequestMapping("addUserTax")
	public String AddUserDetail(@ModelAttribute("user_Details") @Valid User_Details user_Details, BindingResult result) {
		try {
		user_Service.addUserToDb(user_Details);
		return "Home";
		}
		catch(InvalidDataException e)
		{
			return "Errorpage";
		}
       catch (Exception e) {
		logger.error("PropertyTax is not found");
		return "Errorpage";
	} finally {
		logger.info("Total payable added and saved successfully");
	}
}

}
