package com.tc.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tc.springboot.beans.EmployeeInfoBean;
import com.tc.springboot.beans.EmployeeOtherInfoBean;

public interface EmployeeRepository extends CrudRepository<EmployeeInfoBean, Integer>{

	@Query("select e from EmployeeOtherInfoBean e where e.infoBean=:id")
	EmployeeOtherInfoBean findByEmpId(@Param("id") EmployeeInfoBean bean);
	
//	@Query("select e from EmployeeInfoBean e where str(e.id) like :id")
//	List<EmployeeInfoBean> searchByEmpId(@Param("id") String id);
	
	@Query("select e from EmployeeInfoBean e where str(e.id) like :id%")
	List<EmployeeInfoBean> searchByEmpId(@Param("id") int id);
	
}
