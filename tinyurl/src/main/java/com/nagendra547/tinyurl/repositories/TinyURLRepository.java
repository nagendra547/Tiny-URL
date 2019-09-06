package com.nagendra547.tinyurl.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nagendra547.tinyurl.domain.TinyURL;

/**
 * 
 * @author nagendra
 *
 */
@RepositoryRestResource
public interface TinyURLRepository extends CrudRepository<TinyURL, Integer>{
}
