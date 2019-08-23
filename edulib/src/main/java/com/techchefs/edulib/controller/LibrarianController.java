package com.techchefs.edulib.controller;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
import com.techchefs.edulib.repository.UserRepository;

@RestController
@RequestMapping("/librarian")
@CrossOrigin(origins = { "http://localhost:3000" }, allowCredentials = "true")
public class LibrarianController {
	@Autowired
	BookAllotmentRepository bookAllotmentRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BookRepository bookRepository;

	@GetMapping(path = "/getBookRequests", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookAllotmentResponse bookRequests() throws ParseException {

		BookAllotmentResponse response = new BookAllotmentResponse();
		response.setStatusCode(201);
		response.setMessage("Successfull");

		List<BookAllotment> beans = bookAllotmentRepository.findAllByStatus(0);
		if (beans.size() > 0) {
			response.setDescription("Book data found successfully");
			response.setBookAllotmentBeans(beans);
		} else {
			response.setDescription("Book data not found");
		}
		return response;
	}

	@GetMapping(path = "/deleteBook", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookResponse deleteBook(int id) throws ParseException {
		BookResponse response = new BookResponse();
		if(!bookRepository.existsById(id)) {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Book Not Found");
			return response;
		}
		Book bean = bookRepository.findById(id).get();
		bookRepository.deleteById(id);
		response.setStatusCode(201);
		response.setMessage("Successfull");
		response.setDescription("Book deleted successfully");
		response.setBeans(Arrays.asList(bean));
		return response;
	}

	@PostMapping(path = "/addBook", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BookResponse createUser(@RequestBody Book bean) {

		BookResponse response = new BookResponse();

		bookRepository.save(bean);
		response.setStatusCode(201);
		response.setMessage("Successfull");
		response.setDescription("Book inserted successfully");
		response.setBeans(Arrays.asList(bean));
		return response;
	}

	@PatchMapping(path = "/changeAllotmentStatus", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookAllotmentResponse changeAllotmentStatus(int bookAllotmentId, int action) {
		BookAllotmentResponse response = new BookAllotmentResponse();
		if (!bookAllotmentRepository.existsById(bookAllotmentId)) {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Book Allotment not Changed");
			return response;
		}
		BookAllotment bookAllotment = bookAllotmentRepository.findById(bookAllotmentId).get();
		bookAllotment.setReturnStatus(action);

		bookAllotmentRepository.save(bookAllotment);
		response.setStatusCode(201);
		response.setMessage("Successfull");
		response.setDescription("Book Allotment Status Changed");
		response.setBookAllotmentBeans(Arrays.asList(bookAllotment));
		return response;
	}

}
