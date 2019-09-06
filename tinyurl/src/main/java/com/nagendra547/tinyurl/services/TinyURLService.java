package com.nagendra547.tinyurl.services;


import com.nagendra547.tinyurl.domain.TinyURL;

/**
 * 
 * @author nagendra
 *
 */
public interface TinyURLService {
    Iterable<TinyURL> listAllTinyURLs();

    TinyURL getTinyURLById(Integer id);

    TinyURL saveTinyURL(TinyURL product);

    void deleteTinyURL(Integer id);
}
