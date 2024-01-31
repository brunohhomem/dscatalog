package com.devsuperior.dscatalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // Classe de configuração do projeto
public class AppConfig {

    @Bean //Componente do Spring, uma anotação de métodos
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
