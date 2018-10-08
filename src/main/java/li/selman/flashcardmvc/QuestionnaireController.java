package li.selman.flashcardmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

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
        return "list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable String id, Model model) {
        Optional<Questionnaire> dbResponse = repository.findById(id);

        if (dbResponse.isPresent()) {
            Questionnaire questionnaire = dbResponse.get();
            model.addAttribute("questionnaire", questionnaire);
        }

        return "show";
    }

    @GetMapping("/create")
    public ModelAndView createView() {
        return new ModelAndView("create", "questionnaire", new QuestionnaireDto());
    }

    @PostMapping
    public RedirectView create(@ModelAttribute QuestionnaireDto questionnaireIn) {
        Questionnaire savedQuestionnaire = repository.save(questionnaireIn.toModel());

        RedirectView rv = new RedirectView("/questionnaires/{id}", true);
        rv.addStaticAttribute("id", savedQuestionnaire.id);

        return rv;
    }
}
