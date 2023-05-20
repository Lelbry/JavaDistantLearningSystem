package ru.dudkin.vkr;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import ru.dudkin.vkr.model.Illustration;
import ru.dudkin.vkr.model.Material;
import ru.dudkin.vkr.service.IllustrationService;

import java.util.List;

@RestController
@RequestMapping("/illustration")
public class IllustrationRestController {
    private final IllustrationService illustrationService;

    @Autowired
    public IllustrationRestController(IllustrationService illustrationService) {
        this.illustrationService = illustrationService;
    }

    @PostMapping("/")
    @Operation(summary = "этот метод добавляет объект (Illustration) в БД, нужно указать ссылку и привязку к разделу")
    public void add(@Parameter(description = "Введите ссылку которую необходимо сохранить") @RequestParam String link,
                    @Parameter(description = "Укажите к какому разделу принадлежит данная ссылка") @RequestParam String linkRefer)
    {illustrationService.add(link, linkRefer);}

    @DeleteMapping("/")
    @Operation(summary = "этот метод удаляет строчку из таблицы Illustration из базы даннах по id")
    public void delete(@Parameter(description = "укажите Id из таблицы Illustration которую нужно удалить из Базы данных")
                       @RequestParam long id){illustrationService.remove(id);}

    @GetMapping("/")
    @Operation(summary = "этот метод выводит список всех строк содержащихся в таблице Illustration которые хранятся в базе данных")
    public List<Illustration> get(){return illustrationService.getList();}
}
