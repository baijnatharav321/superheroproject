package com.mindtree.superheroproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.superheroproject.entity.Superhero;

@Repository
public interface Superherorepository extends JpaRepository<Superhero,Integer> {

}