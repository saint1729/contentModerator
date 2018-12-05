package com.target.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.target.rest.model.Content;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

}