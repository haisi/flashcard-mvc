package li.selman.flashcardmvc;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Hasan Kara
 */
public interface QuestionnaireRepository extends MongoRepository<Questionnaire, String> {
}
