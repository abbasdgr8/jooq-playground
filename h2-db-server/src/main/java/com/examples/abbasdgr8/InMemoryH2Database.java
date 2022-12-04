package com.examples.abbasdgr8;


import java.sql.SQLException;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.examples.abbasdgr8.services.CountryService;


/**
 * @author Abbas Attarwala <abbas@muon-c.com>
 */
@SpringBootApplication
public class InMemoryH2Database {

    private static final Logger LOG = Logger.getLogger(InMemoryH2Database.class.getName());
    
    @Autowired
    private CountryService countryService;

    
    public static void main(String[] args) {
        SpringApplication.run(InMemoryH2Database.class, args);
    }
    
    @PostConstruct
    private void initDb() {
        LOG.info("****** Creating table: COUNTRIES, and initializing DB with seed data");
        countryService.saveCountry(1, "USA");
        countryService.saveCountry(2, "France");
        countryService.saveCountry(3, "Brazil");
        countryService.saveCountry(4, "Italy");
        countryService.saveCountry(5, "Canada");

        LOG.info("****** Fetching from table: COUNTRIES ******");
        countryService.list().forEach(country -> { LOG.info(country.toString()); });
    }
    
    @Bean(initMethod="start", destroyMethod="stop")
    public Server inMemoryH2DatabaseServer() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
    }

}
