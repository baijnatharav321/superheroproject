package com.mindtree.superheroproject.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Superhero {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int superheroId;
	private String superheroName;
	@ManyToOne(cascade = CascadeType.ALL)
	private Comic comic;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="superhero")
	private Set<Power> power;
	public Superhero() {
		
	}
	
	public Superhero(int superheroId, String superheroName) {
		super();
		this.superheroId = superheroId;
		this.superheroName = superheroName;
	}

	public Superhero(int superheroId, String superheroName, Comic comic, Set<Power> power) {
		super();
		this.superheroId = superheroId;
		this.superheroName = superheroName;
		this.comic = comic;
		this.power = power;
	}
	public int getSuperheroId() {
		return superheroId;
	}
	public void setSuperheroId(int superheroId) {
		this.superheroId = superheroId;
	}
	public String getSuperheroName() {
		return superheroName;
	}
	public void setSuperheroName(String superheroName) {
		this.superheroName = superheroName;
	}
	public Comic getComic() {
		return comic;
	}
	public void setComic(Comic comic) {
		this.comic = comic;
	}
	public Set<Power> getPower() {
		return power;
	}
	public void setPower(Set<Power> power) {
		this.power = power;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comic == null) ? 0 : comic.hashCode());
		result = prime * result + ((power == null) ? 0 : power.hashCode());
		result = prime * result + superheroId;
		result = prime * result + ((superheroName == null) ? 0 : superheroName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Superhero other = (Superhero) obj;
		if (comic == null) {
			if (other.comic != null)
				return false;
		} else if (!comic.equals(other.comic))
			return false;
		if (power == null) {
			if (other.power != null)
				return false;
		} else if (!power.equals(other.power))
			return false;
		if (superheroId != other.superheroId)
			return false;
		if (superheroName == null) {
			if (other.superheroName != null)
				return false;
		} else if (!superheroName.equals(other.superheroName))
			return false;
		return true;
	}

}
