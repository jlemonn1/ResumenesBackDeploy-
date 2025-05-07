package com.upm.resumenes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Esta ruta captura cualquier ruta no estática y la redirige al frontend
        registry.addViewController("/{path:^(?!api|swagger-ui|v3|index\\.html|static|assets).*$}")
                .setViewName("forward:/index.html");

        registry.addViewController("/**/{path:^(?!.*\\..*$).*$}")
                .setViewName("forward:/index.html");
    }
}
