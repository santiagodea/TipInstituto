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

import ar.com.ciu.dto.CourseDTO;
import ar.com.ciu.service.CourseService;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class CourseController {
	@Autowired
	private CourseService courseService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CourseDTO> create(@RequestBody CourseDTO courseDTO) {
		courseDTO = this.courseService.create(courseDTO);
		return new ResponseEntity<CourseDTO>(courseDTO, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<CourseDTO> findById(@PathVariable("id") long id) throws NotFoundException {
		CourseDTO courseDTO = this.courseService.findById(id);
		if (courseDTO == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<CourseDTO>(courseDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<CourseDTO>> findAll() throws NotFoundException {
		List<CourseDTO> coursesDTO = this.courseService.findAll();
		if (coursesDTO == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<List<CourseDTO>>(coursesDTO, HttpStatus.OK);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Void> exceptionHandler(Exception excep) {
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<CourseDTO> update(@RequestBody CourseDTO courseDTO) throws NotFoundException {
		courseDTO = this.courseService.update(courseDTO);
		return new ResponseEntity<CourseDTO>(courseDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") long id) throws NotFoundException {
		this.courseService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
}
