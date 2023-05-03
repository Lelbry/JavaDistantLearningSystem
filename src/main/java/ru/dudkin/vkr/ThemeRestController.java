package ru.dudkin.vkr;

import io.swagger.v3.oas.annotations.Operation;
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
    public void add(@RequestBody Theme theme){themeService.add(theme);}

    @GetMapping("/")
    @Operation(summary = "этот метод выводит список всех Тем которые храняться в базе данных")
    public List <Theme> get(){return themeService.getList();}

    @DeleteMapping("/")
    @Operation(summary = "этот метод удаляет Тему из базы даннах по id")
    public void delete(@RequestBody int id){themeService.remove(id);}

    @PutMapping("/")
    @Operation(summary = "этот метод позволит редактировать Тему в базе данных по id")
    public void edit(@RequestParam int id, @RequestBody Theme theme){themeService.edit(id, theme);}

}
