package com.mindtree.PropertyTax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.PropertyTax.model.Unit_Area_Value;
/**
 * @author m1053638
 *
 */
@Repository
public interface Unit_Area_ValueRepository  extends JpaRepository<Unit_Area_Value, Integer>{

}
