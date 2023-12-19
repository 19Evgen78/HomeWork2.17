package pro.sky.java.cource2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.cource2.examinerservice.model.Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        List<Question> questions = new ArrayList<>();
        Set<Question> uniqueQuestions = new HashSet<>();

        List<Question> allQuestions = questionService.getAllQuestions();
        if (amount > allQuestions.size()) {
            throw new IllegalArgumentException("Not enough questions");
        }

        if (0 < amount) {
            List<Question> randomQuestion = getQuestions(allQuestions.size());

            uniqueQuestions.add((Question) randomQuestion);
            questions.addAll(uniqueQuestions);

            return questions;
        }
        return questions;
    }
}
