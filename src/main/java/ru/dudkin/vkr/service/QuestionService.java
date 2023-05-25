package ru.dudkin.vkr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dudkin.vkr.model.Material;
import ru.dudkin.vkr.model.Question;
import ru.dudkin.vkr.repo.QuestionRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepo questionRepo;

    public QuestionService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public void remove (long id){
        questionRepo.deleteById(id);
    }

    public List<Question> getList(){return questionRepo.findAll();}

    @Transactional
    public void add(String questionName, String ans1, Boolean ans1Bool, String ans2, Boolean ans2Bool,
                    String ans3, Boolean ans3Bool, String ans4, Boolean ans4Bool){
        Question question = new Question();
        question.setQuestion(questionName);
        question.setAns1(ans1);
        question.setAns2(ans2);
        question.setAns3(ans3);
        question.setAns4(ans4);
        question.setAnsBool1(ans1Bool);
        question.setAnsBool2(ans2Bool);
        question.setAnsBool3(ans3Bool);
        question.setAnsBool4(ans4Bool);
        questionRepo.save(question);
    }

    @Transactional
    public void edit(long id, String questionName, String ans1, Boolean ans1Bool, String ans2, Boolean ans2Bool,
                    String ans3, Boolean ans3Bool, String ans4, Boolean ans4Bool){
        Question question = new Question();
        question.setId(id);
        question.setQuestion(questionName);
        question.setAns1(ans1);
        question.setAns2(ans2);
        question.setAns3(ans3);
        question.setAns4(ans4);
        question.setAnsBool1(ans1Bool);
        question.setAnsBool2(ans2Bool);
        question.setAnsBool3(ans3Bool);
        question.setAnsBool4(ans4Bool);
        questionRepo.save(question);
    }
}
