package li.selman.flashcardmvc;

import javax.validation.constraints.Size;

/**
 * @author Hasan Kara
 */
public class QuestionnaireDto {

    public String id;
    @Size(min = 2, max = 30)
    private String title;

    @Size(min = 10, max = 50)
    private String description;

    public Questionnaire toModel() {
        return Questionnaire.of(title, description).withId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
