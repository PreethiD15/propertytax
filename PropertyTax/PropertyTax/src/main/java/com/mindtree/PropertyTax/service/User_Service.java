package com.mindtree.PropertyTax.service;

import com.mindtree.PropertyTax.exception.InvalidDataException;
import com.mindtree.PropertyTax.model.User_Details;
/**
 * @author m1053638
 *
 */
public interface User_Service {

	 //Add the user details to Db
	void addUserToDb(User_Details user_Details) throws Exception, InvalidDataException;

}
