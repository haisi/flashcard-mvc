package li.selman.flashcardmvc;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;

public class Questionnaire {

    @Id
    public final String id;

    @Size(min = 2, max = 30)
    private String title;

    @Size(min = 10, max = 50)
    private String description;

    static Questionnaire of(String title, String description) {
        return new Questionnaire(null, title, description);
    }

    private Questionnaire(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    Questionnaire withId(String id) {
        return new Questionnaire(id, this.title, this.description);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
