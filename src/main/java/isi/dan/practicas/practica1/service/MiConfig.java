package isi.dan.practicas.practica1.service;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.sql.init.SqlDataSourceScriptDatabaseInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import isi.dan.practicas.practica1.dao.AlumnoDao;
import isi.dan.practicas.practica1.dao.PlainJdbcAlumnoDao;

@Configuration
public class MiConfig {
    
    @Bean
    public MemoryDB miBeanFactory() {
        return new MemoryDB();
    }

    @Bean
    public AlumnoDao alumnoDao() {
        return new PlainJdbcAlumnoDao(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/practica1");
        ds.setUsername("root");
        ds.setPassword("");
        return ds;
    }
}
