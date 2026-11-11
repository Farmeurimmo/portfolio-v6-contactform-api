package fr.farmeurimmo.portfoliov6contactapi.config;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    private static final String PROD_ORIGIN = "https://farmeurimmo.fr";
    private static final String DEV_ORIGIN = "http://localhost:[*]";

    @Value("${cors.dev:false}")
    private boolean isDevCorsEnabled;

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        var origins = new ArrayList<>(List.of(PROD_ORIGIN));
        if (isDevCorsEnabled) {
            origins.add(DEV_ORIGIN);
        }

        registry.addMapping("/**")
                .allowedOriginPatterns(origins.toArray(String[]::new))
                .allowedMethods(CorsConfiguration.ALL)
                .allowedHeaders(CorsConfiguration.ALL)
                .allowCredentials(true);
    }
}