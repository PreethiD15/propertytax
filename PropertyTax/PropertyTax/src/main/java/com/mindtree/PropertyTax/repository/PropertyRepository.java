package com.mindtree.PropertyTax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.PropertyTax.model.Property_Description;
/**
 * @author m1053638
 *
 */
@Repository
public interface PropertyRepository extends JpaRepository<Property_Description, Integer> {

}
