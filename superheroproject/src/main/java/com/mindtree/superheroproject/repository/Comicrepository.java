package com.mindtree.superheroproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.superheroproject.entity.Comic;

@Repository
public interface Comicrepository extends JpaRepository<Comic,Integer>{

}