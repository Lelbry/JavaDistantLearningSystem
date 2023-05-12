package ru.dudkin.vkr;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import ru.dudkin.vkr.model.SubTheme;
import ru.dudkin.vkr.service.SubThemeService;

import java.util.List;

@RestController
@RequestMapping("/Взаимодействие с Подтемами")
public class SubThemeRestController {
    private final SubThemeService subThemeService;

    @Autowired
    public SubThemeRestController(SubThemeService subThemeService){this.subThemeService = subThemeService;}

    @PostMapping("/")
    @Operation(summary = "этот метод добавляет Раздел (Под тема)")
    public void add(@Parameter(description = "Введите новое название для подтемы") @RequestParam String subThemeName, @Parameter(description = "Укажите id из таблицы Theme к чему будет привязана данная Подтема") @RequestParam long themeId){subThemeService.add(subThemeName,themeId);}

    @DeleteMapping("/")
    @Operation(summary = "этот метод удаляет Раздел из базы даннах по id")
    public void delete(@Parameter(description = "укажите Id Подтемы которую нужно удалить из Базы данных")@RequestParam long id){subThemeService.remove(id);}

    @PutMapping("/")
    @Operation(summary = "этот метод позволит редактировать Раздел (подтему) в базе данных по id")
    public void edit(@RequestParam long id, @RequestBody SubTheme subTheme, @RequestParam long themeId){subThemeService.edit(id, subTheme, themeId);}

    @GetMapping("/")
    @Operation(summary = "этот метод выводит список всех Разделов (подтем) которые храняться в базе данных")
    public List<SubTheme> get(){return subThemeService.getList();}
}
