package ar.com.ciu.controller;

import java.time.LocalDate;
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

import ar.com.ciu.dto.PaymentByStudentDTO;
import ar.com.ciu.dto.PaymentDTO;
import ar.com.ciu.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PaymentDTO> create(@RequestBody PaymentDTO paymentDTO) {
		paymentDTO = this.paymentService.create(paymentDTO);
		return new ResponseEntity<PaymentDTO>(paymentDTO, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<PaymentDTO> findById(@PathVariable("id") long id) throws NotFoundException {
		PaymentDTO paymentDTO = this.paymentService.findById(id);
		if (paymentDTO == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<PaymentDTO>(paymentDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentDTO>> findAll() throws NotFoundException {
		List<PaymentDTO> paymentsDTO = this.paymentService.findAll();
		if (paymentsDTO == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<List<PaymentDTO>>(paymentsDTO, HttpStatus.OK);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Void> exceptionHandler(Exception excep) {
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<PaymentDTO> update(@RequestBody PaymentDTO paymentDTO) throws NotFoundException {
		paymentDTO = this.paymentService.update(paymentDTO);
		return new ResponseEntity<PaymentDTO>(paymentDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteById/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PaymentDTO> deleteById(@PathVariable("id") long id) throws NotFoundException {
		PaymentDTO paymentDTO = this.paymentService.findById(id);
		paymentDTO.setDate_deleted( LocalDate.now());
		this.paymentService.deleteById(paymentDTO);
		return new ResponseEntity<PaymentDTO>(paymentDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/paymentsByStudent/{id}", method = RequestMethod.GET)
	public ResponseEntity<PaymentByStudentDTO> paymentByStudent(@PathVariable("id") long id) throws NotFoundException {
		PaymentByStudentDTO paymentByStudentDTO = this.paymentService.paymentsByStudent(id);
		if (paymentByStudentDTO == null) {
			throw new NotFoundException();
		}
		return new ResponseEntity<PaymentByStudentDTO>(paymentByStudentDTO, HttpStatus.OK);
	}
	
}
