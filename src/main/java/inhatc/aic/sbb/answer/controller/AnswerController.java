package inhatc.aic.sbb.answer.controller;

import inhatc.aic.sbb.answer.entity.Answer;
import inhatc.aic.sbb.answer.service.AnswerService;
import inhatc.aic.sbb.question.entity.Question;
import inhatc.aic.sbb.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
@Slf4j
public class AnswerController {

    private final QuestionService questionService;

    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String create(@PathVariable("id") Long id, @RequestParam("content") String content) {
        log.info("Answer created for question ID: {}, Content: {}", id, content);

        Question question = questionService.getQuestion(id);

        answerService.createAnswer(question, content);

        return "redirect:/question/detail/" + id;  // redirect 용도 확인.
    }
}
