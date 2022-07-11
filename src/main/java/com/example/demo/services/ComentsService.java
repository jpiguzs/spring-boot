package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.ComentsDTO;

public interface ComentsService {

	public ComentsDTO CreateComents(Long publication_id, ComentsDTO comentsDto);
	
	public List<ComentsDTO> getComenstByPublicationID(Long publicationID);
}
