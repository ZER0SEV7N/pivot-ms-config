package com.pe.pivot.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Main entry point for the Centrilized Configuration Server (ms-config).
 * Provides externalized configuration properties for all banking microservices.
 */
@Slf4j
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    /**
     * Starts the Spring Cloud Config Server application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args){
        SpringApplication.run(ConfigServerApplication.class, args);
        log.info("Pivor Config Server (ms-config) started succesfully on port 8888");
    }
}
