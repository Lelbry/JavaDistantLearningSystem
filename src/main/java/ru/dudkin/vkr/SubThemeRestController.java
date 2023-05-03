package ru.dudkin.vkr;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import ru.dudkin.vkr.model.SubTheme;
import ru.dudkin.vkr.service.SubThemeService;

@RestController
@RequestMapping("/sub_theme")
public class SubThemeRestController {
    private final SubThemeService subThemeService;

    @Autowired
    public SubThemeRestController(SubThemeService subThemeService){this.subThemeService = subThemeService;}

    @PostMapping("/")
    @Operation(summary = "этот метод добавляет Раздел (Под тема)")
    public void add(@RequestParam int themeId @RequestBody SubTheme subTheme){subThemeService.add(themeId,subTheme);}

    @DeleteMapping("/")
    @Operation(summary = "этот метод удаляет Раздел из базы даннах по id")
    public void delete(@RequestBody long id){subThemeService.remove(id);}

    @PutMapping("/")
    @Operation(summary = "этот метод позволит редактировать Раздел (под тему) в базе данных по id")
    public void edit(@RequestParam long id, @RequestBody SubTheme subTheme){subThemeService.edit(id, subTheme);}
}
