package com.catdev.storeMgr;

import com.catdev.storeMgr.model.Product;
import com.catdev.storeMgr.model.Role;
import com.catdev.storeMgr.model.Store;
import com.catdev.storeMgr.repository.ProductRepository;
import com.catdev.storeMgr.repository.StoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DatabaseLoader {

    private static final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);

    @Bean
    CommandLineRunner initDatabase(StoreRepository storeRepository, ProductRepository productRepository) {

        return args -> {
            //TODO: manually insert roles in the database
//            INSERT INTO roles(name) VALUES('ROLE_USER');
//            INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
//            INSERT INTO roles(name) VALUES('ROLE_ADMIN');

//            Store s1 = new Store("Sweet Baker", "Your favorite sweet stop!", "Portland, Oregon", "Mr. Baker", "111-222-3434");
//            storeRepository.save(s1);
//            log.info("Preloading " + productRepository.save(new Product(s1, "Chocolate Mousse", "Rich chocolatey goodness in a cup.", "Cakes", new BigDecimal("5.25"))));
//            log.info("Preloading " + productRepository.save(new Product(s1, "Red Velvet Round Cake", "Red velvet with cream cheese frosting.", "Cakes", new BigDecimal("8.75"))));
//
//            Store s2 = new Store("Flower Power", "Blooming just for you.", "Gresham, Oregon", "Lily Florence", "555-111-7777");
//            storeRepository.save(s2);
//            log.info("Preloading " + productRepository.save(new Product(s2, "Dahlia", "Multi-colored dahlias", "Flowers", new BigDecimal("4.25"))));
//            log.info("Preloading " + productRepository.save(new Product(s2, "Tulips", "Holland tulips.", "Flowers", new BigDecimal("3.50"))));
        };
    }
}
