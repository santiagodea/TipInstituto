package ar.com.ciu.service;

import java.util.List;

import ar.com.ciu.dto.MarkDTO;

public interface MarkService {
	public MarkDTO create(MarkDTO markDTO);

	public MarkDTO finById(Long idMark);

	public List<MarkDTO> findAll();

	public MarkDTO update(MarkDTO markDTO);

	public void delete(Long idMark);
}
