package ar.com.ciu.instituto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.ciu.InstitutoApplication;
import ar.com.ciu.dto.StudentCourseDTO;
import ar.com.ciu.model.Course;
import ar.com.ciu.model.Student;
import ar.com.ciu.model.StudentCourse;
import ar.com.ciu.service.CourseService;
import ar.com.ciu.service.MarkService;
import ar.com.ciu.service.PaymentService;
import ar.com.ciu.service.StudentCourseService;
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
	
	@Autowired
	private StudentCourseService studentCourseService;
	
	
	@Test
	public void testA() {
				
		Course cursoA = new Course("principiante", "uno", "maniana", "jose",10);
		Course cursoB = new Course("adulto", "uno", "maniana", "maria",11);
		Course cursoC = new Course("ninios", "dos", "tarde", "luis",15);
		Course cursoD = new Course("avanzado", "tres", "tarde", "ana",19);
		
		cursoA = this.courseService.create(cursoA);
		Assert.assertNotNull(cursoA.getId());
		cursoB = this.courseService.create(cursoB);
		Assert.assertNotNull(cursoB.getId());
		cursoC = this.courseService.create(cursoC);
		Assert.assertNotNull(cursoC.getId());
		cursoD = this.courseService.create(cursoD);
		Assert.assertNotNull(cursoD.getId());
		
		Student estudiante1 = new Student(123, "java", "juan", "juan@java.com", "2243", "2241");
		Student estudiante2 = new Student(1234, "phiton", "marta", "marta@phiton.com", "2243", "2241");
		Student estudiante3 = new Student(12345, "scala", "roberto", "roberto@scala.com", "2243", "2241");
		Student estudiante4 = new Student(123456, "ruby", "alberto", "alberto@ruby.com", "2243", "2241");
		Student estudiante5 = new Student(1234567, "php", "domingo", "domingo@php.com", "2243", "2241");
		
		estudiante1 = this.studentService.create(estudiante1);
		Assert.assertNotNull(estudiante1.getId());
		estudiante2 = this.studentService.create(estudiante2);
		Assert.assertNotNull(estudiante2.getId());
		estudiante3 = this.studentService.create(estudiante3);
		Assert.assertNotNull(estudiante3.getId());
		estudiante4 = this.studentService.create(estudiante4);
		Assert.assertNotNull(estudiante4.getId());
		estudiante5 = this.studentService.create(estudiante5);
		Assert.assertNotNull(estudiante5.getId());
		
		StudentCourse sc1 = new StudentCourse(2019, estudiante1, cursoA);
		StudentCourseDTO sc1DTO = new StudentCourseDTO(sc1);
		StudentCourse sc2 = new StudentCourse(2019, estudiante2, cursoA);
		StudentCourseDTO sc2DTO = new StudentCourseDTO(sc2);
		StudentCourse sc3 = new StudentCourse(2019, estudiante3, cursoB);
		StudentCourseDTO sc3DTO = new StudentCourseDTO(sc3);
		StudentCourse sc4 = new StudentCourse(2019, estudiante4, cursoB);
		StudentCourseDTO sc4DTO = new StudentCourseDTO(sc4);
		StudentCourse sc5 = new StudentCourse(2019, estudiante5, cursoB);
		StudentCourseDTO sc5DTO = new StudentCourseDTO(sc5);
		
		sc1DTO = this.studentCourseService.create(sc1DTO);
		Assert.assertNotNull(sc1DTO.getId());
		sc2DTO = this.studentCourseService.create(sc2DTO);
		Assert.assertNotNull(sc2DTO.getId());
		sc3DTO = this.studentCourseService.create(sc3DTO);
		Assert.assertNotNull(sc3DTO.getId());
		sc4DTO = this.studentCourseService.create(sc4DTO);
		Assert.assertNotNull(sc4DTO.getId());
		sc5DTO = this.studentCourseService.create(sc5DTO);
		Assert.assertNotNull(sc5DTO.getId());
	}
}
