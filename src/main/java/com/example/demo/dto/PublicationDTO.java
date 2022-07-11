package com.example.demo.dto;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.demo.model.Coments;

public class PublicationDTO {

	private Long id;
	
	@NotEmpty
	@Size(min=2, message=" el titulo debe tener minimo 2 caractaeres")
	private String title;
	
	@NotEmpty
	@Size(min=10, message=" la descripcion debe tener minimo 10 caractaeres")
	private String description;
	
	@NotEmpty
	private String content;
	private Set<Coments> coments;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getContent() {
		return content;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

	public Set<Coments> getComents() {
		return coments;
	}

	public void setComents(Set<Coments> coments) {
		this.coments = coments;
	}

	public PublicationDTO() {
		super();
	}
}