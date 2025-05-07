package com.upm.resumenes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Rutas como /profile, /search, /algo
        registry.addViewController("/{spring:[\\w\\-]+}")
                .setViewName("forward:/index.html");

        // Rutas anidadas como /profile/editar, /search/resultados
        registry.addViewController("/**/{spring:[\\w\\-]+}")
                .setViewName("forward:/index.html");

        // Catch-all para SPA que no coincidan con estáticos
        registry.addViewController("/{spring:[\\w\\-]+}/**{spring:?!(\\.js|\\.css)$}")
                .setViewName("forward:/index.html");
    }
}
