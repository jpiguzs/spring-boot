package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PublicationDTO;
import com.example.demo.services.PublicationsService;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {
	@Autowired
	private PublicationsService publicationsService;
	
	@PostMapping
	public ResponseEntity <PublicationDTO> savePublication(@RequestBody PublicationDTO publicationDTO){
		return new ResponseEntity<>(publicationsService.createPublication(publicationDTO),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<PublicationDTO> GetPublications(){
		return publicationsService.GetPublications();
	}
	@GetMapping("/{id}")
	public ResponseEntity <PublicationDTO>  GetPublicationById(@PathVariable(name="id") long id){
		return ResponseEntity.ok(publicationsService.GetPblicationById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PublicationDTO> UpdatePublication(@RequestBody PublicationDTO publicationDTO,@PathVariable(name="id") long id ){
		PublicationDTO publication = publicationsService.UpadetPublication(publicationDTO, id);
		return new ResponseEntity<>(publication,HttpStatus.OK);
	}
	
}
