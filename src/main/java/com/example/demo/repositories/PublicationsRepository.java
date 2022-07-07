package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.publications;

public interface PublicationsRepository extends JpaRepository<publications, Long> {

}
