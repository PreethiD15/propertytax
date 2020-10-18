package com.mindtree.PropertyTax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.PropertyTax.model.User_Details;
/**
 * @author m1053638
 *
 */
public interface UserRepository extends JpaRepository<User_Details, Integer>{ 

}
