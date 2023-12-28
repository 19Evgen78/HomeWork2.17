package pro.sky.java.cource2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.cource2.examinerservice.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class JavaQuestionService implements QuestionService {
    private List<Question> javaQuestions = new ArrayList<>();
    //private List<Question> javaQuestions;
    private Random random;
//public JavaQuestionService() {
        //javaQuestions = new ArrayList<>();
    //}

    @Override
    public void addQuestion(Question question) {
        javaQuestions.add(question);
    }

    @Override
    public void removeQuestion(Question question) {
        javaQuestions.remove(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return javaQuestions;
    }

    @Override
    public Question getRandomQuestion() {
        //Random random = new Random();
        int randomIndex = random.nextInt(javaQuestions.size());
        return javaQuestions.get(randomIndex);
    }

    @Override
    public Object getAll() {
        return null;
    }
}
