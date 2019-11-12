package ar.com.ciu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ciu.dto.MarkDTO;
import ar.com.ciu.dto.MarksBySCDTO;
import ar.com.ciu.dto.ScidDTO;
import ar.com.ciu.model.Mark;
import ar.com.ciu.model.StudentCourse;
import ar.com.ciu.repository.MarkRepository;
import ar.com.ciu.repository.StudentCourseRepository;

@Service
public class MarkServiceImpl implements MarkService {


	// ATRIBUTOS
	@Autowired
	private MarkRepository markRepository;

	@Autowired
	private StudentCourseRepository scRepository;

	@Override
	@Transactional(rollbackFor =  Exception.class)
	public Mark create(Mark mark) {
		StudentCourse st = this.scRepository.findById(mark.getStudentCourse().getId()).orElse(null);
		Mark mark1 = new Mark(mark.getCalification(), mark.getDescription(), mark.getDate(), st);
		markRepository.save(mark1);
		return mark1;
	}

	@Override
	@Transactional(rollbackFor =  Exception.class)
	public MarkDTO create(MarkDTO markDTO) {
		StudentCourse st = this.scRepository.findById(markDTO.getIdStudentCourse()).orElse(null);
		Mark mark = new Mark(markDTO.getCalification(), markDTO.getDescription(), markDTO.getDate(), st);
		this.markRepository.save(mark);
		return new MarkDTO(mark);
	}

	@Override
	public MarkDTO findById(Long idMark) {
		Mark mark = this.markRepository.findById(idMark).orElse(null);
		MarkDTO markDto = null;
		if (mark != null) {
			markDto = new MarkDTO(mark);
		}
		return markDto;
	}

	@Override
	public List<MarkDTO> findAll() {
		List<Mark> marks = (List<Mark>) this.markRepository.findAll();
		List<MarkDTO> marksDTO = new ArrayList<MarkDTO>();
		marks.stream().forEach(mark -> marksDTO.add(new MarkDTO(mark)));
		return marksDTO;
	}

	@Override
	@Transactional(rollbackFor =  Exception.class)
	public MarkDTO update(MarkDTO markDTO) {
		Mark mark = this.markRepository.findById(markDTO.getId()).get();
		mark.setCalification(markDTO.getCalification());
		mark.setDate(markDTO.getDate());
		mark.setDescription(markDTO.getDescription());
		StudentCourse st = this.scRepository.findById(markDTO.getIdStudentCourse()).orElse(null);
		mark.setStudentCourse(st);
		mark = this.markRepository.save(mark);
		return markDTO;
	}

	@Override
	public void delete(Long idMark) {
		this.markRepository.deleteById(idMark);

	}
	
	@Override
	@Transactional(rollbackFor =  Exception.class)
	public MarksBySCDTO marksBySC(ScidDTO scidDTO) {
		StudentCourse sc = this.scRepository.findByIdCourseAndStudent(scidDTO.getIdStudent(), scidDTO.getIdCourse());
		List<Mark> listMarks = this.markRepository.findByIdSC(sc.getId());
		MarksBySCDTO marksbyDTO = new MarksBySCDTO(sc, listMarks);
		return marksbyDTO;
	}
	
	@Override
	@Transactional(rollbackFor =  Exception.class)
	public MarkDTO addMark(NewMarkDTO newMarkDTO) {
		Mark mark = this.markRepository.findById(markDTO.getId()).get();
		mark.setCalification(markDTO.getCalification());
		mark.setDate(markDTO.getDate());
		mark.setDescription(markDTO.getDescription());
		StudentCourse st = this.scRepository.findById(markDTO.getIdStudentCourse()).orElse(null);
		mark.setStudentCourse(st);
		mark = this.markRepository.save(mark);
		return markDTO;
	}
}