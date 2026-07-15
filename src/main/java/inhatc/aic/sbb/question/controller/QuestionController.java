package inhatc.aic.sbb.question.controller;

import inhatc.aic.sbb.question.entity.Question;
import inhatc.aic.sbb.question.repository.QuestionRepository;
import inhatc.aic.sbb.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
@Slf4j
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String questionList(Model model){

        List<Question> questionList = questionService.getQuestionList();
        log.info("questionList = {}", questionList);

        model.addAttribute("questionList", questionList);
        return "question/list";
    }

    @GetMapping("/detail/{id}")
    public String questionDetail(@PathVariable Long id,  Model model){
        log.info("id = {}", id);
        Question question = questionService.getQuestion(id);
        log.info("question = {}", question);
        model.addAttribute("question", question);
        return "question/detail";
    }
}
