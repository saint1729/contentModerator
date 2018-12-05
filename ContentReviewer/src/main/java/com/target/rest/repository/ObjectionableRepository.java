package com.target.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.target.rest.model.Objectionable;

public interface ObjectionableRepository extends JpaRepository<Objectionable, Long> {

}
