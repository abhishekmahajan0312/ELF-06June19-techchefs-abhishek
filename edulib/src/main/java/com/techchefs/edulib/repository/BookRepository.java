package com.techchefs.edulib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.techchefs.edulib.dto.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

//	@Query("select e from EmployeeOtherInfoBean e where e.infoBean=:id")
//	Book findByEmpId(@Param("id") EmployeeInfoBean bean);
//	
////	@Query("select e from EmployeeInfoBean e where str(e.id) like :id")
////	List<EmployeeInfoBean> searchByEmpId(@Param("id") String id);
//	
	@Query("select e from Book e where bookName like %:name%")
	List<Book> searchByBookName(@Param("name") String name);
	
}
