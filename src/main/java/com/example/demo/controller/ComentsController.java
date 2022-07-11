package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ComentsDTO;
import com.example.demo.services.ComentsService;



@RestController
@RequestMapping("/api/")
public class ComentsController {
	

	@Autowired
	private ComentsService comentsService;
	
	@GetMapping("/publications/{publicationID}/coments")
	public List<ComentsDTO> GetComentsByPublicationId(@PathVariable(value="publicationID") long publicationID){
		return comentsService.getComenstByPublicationID(publicationID);
	}
	@PostMapping("/publications/{publicationID}/coments")
	public ResponseEntity <ComentsDTO> CreateComent(@PathVariable(value="publicationID") long publicationID ,@RequestBody ComentsDTO comentsDTO){
		return new  ResponseEntity<>(comentsService.CreateComents(publicationID,comentsDTO ), HttpStatus.CREATED);
	
}
	}
