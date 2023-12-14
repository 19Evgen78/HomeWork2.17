package pro.sky.java.cource2.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pro.sky.java.cource2.examinerservice.model.Question;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private JavaQuestionService questionService;

    @Mock
    private Question question;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        questionService = new JavaQuestionService();
        questionService.addQuestion(question);
    }

    @Test
    public void testAddQuestion() {
        List<Question> expectedQuestions = new ArrayList<>();
        expectedQuestions.add(question);

        assertEquals(expectedQuestions, questionService.getAllQuestions());
    }

    @Test
    public void testRemoveQuestion() {
        questionService.removeQuestion(question);

        assertTrue(questionService.getAllQuestions().isEmpty());
    }

    @Test
    public void testGetAllQuestions() {
        List<Question> expectedQuestions = new ArrayList<>();
        expectedQuestions.add(question);

        assertEquals(expectedQuestions, questionService.getAllQuestions());
    }

    @Test
    public void testGetRandomQuestion() {
        assertNotNull(questionService.getRandomQuestion());
    }
}