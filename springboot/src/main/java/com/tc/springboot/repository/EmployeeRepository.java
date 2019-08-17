package com.tc.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.tc.springboot.beans.EmployeeInfoBean;

public interface EmployeeRepository extends CrudRepository<EmployeeInfoBean, Integer>{

}
