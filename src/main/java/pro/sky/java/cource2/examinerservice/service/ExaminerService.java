package pro.sky.java.cource2.examinerservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import pro.sky.java.cource2.examinerservice.model.Question;

import java.util.List;
@Service
public interface ExaminerService {
    List<Question> getQuestions(int amount);
}
