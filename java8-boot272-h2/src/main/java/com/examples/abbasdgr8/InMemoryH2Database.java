package com.examples.abbasdgr8;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.annotation.PostConstruct;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
public class InMemoryH2Database {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    
    public static void main(String[] args) {
        SpringApplication.run(InMemoryH2Database.class, args);
    }
    
    @PostConstruct
    private void initDb() {
        System.out.println(String.format("****** Creating table: %s, and initializing DB with seed data ******", "COUNTRIES"));

        String sqlStatements[] = {
            "DROP TABLE IF EXISTS COUNTRIES;",
            "CREATE TABLE COUNTRIES (id INT AUTO_INCREMENT PRIMARY KEY, country_name VARCHAR(250) NOT NULL)",
            "INSERT INTO countries (id, country_name) VALUES (1, 'USA')",
            "INSERT INTO countries (id, country_name) VALUES (2, 'France')",
            "INSERT INTO countries (id, country_name) VALUES (3, 'Brazil')",
            "INSERT INTO countries (id, country_name) VALUES (4, 'Italy')",
            "INSERT INTO countries (id, country_name) VALUES (5, 'Canada')"
        };

        Arrays.asList(sqlStatements).stream().forEach(sql -> {
            System.out.println(sql);
            jdbcTemplate.execute(sql);
        });

        System.out.println(String.format("****** Fetching from table: %s ******", "COUNTRIES"));
        jdbcTemplate.query("SELECT id, country_name FROM COUNTRIES", (ResultSet rs, int i) -> {
            System.out.println(String.format("id:%s,country_name:%s",
                    rs.getString("id"),
                    rs.getString("country_name")));
            return null;
        });
    }
    
    @Bean(initMethod="start", destroyMethod="stop")
    public Server inMemoryH2DatabaseServer() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
    }

}
