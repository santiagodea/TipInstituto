package ar.com.ciu.instituto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.ciu.InstitutoApplication;
import ar.com.ciu.model.Course;
import ar.com.ciu.service.CourseService;
import ar.com.ciu.service.MarkService;
import ar.com.ciu.service.PaymentService;
import ar.com.ciu.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InstitutoApplication.class)
//@TestPropertySource(locations="classpath:test.properties")
public class DemoApplicationTests {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private MarkService markService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private StudentService studentService;
	
	
	@Test
	public void testA() {
		Course cursoA = new Course("principiante", "uno", "maniana", "jose",10);
		Course cursoB = new Course("adulto", "uno", "maniana", "maria",11);
		Course cursoC = new Course("ninios", "dos", "tarde", "luis",15);
		Course cursoD = new Course("avanzado", "tres", "tarde", "ana",19);
		
		cursoA = this.courseService.create(cursoA);
		Assert.assertNotNull(cursoA.getId());
	}

	
}
