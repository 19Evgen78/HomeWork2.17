package pro.sky.java.cource2.examinerservice.service;

import ch.qos.logback.core.joran.spi.ElementPath;
import org.springframework.stereotype.Service;
import pro.sky.java.cource2.examinerservice.model.Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        List<Question> questions = new ArrayList<>();
        Set<Question> uniqueQuestions = new HashSet<>();

        ElementPath allQuestions = null;
        if (amount > allQuestions.size()) {
            throw new IllegalArgumentException("Not enough questions");
        }

        while (uniqueQuestions.size() < amount && uniqueQuestions.size() < allQuestions.size()) {
            List<Question> randomQuestion = getQuestions(allQuestions.size());

            if (!uniqueQuestions.contains(randomQuestion)) {
                uniqueQuestions.add((Question) randomQuestion);
            }
            //ElementPath availableQuestions = null;
            //if (uniqueQuestions.size() < amount || uniqueQuestions.size() > availableQuestions.size()) {
            //throw new IllegalArgumentException("Not enough questions");
            //}

            //while (uniqueQuestions.size() < amount || uniqueQuestions.size() > availableQuestions.size()) {
            //Question randomQuestion = questionService.getRandomQuestion();
            //uniqueQuestions.add(randomQuestion);
            //}

            //if (uniqueQuestions.size() < amount) {
            // throw new IllegalArgumentException("Not enough questions");
            //}

            questions.addAll(uniqueQuestions);

            return questions;
        }
        return questions;
    }
}
