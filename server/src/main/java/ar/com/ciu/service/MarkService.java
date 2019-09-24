package ar.com.ciu.service;

import java.util.List;

import ar.com.ciu.dto.MarkDTO;
import ar.com.ciu.model.Mark;

public interface MarkService {
	public MarkDTO create(MarkDTO markDTO);
	
	public Mark create(Mark mark);

	public MarkDTO findById(Long idMark);

	public List<MarkDTO> findAll();

	public MarkDTO update(MarkDTO markDTO);

	public void delete(Long idMark);

	
}
