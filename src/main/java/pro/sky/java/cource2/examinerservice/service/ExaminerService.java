package pro.sky.java.cource2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.cource2.examinerservice.model.Question;

import java.util.Set;

@Service
public interface ExaminerService {
    Set<Question> getQuestions(int amount) throws InterruptedException;
}
