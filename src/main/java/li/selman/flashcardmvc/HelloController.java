package li.selman.flashcardmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Hasan Kara
 */
@Controller
@RequestMapping(value = "/hello", produces = "text/html")
public class HelloController {

    private final QuestionnaireRepository repository;

    public HelloController(QuestionnaireRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ResponseBody
    public String hello(@RequestParam String name) {
        long count = repository.count();

        StringBuilder builder = new StringBuilder();
        builder.append("<p>").append("Hello ").append(name).append("\n").append("</p>");
        builder.append("<p>").append("You have ").append(count).append(" Questions in your repo").append("</p>");

        return builder.toString();
    }

}
