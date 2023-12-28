package pro.sky.java.cource2.examinerservice.service;

import ch.qos.logback.core.joran.spi.ElementPath;
import org.springframework.stereotype.Service;
import pro.sky.java.cource2.examinerservice.exception.NotEnoughQuestionsException;
import pro.sky.java.cource2.examinerservice.model.Question;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
    private QuestionService javaService;
    private ElementPath allJavaQuestions;
    private ElementPath allMathQuestions;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        var allQuestions = questionService.getAll();
        if (amount > allJavaQuestions.size() + allMathQuestions.size()) {
            throw new NotEnoughQuestionsException();
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {

            result.add(javaService.getRandomQuestion());
        }
        return result;
    }
}
