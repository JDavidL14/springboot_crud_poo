package com.codigo.pooweb.config;



import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class databaseConfig {
    @Bean
    @ConfigurationProperties(prefix="datasource.my-connection")
    public DataSource crudDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate cruJdbcTemplate(DataSource crudDataSource){
        var jdbcTemplate = new JdbcTemplate(crudDataSource);
        return jdbcTemplate;
    }

    @Bean
    public NamedParameterJdbcTemplate cruNamedParameterJdbcTemplate(JdbcTemplate cruJdbcTemplate){
        return new NamedParameterJdbcTemplate(cruJdbcTemplate);
    }
}
