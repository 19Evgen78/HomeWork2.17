package pro.sky.java.cource2.examinerservice.controller;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.cource2.examinerservice.model.Question;
import pro.sky.java.cource2.examinerservice.service.ExaminerService;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public List<Question> getExamQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
