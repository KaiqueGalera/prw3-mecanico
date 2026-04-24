package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class MecanicaApplication {
    public static void main(String[] args) {
        // Kaique Dias Galera e Matheus Gabriel Farias

        SpringApplication.run(MecanicaApplication.class, args);
    }
}
