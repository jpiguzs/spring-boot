package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.PublicationDTO;
public interface PublicationsService {
	
	public PublicationDTO createPublication(PublicationDTO publicationDTO);
	
	public List<PublicationDTO> GetPublications();
	
}
