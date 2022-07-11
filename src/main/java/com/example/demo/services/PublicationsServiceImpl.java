package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PublicationDTO;
import com.example.demo.excetions.RecourceNotFoundException;
import com.example.demo.model.publications;
import com.example.demo.repositories.PublicationsRepository;

@Service
public class PublicationsServiceImpl implements PublicationsService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PublicationsRepository publicationsRepository;
	@Override
	public PublicationDTO createPublication(PublicationDTO publicationDTO) {
	publications publication = mapEntity(publicationDTO);
	
	publications newPublication = publicationsRepository.save(publication);
	
	PublicationDTO publicationResponse = mapDTO(newPublication);

		return publicationResponse;
	}
	@Override
	public List<PublicationDTO> GetPublications(int pageNumber, int pageSize) {
		Pageable pageble = PageRequest.of(pageNumber, pageSize);
		Page<publications> publications =publicationsRepository.findAll(pageble);
		List<publications> publicationsList = publications.getContent();
		return publicationsList.stream().map(publication -> mapDTO(publication)).collect(Collectors.toList());
	
	}
	
	private PublicationDTO mapDTO(publications publication) {
		PublicationDTO publicationDTO = modelMapper.map(publication, PublicationDTO.class);
		
		return publicationDTO;
		
	}
	private publications mapEntity(PublicationDTO publicationDTO) {
		publications publication = modelMapper.map(publicationDTO, publications.class);
		
		return publication;
	}
	
	@Override
	public PublicationDTO GetPblicationById(Long Id) {
		publications publication = publicationsRepository
				.findById(Id)
				.orElseThrow(()-> new RecourceNotFoundException("Publicaciones","id", Id));
		
	
		return mapDTO(publication );
	}
	@Override
	public PublicationDTO UpadetPublication(PublicationDTO publicationDTO, Long id) {
		// TODO Auto-generated method stub
		publications publication = publicationsRepository
				.findById(id)
				.orElseThrow(()-> new RecourceNotFoundException("Publicaciones","id", id));
		publication.setTitle(publicationDTO.getTitle());
		publication.setDescription(publicationDTO.getDescription());
		publication.setContent(publicationDTO.getContent());
		publications updatedPublication = publicationsRepository.save(publication);
		return mapDTO(updatedPublication);
	}

}
