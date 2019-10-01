package ar.com.ciu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ciu.dto.StudentDTO;
import ar.com.ciu.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO studentDTO) {
		studentDTO = this.studentService.create(studentDTO);
		return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentDTO> findById(@PathVariable("id") long id) throws NotFoundException {
		StudentDTO studentDTO = this.studentService.findById(id);
		if (studentDTO == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> findAll() throws NotFoundException {
		List<StudentDTO> studentsDTO = this.studentService.findAll();
		if (studentsDTO == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<List<StudentDTO>>(studentsDTO, HttpStatus.OK);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Void> exceptionHandler(Exception excep) {
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<StudentDTO> update(@RequestBody StudentDTO studentDTO) throws NotFoundException {
		studentDTO = this.studentService.update(studentDTO);
		return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") long id) throws NotFoundException {
		this.studentService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

}
