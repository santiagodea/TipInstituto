package ar.com.ciu.instituto;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import ar.com.ciu.InstitutoApplication;
import ar.com.ciu.model.Course;
import ar.com.ciu.model.Mark;
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
		StudentCourse sc2 = new StudentCourse(2019, estudiante2, cursoA);
		StudentCourse sc3 = new StudentCourse(2019, estudiante3, cursoB);
		StudentCourse sc4 = new StudentCourse(2019, estudiante4, cursoB);
		StudentCourse sc5 = new StudentCourse(2019, estudiante5, cursoB);
		
		sc1 = this.studentCourseService.create(sc1);
		Assert.assertNotNull(sc1.getId());
//		sc2 = this.studentCourseService.create(sc2);
//		Assert.assertNotNull(sc2.getId());
//		sc3 = this.studentCourseService.create(sc3);
//		Assert.assertNotNull(sc3.getId());
//		sc4 = this.studentCourseService.create(sc4);
//		Assert.assertNotNull(sc4.getId());
//		sc5 = this.studentCourseService.create(sc5);
//		Assert.assertNotNull(sc5.getId());
	}
}
