package com.techchefs.edulib.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techchefs.edulib.dto.Book;
import com.techchefs.edulib.dto.BookAllotment;
import com.techchefs.edulib.dto.BookAllotmentResponse;
import com.techchefs.edulib.dto.BookResponse;
import com.techchefs.edulib.repository.BookAllotmentRepository;
import com.techchefs.edulib.repository.BookRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:3000"},allowCredentials = "true")
public class UserController {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookAllotmentRepository bookAllotmentRepository;

	@PostMapping(path = "/requestBook", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BookAllotmentResponse requestBook(@RequestBody BookAllotment bookAllotment) {

		BookAllotmentResponse response = new BookAllotmentResponse();
		bookAllotment.setReturnStatus(0);
		bookAllotment.setIssueDate(new Date());
		bookAllotmentRepository.save(bookAllotment);
		response.setStatusCode(201);
		response.setMessage("Successfull");
		response.setDescription("Book Allotment requested");
		response.setBookAllotmentBeans(Arrays.asList(bookAllotment));
		return response;
	}

	@GetMapping(path = "/getBook", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookResponse getBook(int id) {
		BookResponse response = new BookResponse();
		if (!bookRepository.existsById(id)) {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Book data not found");
			return response;
		}
		Book bean = bookRepository.findById(id).get();
		long available = bean.getCount() - bookAllotmentRepository.getIssuedCopies(bean, 1);
		response.setStatusCode(201);
		response.setMessage("Successfull");
		response.setDescription("Book data found successfully");
		response.setAvailable(available);
		response.setBeans(Arrays.asList(bean));
		return response;
	}

	@GetMapping(path = "/searchBook", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookResponse searchBook(String bookName) {
		List<Book> beans = bookRepository.searchByBookName(bookName);
		BookResponse response = new BookResponse();
		if (beans != null) {
			response.setStatusCode(201);
			response.setMessage("Successfull");
			response.setDescription("Book data found successfully");
			response.setBeans(beans);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Book data not found");
		}
		return response;
	}
	@GetMapping(path = "/getAllBooks", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookResponse getAllBooks() {
		List<Book> beans = bookRepository.findAll();
		BookResponse response = new BookResponse();
		if (beans != null) {
			response.setStatusCode(201);
			response.setMessage("Successfull");
			response.setDescription("Book data found successfully");
			response.setBeans(beans);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Book data not found");
		}
		return response;
	}


	

}
