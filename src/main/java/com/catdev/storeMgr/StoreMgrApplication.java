package com.catdev.storeMgr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreMgrApplication {
	private static final Logger logger = LoggerFactory.getLogger(StoreMgrApplication.class);

	public static void main(String[] args) {
		logger.info("this is an info message");
		logger.warn("this is a warning massage");
		logger.error("this is an error message");
		SpringApplication.run(StoreMgrApplication.class, args);
	}
//TODO: lookup best practice, whether to return ResponseEntity also in delete
//TODO: @Valid for the ResponseBody parameter, do we need that?
//TODO: should api methods be public or just default?
//TODO: use Lombok? to minimize boiler plate code?
//only the READ were tested
//TODO next is test CRUD, add attributes to entities, then commit
}
