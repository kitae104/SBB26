package inhatc.aic.sbb.answer.service;

import inhatc.aic.sbb.answer.entity.Answer;
import inhatc.aic.sbb.answer.repository.AnswerRepository;
import inhatc.aic.sbb.question.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void createAnswer(Question question, String content) {
        Answer answer = Answer.builder()
                .question(question)
                .content(content)
                .build();
        answerRepository.save(answer);
    }
}
