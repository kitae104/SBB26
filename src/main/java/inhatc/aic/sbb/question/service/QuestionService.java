package inhatc.aic.sbb.question.service;

import inhatc.aic.sbb.question.entity.Question;
import inhatc.aic.sbb.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;


    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }
}
