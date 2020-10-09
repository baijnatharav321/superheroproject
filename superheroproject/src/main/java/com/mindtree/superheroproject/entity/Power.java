package com.mindtree.superheroproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Power {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int powerId;
	private String powerName;
	private int powerDamage;
	@ManyToOne(cascade = CascadeType.ALL)
	private Superhero superhero;
	public Power() {
		
	}
	public Power(int powerId, String powerName, int powerDamage, Superhero superhero) {
		super();
		this.powerId = powerId;
		this.powerName = powerName;
		this.powerDamage = powerDamage;
		this.superhero = superhero;
	}
	public int getPowerId() {
		return powerId;
	}
	public void setPowerId(int powerId) {
		this.powerId = powerId;
	}
	public String getPowerName() {
		return powerName;
	}
	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}
	public int getPowerDamage() {
		return powerDamage;
	}
	public void setPowerDamage(int powerDamage) {
		this.powerDamage = powerDamage;
	}
	public Superhero getSuperhero() {
		return superhero;
	}
	public void setSuperhero(Superhero superhero) {
		this.superhero = superhero;
	}

	
	

	

}
