package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ComentsDTO;

import com.example.demo.excetions.RecourceNotFoundException;
import com.example.demo.model.Coments;
import com.example.demo.model.publications;
import com.example.demo.repositories.ComentsRepository;
import com.example.demo.repositories.PublicationsRepository;

@Service
public class ComentsServiceImpl implements ComentsService{

	@Autowired
	private ComentsRepository comentsRepository;
	@Autowired
	private PublicationsRepository publicationsRepository;
	@Override
	public ComentsDTO CreateComents(Long publication_id, ComentsDTO comentDTO) {
		Coments coment = mapEntity(comentDTO);
		publications publication = publicationsRepository
				.findById(publication_id)
				.orElseThrow(()-> new RecourceNotFoundException("Publicaciones","id", publication_id));
		coment.setPublication(publication);
		Coments newComent = comentsRepository.save(coment);
		return mapDTO(newComent);
	}
	
	private ComentsDTO mapDTO(Coments coment) {
		ComentsDTO ComentsDTO = new ComentsDTO();
		ComentsDTO.setId(coment.getId());
		ComentsDTO.setBody(coment.getBody());
		ComentsDTO.setEmail(coment.getEmail());
		ComentsDTO.setName(coment.getName());
			return ComentsDTO;
		
	}
	private Coments mapEntity(ComentsDTO ComentDTO) {
		Coments coment = new Coments();
		coment.setId(ComentDTO.getId());
		coment.setBody(ComentDTO.getBody());
		coment.setEmail(ComentDTO.getEmail());
		coment.setName(ComentDTO.getName());
			return coment;
	}

	@Override
	public List<ComentsDTO> getComenstByPublicationID(Long publicationID) {
		List<Coments> coments = comentsRepository.findByPublicationId(publicationID); 
		return coments.stream().map(coment -> mapDTO(coment)).collect(Collectors.toList());
	}

}
