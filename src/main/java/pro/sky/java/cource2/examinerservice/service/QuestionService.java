package pro.sky.java.cource2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.cource2.examinerservice.model.Question;

import java.util.List;
@Service
public interface QuestionService {
    void addQuestion(Question question);
    void removeQuestion(Question question);
    List<Question> getAllQuestions();
    Question getRandomQuestion();

    Object getAll();
}
