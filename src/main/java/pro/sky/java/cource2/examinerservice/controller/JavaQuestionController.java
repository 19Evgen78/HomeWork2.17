package pro.sky.java.cource2.examinerservice.controller;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.cource2.examinerservice.model.Question;
import pro.sky.java.cource2.examinerservice.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add")
    public void addQuestion(@RequestParam("question") String questionText, @RequestParam("answer") String answerText) {
        Question question = new Question(questionText, answerText);
        questionService.addQuestion(question);
    }

    @PostMapping("/remove")
    public void removeQuestion(@RequestParam("question") String questionText, @RequestParam("answer") String answerText) {
        Question question = new Question(questionText, answerText);
        questionService.removeQuestion(question);
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}
