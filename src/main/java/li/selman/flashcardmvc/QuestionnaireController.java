package li.selman.flashcardmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
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
    public String findAll(Model model) {
        List<Questionnaire> questionnaires = repository.findAll();
        model.addAttribute("questionnaires", questionnaires);
        return "questionnaires/list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable String id, Model model) {
        Optional<Questionnaire> dbResponse = repository.findById(id);

        if (dbResponse.isPresent()) {
            Questionnaire questionnaire = dbResponse.get();
            model.addAttribute("questionnaire", questionnaire);
        }

        return "questionnaires/show";
    }

    @GetMapping(params = "form")
    public String createView(Model model) {
        model.addAttribute("questionnaire", new QuestionnaireDto());
        return "questionnaires/create";
    }

    @PostMapping
    public String create(QuestionnaireDto questionnaireIn) {
        Questionnaire savedQuestionnaire = repository.save(questionnaireIn.toModel());
        return String.format("redirect:/questionnaires/%s", savedQuestionnaire.id);
    }
}
