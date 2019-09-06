package com.nagendra547.tinyurl.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagendra547.tinyurl.domain.TinyURL;
import com.nagendra547.tinyurl.repositories.TinyURLRepository;

/**
 * 
 * @author nagendra
 *
 */
@Service
public class TinyURLServiceImpl implements TinyURLService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private TinyURLRepository tinyURLRepository;

    @Autowired
    public void setProductRepository(TinyURLRepository tinyURLRepository) {
        this.tinyURLRepository = tinyURLRepository;
    }

	@Override
	public Iterable<TinyURL> listAllTinyURLs() {
		logger.debug("listAllTinyURLs called");
		return tinyURLRepository.findAll();
	}

	@Override
	public TinyURL getTinyURLById(Integer id) {
		logger.debug("getTinyURLById called");
		return tinyURLRepository.findById(id).orElse(null);
	}

	@Override
	public TinyURL saveTinyURL(TinyURL product) {
		logger.debug("saveTinyURL called");
		return tinyURLRepository.save(product);
	}

	@Override
	public void deleteTinyURL(Integer id) {
		logger.debug("deleteTinyURL called");
		tinyURLRepository.deleteById(id);
		
	}
}
