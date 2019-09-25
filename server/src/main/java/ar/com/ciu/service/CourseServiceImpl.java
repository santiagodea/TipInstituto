package ar.com.ciu.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.ciu.dto.CourseDTO;
import ar.com.ciu.model.Course;
import ar.com.ciu.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	// ATRIBUTOS
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course create(Course course) {
		courseRepository.save(course);
		return course;
	}

	@Override
	public CourseDTO create(CourseDTO courseDTO) {
		Course course = new Course(courseDTO.getName(), courseDTO.getLevel(), courseDTO.getShift(),
				courseDTO.getTeacher(), courseDTO.getHour());
		this.courseRepository.save(course);
		return new CourseDTO(course);
	}

	@Override
	public CourseDTO findById(Long idCourse) {
		Course course = this.courseRepository.findById(idCourse).orElse(null);
		CourseDTO courseDto = null;
		if (course != null) {
			courseDto = new CourseDTO(course);
		}
		return courseDto;
	}

	@Override
	public List<CourseDTO> findAll() {
		List<Course> courses = (List<Course>) this.courseRepository.findAll();
		List<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();
		courses.stream().forEach(cou -> coursesDTO.add(new CourseDTO(cou)));
		return coursesDTO;
	}

	@Override
	public CourseDTO update(CourseDTO courseDTO) {
		Course course = this.courseRepository.findById(courseDTO.getId()).get();
		course.setHour(courseDTO.getHour());
		course.setLevel(courseDTO.getLevel());
		course.setName(courseDTO.getName());
		course.setShift(courseDTO.getShift());
		course.setTeacher(courseDTO.getTeacher());
		course = this.courseRepository.save(course);
		return courseDTO;
	}

	@Override
	public void delete(Long idCourse) {
		this.courseRepository.deleteById(idCourse);

	}
}