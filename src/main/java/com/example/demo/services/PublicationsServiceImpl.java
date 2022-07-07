package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PublicationDTO;
import com.example.demo.model.publications;
import com.example.demo.repositories.PublicationsRepository;

@Service
public class PublicationsServiceImpl implements PublicationsService {
	@Autowired
	private PublicationsRepository publicationsRepository;
	@Override
	public PublicationDTO createPublication(PublicationDTO publicationDTO) {
	publications publication = new publications();
	publication.setTitle(publicationDTO.getTitle());
	publication.setDescription(publicationDTO.getDescription());
	publication.setContent(publicationDTO.getContent());
	
	publications newPublication = publicationsRepository.save(publication);
	
	PublicationDTO publicationResponse = new PublicationDTO();
	publicationResponse.setId(newPublication.getId());
	publicationResponse.setTitle(newPublication.getTitle());
	publicationResponse.setContent(newPublication.getContent());
	publicationResponse.setDescription(newPublication.getDescription());
		return publicationResponse;
	}
	@Override
	public List<PublicationDTO> GetPublications() {
		List<publications> publications = publicationsRepository.findAll();
		return null;
	}

}
