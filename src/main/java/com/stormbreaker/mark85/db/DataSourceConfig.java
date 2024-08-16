package com.stormbreaker.mark85.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Configuration
public class DataSourceConfig {

    private final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    // get the database location, username and password from env vars

    @Value("${DB_LOCATION}")
    private String db_name;

    @Value("${DB_USERNAME}")
    private String db_user;

    @Value("${DB_PASSWORD}")
    private String db_password;

    // for the demonstration purpose we use the lightweight h2 database
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        // H2 Database URL
        String url = String.format("jdbc:h2:%s", db_name); // This points to the file-based H2 database

        // Configure the DataSource
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(db_user);
        dataSource.setPassword(db_password);
        try {
            dataSource.getConnection();
            logger.error("Successfully connected to database");
        } catch (SQLException e) {
            logger.error("Something went wrong while connecting to database: {}", e.getMessage());
            logger.error(Arrays.toString(e.getStackTrace()));
        }
        return dataSource;
    }
}
