package ar.com.ciu.service;

import java.util.List;

import ar.com.ciu.dto.MarkDTO;
import ar.com.ciu.dto.MarksBySCDTO;
import ar.com.ciu.dto.NewMarkDTO;
import ar.com.ciu.dto.ScidDTO;
import ar.com.ciu.model.Mark;

public interface MarkService {
	public MarkDTO create(MarkDTO markDTO);
	
	public Mark create(Mark mark);

	public MarkDTO findById(Long idMark);

	public List<MarkDTO> findAll();

	public MarkDTO update(MarkDTO markDTO);

	public MarksBySCDTO marksBySC(ScidDTO scidDTO);

	public Mark addMark(NewMarkDTO newMarkDTO);

	MarkDTO deleteById(MarkDTO markDTO);

	MarksBySCDTO marksByIdsSC(Long IdC, Long IdS);

	
}
