package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Coments;



public interface ComentsRepository extends JpaRepository<Coments, Long>  {
	
	public List<Coments> findByPublicationId(Long publicationID );

}
