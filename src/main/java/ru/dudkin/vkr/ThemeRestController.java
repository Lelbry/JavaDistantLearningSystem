package ru.dudkin.vkr;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dudkin.vkr.model.Material;
import ru.dudkin.vkr.model.Theme;
import ru.dudkin.vkr.service.ThemeService;

@RestController
@RequestMapping("/themes")
public class ThemeRestController {


    private final ThemeService themesService;

    public ThemeRestController(ThemeService themesService) {
        this.themesService = themesService;
    }


    @PostMapping
    public void add(@RequestBody Theme theme) {
        themesService.add(theme);
    }

    @PostMapping("/test")
    public void add1(@RequestBody Material material) {
        System.out.printf("все норм");
    }
}
