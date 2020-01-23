package ar.com.ciu.controller;

import java.time.LocalDate;
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

import ar.com.ciu.dto.MarkDTO;
import ar.com.ciu.dto.MarksBySCDTO;
import ar.com.ciu.dto.NewMarkDTO;
import ar.com.ciu.dto.ScidDTO;
import ar.com.ciu.model.Mark;
import ar.com.ciu.service.MarkService;

@RestController		
@RequestMapping("/mark")
@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
public class MarkController {
	@Autowired
	private MarkService markService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<MarkDTO> create(@RequestBody MarkDTO markDTO) {
		markDTO = this.markService.create(markDTO);
		return new ResponseEntity<MarkDTO>(markDTO, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<MarkDTO> findById(@PathVariable("id") long id) throws NotFoundException {
		MarkDTO markDTO = this.markService.findById(id);
		if (markDTO == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<MarkDTO>(markDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<MarkDTO>> findAll() throws NotFoundException {
		List<MarkDTO> marksDTO = this.markService.findAll();
		if (marksDTO == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<List<MarkDTO>>(marksDTO, HttpStatus.OK);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Void> exceptionHandler(Exception excep) {
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<MarkDTO> update(@RequestBody MarkDTO markDTO) throws NotFoundException {
		markDTO = this.markService.update(markDTO);
		return new ResponseEntity<MarkDTO>(markDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteById/{id}", method = RequestMethod.PUT)
	public ResponseEntity<MarkDTO> deleteById(@PathVariable("id") long id) throws NotFoundException {
		MarkDTO markDTO = this.markService.findById(id);
		markDTO.setDate_deleted( LocalDate.now());
		this.markService.deleteById(markDTO);
		return new ResponseEntity<MarkDTO>(markDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/marksBySC", method = RequestMethod.GET)
	public ResponseEntity<MarksBySCDTO> marksBySC(@Param ("idCourse") Long idCourse, @Param("idStudent") Long idStudent) throws NotFoundException {
		ScidDTO sciddto = new ScidDTO(idCourse,idStudent);
		MarksBySCDTO marksBySCDTO = this.markService.marksBySC(sciddto);
		if (marksBySCDTO == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<MarksBySCDTO>(marksBySCDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addMark", method = RequestMethod.POST)
	public ResponseEntity<Mark> addMark(@RequestBody NewMarkDTO newMarkDTO) throws NotFoundException {
		Mark mark = this.markService.addMark(newMarkDTO);
		return new ResponseEntity<Mark>(mark, HttpStatus.OK);
	}

}