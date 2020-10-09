package com.mindtree.superheroproject.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Comic {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int comicId;
	private String comicName;
	private String comicUniverse;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="comic")
	private Set<Superhero> superhero;
	public Comic() {
		
	}
	
	public Comic(int comicId, String comicName, String comicUniverse) {
		super();
		this.comicId = comicId;
		this.comicName = comicName;
		this.comicUniverse = comicUniverse;
	}

	public Comic(int comicId, String comicName, String comicUniverse, Set<Superhero> superhero) {
		super();
		this.comicId = comicId;
		this.comicName = comicName;
		this.comicUniverse = comicUniverse;
		this.superhero = superhero;
	}
	public int getComicId() {
		return comicId;
	}
	public void setComicId(int comicId) {
		this.comicId = comicId;
	}
	public String getComicName() {
		return comicName;
	}
	public void setComicName(String comicName) {
		this.comicName = comicName;
	}
	public String getComicUniverse() {
		return comicUniverse;
	}
	public void setComicUniverse(String comicUniverse) {
		this.comicUniverse = comicUniverse;
	}
	public Set<Superhero> getSuperhero() {
		return superhero;
	}
	public void setSuperhero(Set<Superhero> superhero) {
		this.superhero = superhero;
	}

}