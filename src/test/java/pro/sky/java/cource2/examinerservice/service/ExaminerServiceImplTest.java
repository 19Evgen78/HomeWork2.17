package pro.sky.java.cource2.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.verification.VerificationMode;
import pro.sky.java.cource2.examinerservice.model.Question;

import java.util.Arrays;
import java.util.List;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;

    private ExaminerService examinerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    public void testGetQuestions() {
        Question question1 = new Question("Question 1", "Answer 1");
        Question question2 = new Question("Question 2", "Answer 2");
        Question question3 = new Question("Question 3", "Answer 3");

        when(questionService.getRandomQuestion())
                .thenReturn(question1)
                .thenReturn(question2)
                .thenReturn(question3);

        int amount = 3;
        List<Question> result = examinerService.getQuestions(amount);

        assertNotNull(result);
        assertEquals(amount, result.size());

        assertTrue(result.containsAll(Arrays.asList(question1, question2, question3)));

        verify(questionService, times(amount)).getRandomQuestion();
    }

    private QuestionService verify(QuestionService questionService, VerificationMode times) {

        return questionService;
    }
}