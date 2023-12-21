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
        Set<List<Question>> uniqueQuestions = new HashSet<>();

        List allQuestions = questionService.getAllQuestions();
        if (amount > allQuestions.size()) {
            throw new IllegalArgumentException("Not enough questions");

        }

        while (uniqueQuestions.size() < amount && uniqueQuestions.size() < allQuestions.size()) {
            List<Question> randomQuestion;
            randomQuestion = getQuestions(allQuestions);

            if (!uniqueQuestions.contains(randomQuestion)) {
                uniqueQuestions.add(randomQuestion);
            }

            return questions;
        }
        return questions;
    }

    private List<Question> getQuestions(List allQuestions) {
        return null;
    }
}
