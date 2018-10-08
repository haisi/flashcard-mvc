package li.selman.flashcardmvc;

/**
 * @author Hasan Kara
 */
public class QuestionnaireDto {

    public String id;
    private String title;
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
