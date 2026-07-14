package inhatc.aic.sbb.question.controller;

import inhatc.aic.sbb.question.entity.Question;
import inhatc.aic.sbb.question.repository.QuestionRepository;
import inhatc.aic.sbb.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/question/list")
    public String questionList(Model model){

        List<Question> questionList = questionService.getQuestions();
        System.out.println("questionList = " + questionList);

        model.addAttribute("questionList", questionList);
        return "question/list";
    }
}
