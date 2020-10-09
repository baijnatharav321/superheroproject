package com.mindtree.superheroproject.service.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.superheroproject.entity.Comic;
import com.mindtree.superheroproject.entity.Power;
import com.mindtree.superheroproject.entity.Superhero;
import com.mindtree.superheroproject.exception.ErrorConstant;
import com.mindtree.superheroproject.exception.ServiceException;
import com.mindtree.superheroproject.repository.Comicrepository;
import com.mindtree.superheroproject.repository.Powerrepository;
import com.mindtree.superheroproject.repository.Superherorepository;
import com.mindtree.superheroproject.service.Superheroservice;

@Service
public class Superheroserviceimpl implements Superheroservice {
	@Autowired
	private Powerrepository powerrepository;

	@Autowired
	private Comicrepository comicreop;
	@Autowired
	private Superherorepository superherorepository;

	@Override
	public Set<Superhero> getsuperheroes() {
		Set<Superhero> superheroes = new HashSet<Superhero>();
		List<Power> powers = new ArrayList<Power>();
		powers = powerrepository.findAll().stream()
				.filter(power -> power.getPowerName().equalsIgnoreCase("invisibility")
						|| power.getPowerName().equalsIgnoreCase("flying"))
				.collect(Collectors.toList());
		for (Power powerone : powers) {
			superheroes.add(powerone.getSuperhero());
		}
		return superheroes;
	}

	@Override
	public int totaldamagedone(int heroId) throws ServiceException {
		Superhero hero = superherorepository.findById(heroId).orElseThrow(()-> new ServiceException(ErrorConstant.NO_SUCH_SUPERHERO));
		int totaldamage = powerrepository.findAll().stream()
				.filter(power -> power.getSuperhero().getSuperheroId() == heroId)
				.reduce(0, (a, b) -> a + b.getPowerDamage(), Integer::sum);

		return totaldamage;
	}

	@Override
	public boolean insertData(Set<Comic> comic) {
		Set<Comic> comicss = new HashSet<Comic>();
		comic.forEach(comicone -> {
			comicone.getSuperhero().forEach(superHero -> {
				superHero.setComic(comicone);
				superHero.getPower().forEach(power -> {
					power.setSuperhero(superHero);

				});

			});
			Comic c = comicreop.save(comicone);
			comicss.add(c);
		});
		return true;
	}

	

}
