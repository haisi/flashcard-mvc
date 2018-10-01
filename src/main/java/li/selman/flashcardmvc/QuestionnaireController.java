package li.selman.flashcardmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

/**
 * @author Hasan Kara
 */
@Controller
@RequestMapping("/questionnaires")
public class QuestionnaireController {

    private final QuestionnaireRepository repository;

    public QuestionnaireController(QuestionnaireRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public void findAll(HttpServletResponse response, HttpServletRequest request) throws IOException {
        List<Questionnaire> questionnaires = repository.findAll();
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><title>Example</title></head><body>");
        writer.append("<h3>Fragebögen</h3>");
        for (Questionnaire questionnaire : questionnaires) {
            String url = request.getContextPath() + request.getServletPath();
            url = url + "/" + questionnaire.id;
            writer.append("<p><a href='").append(response.encodeURL(url)).append("'>").append(questionnaire.getTitle()).append("</a></p>");
        }
        writer.append("</body></html>");

    }

    @GetMapping("/{id}")
    public void findById(@PathVariable String id, HttpServletResponse response, HttpServletRequest request) throws IOException {
        Optional<Questionnaire> dbResponse = repository.findById(id);
        PrintWriter writer = response.getWriter();
        writer.append("<html><head><title>Example</title></head><body>");
        writer.append("<h3>Questionnaire</h3>");

        if (dbResponse.isPresent()) {
            Questionnaire questionnaire = dbResponse.get();
            writer.append("<strong>").append(questionnaire.getTitle()).append("</strong></br>");
            writer.append("<span>").append(questionnaire.getDescription()).append("</span></p>");
        } else {
            writer.append("no questionnaire found");
        }

        writer.append("</body></html>");
    }
}
