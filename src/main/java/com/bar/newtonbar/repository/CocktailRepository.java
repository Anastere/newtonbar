package com.bar.newtonbar.repository;

import com.bar.newtonbar.entity.Cocktail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CocktailRepository extends CrudRepository<Cocktail, Long> {

    List<Cocktail> findByName(String name);



}
