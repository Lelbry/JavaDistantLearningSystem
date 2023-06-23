package ru.dudkin.vkr;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.dudkin.vkr.model.Question;
import ru.dudkin.vkr.repo.QuestionRepo;
import ru.dudkin.vkr.service.QuestionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest

@Transactional
public class QuestionTests {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionRestController questionRestController;

    @Autowired
    private QuestionRepo questionRepository;

    @Test
    public void testAdd() {
        String questionText = "example-question";
        String answer1 = "example-answer-1";
        Boolean answerBool1 = true;
        String answer2 = "example-answer-2";
        Boolean answerBool2 = false;
        String answer3 = "example-answer-3";
        Boolean answerBool3 = true;
        String answer4 = "example-answer-4";
        Boolean answerBool4 = false;

        questionRestController.add(questionText, answer1, answerBool1, answer2, answerBool2, answer3, answerBool3, answer4, answerBool4);

        // Проверяем, что вопрос был успешно добавлен в базу данных
        assertEquals(questionRepository.count(), 1);
        Question savedQuestion = questionRepository.findAll().get(0);

        assertEquals(savedQuestion.getQuestion(), questionText);
        assertEquals(savedQuestion.getAns1(), answer1);
        assertEquals(savedQuestion.getAnsBool1(), answerBool1);
        assertEquals(savedQuestion.getAns2(), answer2);
        assertEquals(savedQuestion.getAnsBool2(), answerBool2);
        assertEquals(savedQuestion.getAns3(), answer3);
        assertEquals(savedQuestion.getAnsBool3(), answerBool3);
        assertEquals(savedQuestion.getAns4(), answer4);
        assertEquals(savedQuestion.getAnsBool4(), answerBool4);
    }

    @Test
    public void testEdit() {
        String questionText = "example-question";
        String answer1 = "example-answer-1";
        Boolean answerBool1 = true;
        String answer2 = "example-answer-2";
        Boolean answerBool2 = false;
        String answer3 = "example-answer-3";
        Boolean answerBool3 = true;
        String answer4 = "example-answer-4";
        Boolean answerBool4 = false;

        // добавляем вопрос в базу данных
        Question question = new Question(questionText, answer1, answerBool1, answer2, answerBool2, answer3, answerBool3, answer4, answerBool4);
        questionRepository.save(question);

        // вызываем метод редактирования вопроса
        long id = question.getId();
        String updatedQuestionText = "updated-question";
        String updatedAnswer1 = "updated-answer-1";
        Boolean updatedAnswerBool1 = false;
        String updatedAnswer2 = "updated-answer-2";
        Boolean updatedAnswerBool2 = true;
        String updatedAnswer3 = "updated-answer-3";
        Boolean updatedAnswerBool3 = false;
        String updatedAnswer4 = "updated-answer-4";
        Boolean updatedAnswerBool4 = true;
        questionRestController.edit(id, updatedQuestionText, updatedAnswer1, updatedAnswerBool1,
                updatedAnswer2, updatedAnswerBool2, updatedAnswer3, updatedAnswerBool3,
                updatedAnswer4, updatedAnswerBool4);

        // проверяем, что вопрос был успешно отредактирован в базе данных
        Question savedQuestion = questionRepository.getById(id);
        assertEquals(savedQuestion.getQuestion(), updatedQuestionText);
        assertEquals(savedQuestion.getAns1(), updatedAnswer1);
        assertEquals(savedQuestion.getAnsBool1(), updatedAnswerBool1);
        assertEquals(savedQuestion.getAns2(), updatedAnswer2);
        assertEquals(savedQuestion.getAnsBool2(), updatedAnswerBool2);
        assertEquals(savedQuestion.getAns3(), updatedAnswer3);
        assertEquals(savedQuestion.getAnsBool3(), updatedAnswerBool3);
        assertEquals(savedQuestion.getAns4(), updatedAnswer4);
        assertEquals(savedQuestion.getAnsBool4(), updatedAnswerBool4);
    }

    @Test
    public void testDelete() {
        String questionText = "example-question";
        String answer1 = "example-answer-1";
        Boolean answerBool1 = true;
        String answer2 = "example-answer-2";
        Boolean answerBool2 = false;
        String answer3 = "example-answer-3";
        Boolean answerBool3 = true;
        String answer4 = "example-answer-4";
        Boolean answerBool4 = false;

        // добавляем вопрос в базу данных
        Question question = new Question(questionText, answer1, answerBool1, answer2, answerBool2, answer3, answerBool3, answer4, answerBool4);
        questionRepository.save(question);

        // вызываем метод удаления вопроса
        long id = question.getId();
        questionRestController.delete(id);

        // проверяем, что вопрос был успешно удалён в базе данных
        assertFalse(questionRepository.existsById(id));
    }
}