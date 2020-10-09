package com.mindtree.superheroproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.superheroproject.entity.Power;

@Repository
public interface Powerrepository extends JpaRepository<Power,Integer> {

}
