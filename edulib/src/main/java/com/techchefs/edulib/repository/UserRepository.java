package com.techchefs.edulib.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techchefs.edulib.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

//	@Query("select e from EmployeeOtherInfoBean e where e.infoBean=:id")
//	Book findByEmpId(@Param("id") EmployeeInfoBean bean);
//	
////	@Query("select e from EmployeeInfoBean e where str(e.id) like :id")
////	List<EmployeeInfoBean> searchByEmpId(@Param("id") String id);
//	
//	@Query("select e from EmployeeInfoBean e where str(e.id) like :id%")
//	List<EmployeeInfoBean> searchByEmpId(@Param("id") int id);
	
}
