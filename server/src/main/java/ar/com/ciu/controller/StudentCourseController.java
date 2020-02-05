package ar.com.ciu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ciu.dto.ScidDTO;
import ar.com.ciu.dto.StudentCourseDTO;
import ar.com.ciu.service.StudentCourseService;

@RestController
@RequestMapping("/studentCourse")
@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
public class StudentCourseController {
	@Autowired
	private StudentCourseService studentCourseService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<StudentCourseDTO> create(@RequestBody StudentCourseDTO studentCourseDTO) {
		studentCourseDTO = this.studentCourseService.create(studentCourseDTO);
		return new ResponseEntity<StudentCourseDTO>(studentCourseDTO, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentCourseDTO> findById(@PathVariable("id") long id) throws NotFoundException {
		StudentCourseDTO studentCourseDTO = this.studentCourseService.findById(id);
		if (studentCourseDTO == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<StudentCourseDTO>(studentCourseDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<StudentCourseDTO>> findAll() throws NotFoundException {
		List<StudentCourseDTO> studentCoursesDTO = this.studentCourseService.findAll();
		if (studentCoursesDTO == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<List<StudentCourseDTO>>(studentCoursesDTO, HttpStatus.OK);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Void> exceptionHandler(Exception excep) {
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<StudentCourseDTO> update(@RequestBody StudentCourseDTO studentCourseDTO)
			throws NotFoundException {
		studentCourseDTO = this.studentCourseService.update(studentCourseDTO);
		return new ResponseEntity<StudentCourseDTO>(studentCourseDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") long id) throws NotFoundException {
		this.studentCourseService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/deleteById", method = RequestMethod.PUT)
	public ResponseEntity<ScidDTO> deleteById(@RequestBody ScidDTO scidDTO) throws NotFoundException {
		//ScidDTO sciddto = new ScidDTO(idCourse,idStudent);
		this.studentCourseService.deleteById(scidDTO);
		return new ResponseEntity<ScidDTO>(scidDTO, HttpStatus.OK);
	}

}
