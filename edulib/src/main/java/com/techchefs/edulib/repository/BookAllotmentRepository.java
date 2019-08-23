package com.techchefs.edulib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techchefs.edulib.dto.Book;
import com.techchefs.edulib.dto.BookAllotment;

public interface BookAllotmentRepository extends JpaRepository<BookAllotment, Integer>{

	@Query("select e from BookAllotment e where e.returnStatus=:status")
	List<BookAllotment> findAllByStatus(@Param("status") int status);
//	
	@Query("select COUNT(b) from BookAllotment b WHERE b.bookId=:id AND b.returnStatus=:status")
	int getIssuedCopies(@Param("id") Book id,@Param("status")int status );
	
//	@Query("select e from Book e where bookName like %:name%")
//	List<Book> searchByBookName(@Param("name") String name);
	
}