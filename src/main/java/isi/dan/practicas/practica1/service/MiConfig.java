package isi.dan.practicas.practica1.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiConfig {
    
    @Bean
    public MemoryDB miBeanFactory() {
        return new MemoryDB();
    }
}
