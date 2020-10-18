package com.mindtree.PropertyTax.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.PropertyTax.exception.InvalidDataException;
import com.mindtree.PropertyTax.model.User_Details;
import com.mindtree.PropertyTax.repository.UserRepository;
import com.mindtree.PropertyTax.service.User_Service;
@Service
@Transactional
public class User_Service_Impl implements User_Service {
   @Autowired
   UserRepository userRepository;
   
   //Add the user details to DB
	@Override
	public void addUserToDb(User_Details user_Details) throws Exception,InvalidDataException {
		try {
			if(user_Details==null) {
				throw new InvalidDataException(" Invalid Data are found");
			}
			else
			{
				userRepository.save(user_Details);	
			}
		}
catch(Exception e) {
	throw new Exception();
}
	}

}
