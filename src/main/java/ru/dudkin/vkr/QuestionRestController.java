package ru.dudkin.vkr;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import ru.dudkin.vkr.model.Material;
import ru.dudkin.vkr.model.Question;
import ru.dudkin.vkr.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionRestController {
    private final QuestionService questionService;

    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/")
    @Operation(summary = "Этот метод добавляет вопрос и варианты ответа к нему в БД")
    public void add(@Parameter(description = "Введите вопрос") @RequestParam String question,
                    @Parameter(description = "Введите первый вариант ответа") @RequestParam String ans1,
                    @Parameter(description = "Если ответ 1 правильный, введите 1, иначе 0") @RequestParam Boolean ans1Bool,
                    @Parameter(description = "Введите второй вариант ответа") @RequestParam String ans2,
                    @Parameter(description = "Если ответ 2 правильный, введите 1, иначе 0") @RequestParam Boolean ans2Bool,
                    @Parameter(description = "Введите третий вариант ответа") @RequestParam String ans3,
                    @Parameter(description = "Если ответ 3 правильный, введите 1, иначе 0") @RequestParam Boolean ans3Bool,
                    @Parameter(description = "Введите четвертый вариант ответа") @RequestParam String ans4,
                    @Parameter(description = "Если ответ 3 правильный, введите 1, иначе 0") @RequestParam Boolean ans4Bool)
    {questionService.add(question, ans1, ans1Bool, ans2, ans2Bool, ans3, ans3Bool, ans4, ans4Bool);}

    @DeleteMapping("/")
    @Operation(summary = "этот метод удаляет строчку из таблицы Question из базы даннах по id")
    public void delete(@Parameter(description = "укажите Id из таблицы Question которую нужно удалить из Базы данных")
                       @RequestParam long id){questionService.remove(id);}

    @GetMapping("/")
    @Operation(summary = "этот метод выводит список всех строк содержащихся в таблице Question которые хранятся в базе данных")
    public List<Question> get(){return questionService.getList();}
}
