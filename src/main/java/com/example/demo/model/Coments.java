package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "publications")
public class Coments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="body", nullable=false)
	private String body;
	@Column(name="email", nullable=false)
	private String email;
	@Column(name="name", nullable=false)
	private String name;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="publication_id", nullable=false)
	private publications publication;

	public Coments() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public publications getPublication() {
		return publication;
	}

	public void setPublication(publications publication) {
		this.publication = publication;
	}
	
	
}
