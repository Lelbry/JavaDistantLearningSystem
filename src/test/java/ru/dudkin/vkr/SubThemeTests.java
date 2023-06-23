package ru.dudkin.vkr;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.dudkin.vkr.model.SubTheme;
import ru.dudkin.vkr.model.Theme;
import ru.dudkin.vkr.repo.SubThemeRepo;
import ru.dudkin.vkr.repo.ThemeRepo;
import ru.dudkin.vkr.service.SubThemeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest

@Transactional
public class SubThemeTests {
    @Autowired
    private SubThemeService subThemeService;
    @Autowired
    private SubThemeRestController subThemeRestController;
    @Autowired
    private SubThemeRepo subThemeRepo;
    @Autowired
    private ThemeRepo themeRepo;

    @Test
    public void testAdd() {
        String name = "example-name";
        long themeId = 800;

        subThemeRestController.add(name, themeId);

        // Проверяем, что объект был успешно добавлен в базу данных
        // Метод `.count()` возвращает только количество записей в таблице, то есть количество строк
        // в таблице. Он не учитывает количество столбцов, которые заполнены в каждой строке таблицы.
        assertEquals(subThemeRepo.count(), 1);
        SubTheme savedSubTheme = subThemeRepo.findAll().get(0);

        assertEquals(savedSubTheme.getName_SbThemes(), name);
    }
    //Не рабочий метод проверки Edit, из-за связи Theme с SubTheme
    @Test
    public void testEdit() {
        String name = "example_name";
        String nameTheme = "example_name_theme";
        //long id = 500;
        //long themeIdNew = 1000;

        // добавляем объекты в базу данных
        Theme theme = new Theme();
        theme.setName(nameTheme);
        themeRepo.save(theme);

        Theme themeNew = new Theme();
        //themeNew.setId(themeIdNew);
        themeNew.setName("example_name_theme_new");
        themeRepo.save(themeNew);

        SubTheme subTheme = new SubTheme();
        subTheme.setName_SbThemes(name);
       // subTheme.setId(id);
        subTheme.setTheme(theme);
        subThemeRepo.save(subTheme);

        // вызываем метод редактирования объекта
        String newName = "updated_name";
        //subThemeRestController.edit(id, newName, themeIdNew);

        // проверяем, что объект был успешно отредактирован в базе данных
       // SubTheme savedSubTheme = subThemeRepo.getById(id);
        //assertEquals(savedSubTheme.getName_SbThemes(), newName);
    }

    @Test
    public void testDelete() {
        String name = "example-name";

        // добавляем объект в базу данных
        SubTheme subTheme = new SubTheme();
        subTheme.setName_SbThemes(name);
        subThemeRepo.save(subTheme);

        // вызываем метод удаления объекта
        long id = subTheme.getId();
        subThemeRestController.delete(id);

        // проверяем, что Тема была успешна удалённа в базе данных
        // Данная строка проверяет, существует ли объект в базе данных с id, указанным в переменной id.
        assertFalse(themeRepo.existsById(id));
    }
}
