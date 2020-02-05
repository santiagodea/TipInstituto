package ar.com.ciu.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ciu.dto.CourseWithStudentsDTO;
import ar.com.ciu.dto.ScidDTO;
import ar.com.ciu.dto.StudentCourseDTO;
import ar.com.ciu.model.Course;
import ar.com.ciu.model.Student;
import ar.com.ciu.model.StudentCourse;
import ar.com.ciu.repository.CourseRepository;
import ar.com.ciu.repository.StudentCourseRepository;
import ar.com.ciu.repository.StudentRepository;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	@Autowired
	private StudentCourseRepository studentCourseRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentCourseRepository scRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public StudentCourse create(StudentCourse studentCourse) {
		Student student = this.studentRepository.findById(studentCourse.getStudent().getId()).orElse(null);
		Course course = this.courseRepository.findById(studentCourse.getCourse().getId()).orElse(null);
		StudentCourse sc = new StudentCourse(studentCourse.getYear(), student, course);
		this.studentCourseRepository.save(sc);
		return sc;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public StudentCourseDTO create(StudentCourseDTO studentCourseDTO) {
		Student student = this.studentRepository.findById(studentCourseDTO.getIdStudent()).orElse(null);
		Course course = this.courseRepository.findById(studentCourseDTO.getIdCourse()).orElse(null);
		StudentCourse studentCourse = new StudentCourse(studentCourseDTO.getYear(), student, course);
		this.studentCourseRepository.save(studentCourse);
		return new StudentCourseDTO(studentCourse);
	}

	@Override
	public StudentCourseDTO findById(Long idStudentCourse) {
		StudentCourse studentCourse = this.studentCourseRepository.findById(idStudentCourse).orElse(null);
		StudentCourseDTO studentCourseDto = null;
		if (studentCourse != null) {
			studentCourseDto = new StudentCourseDTO(studentCourse);
		}
		return studentCourseDto;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public CourseWithStudentsDTO findByIdWithStudents(Long idCourse) {
		Course course = this.courseRepository.findById(idCourse).orElse(null);
		List<StudentCourse> listStudentCourse = this.studentCourseRepository.findByIdCourse(idCourse);

		// FILTRO POR FECHA DE BORRADO DISTINTO DE NULL Y LUEGO DEVUELVO LOS
		// ESTUDIANTES.
		List<Student> listStudent = listStudentCourse.stream().filter(m -> m.getDate_deleted() == null)
				.map(sc -> sc.getStudent()).collect(Collectors.toList());

		CourseWithStudentsDTO csDTO = new CourseWithStudentsDTO(course, listStudent);
		return csDTO;
	}

	@Override
	public List<StudentCourseDTO> findAll() {
		List<StudentCourse> studentCourses = (List<StudentCourse>) this.studentCourseRepository.findAll();
		List<StudentCourseDTO> studentCourseDTOs = new ArrayList<StudentCourseDTO>();
		studentCourses.stream().forEach(sc -> studentCourseDTOs.add(new StudentCourseDTO(sc)));// CORREGIR EL STUDENTdto
		return studentCourseDTOs;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public StudentCourseDTO update(StudentCourseDTO studentCourseDTO) {
		StudentCourse studentCourse = this.studentCourseRepository.findById(studentCourseDTO.getId()).get();
		Student student = this.studentRepository.findById(studentCourseDTO.getIdStudent()).orElse(null);
		Course course = this.courseRepository.findById(studentCourseDTO.getIdCourse()).orElse(null);
		studentCourse.setCourse(course);
		studentCourse.setStudent(student);
		studentCourse.setYear(studentCourseDTO.getYear());
		studentCourse = this.studentCourseRepository.save(studentCourse);
		return studentCourseDTO;
	}

	@Override
	public void delete(Long idStudentCourse) {
		this.studentCourseRepository.deleteById(idStudentCourse);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ScidDTO deleteById(ScidDTO scidDTO) {
		StudentCourse sc = this.scRepository.findByIdCourseAndStudent(scidDTO.getIdCourse(), scidDTO.getIdStudent());
		sc.setDate_deleted(LocalDate.now());
		sc = this.studentCourseRepository.save(sc);
		return scidDTO;
	}

}
