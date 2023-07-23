package br.com.erudio;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Mapeia todas as APIs
            .allowedOrigins("*") // Permite todas as origens, você pode especificar origens específicas aqui
            .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
            .allowedHeaders("Content-Type", "Authorization") // Cabeçalhos permitidos
            .maxAge(3600); // Tempo em segundos para manter a configuração CORS em cache pelo navegador
    }
}
