package com.nagendra547.tinyurl.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.nagendra547.tinyurl.domain.TinyURL;
import com.nagendra547.tinyurl.repositories.TinyURLRepository;

/**
 * 
 * @author nagendra
 *
 */
@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private TinyURLRepository tinyURLRepository;


    private Logger log = LogManager.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setProductRepository(TinyURLRepository productRepository) {
        this.tinyURLRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
    }

    private void loadProducts() {
        TinyURL t1 = new TinyURL();
        t1.setLongURL("http://google.com");
        t1.setShortURL("abcd123");
        tinyURLRepository.save(t1);

        log.info("Saved TinyURL - id: " + t1.getId());

        TinyURL t2 = new TinyURL();
        t2.setLongURL("http://yahoo.com");
        t2.setShortURL("efgh123");
        tinyURLRepository.save(t2);

        log.info("Saved TinyURL - id: " + t2.getId());
    }


    }



