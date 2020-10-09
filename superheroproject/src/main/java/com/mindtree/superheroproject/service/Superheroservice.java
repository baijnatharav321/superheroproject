package com.mindtree.superheroproject.service;

import java.util.Set;

import com.mindtree.superheroproject.entity.Comic;
import com.mindtree.superheroproject.entity.Superhero;
import com.mindtree.superheroproject.exception.ServiceException;

public interface Superheroservice {

	/**
	 * @param comic
	 * @return insert all data
	 */
	boolean insertData(Set<Comic> comic);

	/**
	 * @return list of superhero whose power is invisibility and flying
	 */
	Set<Superhero> getsuperheroes();

	/**
	 * @param heroId
	 * @return total damage done by particular hero
	 * @throws ServiceException 
	 */
	int totaldamagedone(int heroId) throws ServiceException;

}
