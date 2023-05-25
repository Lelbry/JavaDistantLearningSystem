package ru.dudkin.vkr;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import ru.dudkin.vkr.model.Material;
import ru.dudkin.vkr.model.Theme;
import ru.dudkin.vkr.service.ThemeService;

import java.util.List;

@RestController
@RequestMapping("/theme")
public class ThemeRestController {


    private final ThemeService themeService;

    @Autowired
    public ThemeRestController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @PostMapping("/")
    @Operation(summary = "этот метод добавляет Тему")
    public void add(@Parameter(description = "Введите название темы") @RequestParam String themeName){themeService.add(themeName);}

    @GetMapping("/")
    @Operation(summary = "этот метод выводит список всех Тем которые храняться в базе данных")
    public List <Theme> get(){return themeService.getList();}

    @DeleteMapping("/")
    @Operation(summary = "этот метод удаляет Тему из базы даннах по id")
    public void delete(@Parameter(description = "введите Id темы которую нужно удалить") @RequestParam long id){themeService.remove(id);}

    @PutMapping("/")
    @Operation(summary = "этот метод позволит редактировать Тему в базе данных по id")
    public void edit(@Parameter(description = "Укажите Id темы которую вы хотите изменить") @RequestParam long id,
                     @Parameter(description = "Введите новое название для темы") @RequestParam String themeNewName)
    {themeService.edit(id, themeNewName);}

}
