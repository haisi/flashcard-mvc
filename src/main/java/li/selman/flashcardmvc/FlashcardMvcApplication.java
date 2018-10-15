package li.selman.flashcardmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlashcardMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlashcardMvcApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(QuestionnaireRepository repository) {
        return args -> {
            repository.deleteAll();

            repository.save(Questionnaire.of("Test 1", "Desc 1 abcdefgh"));
            repository.save(Questionnaire.of("Test 2", "Desc 2 abcdefgh"));
            repository.save(Questionnaire.of("Test 3", "Desc 3 abcdefgh"));

            repository.findAll().forEach(System.out::println);
        };
    }
}
