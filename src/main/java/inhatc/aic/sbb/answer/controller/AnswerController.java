package inhatc.aic.sbb.answer.controller;

import inhatc.aic.sbb.answer.entity.Answer;
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

    @PostMapping("/create/{id}")
    public String create(@PathVariable("id") Long id, @RequestParam("content") String content) {
        log.info("Answer created for question ID: {}, Content: {}", id, content);

        return "redirect:/question/detail/" + id;
    }
}
