package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "publications", uniqueConstraints = { @UniqueConstraint(columnNames = { "title" }) })

public class publications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "content", nullable = false)
	private String content;
	
	@JsonBackReference
	@OneToMany(mappedBy="publication", cascade= CascadeType.ALL,orphanRemoval=true)
	private Set<Coments> coments = new HashSet<>();
	public Long getId() {
		return id;
	}

	public publications() {
		super();
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

	public publications(Long id, String title, String description, String content) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
	}
}
