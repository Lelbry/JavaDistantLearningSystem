package ru.dudkin.vkr;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.dudkin.vkr.model.Material;
import ru.dudkin.vkr.model.Theme;
import ru.dudkin.vkr.repo.MaterialRepo;
import ru.dudkin.vkr.repo.ThemeRepo;
import ru.dudkin.vkr.service.MaterialService;
import ru.dudkin.vkr.service.ThemeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest

@Transactional
public class ThemeTests {
    @Autowired
    private ThemeService themeService;

    @Autowired
    private ThemeRestController themeRestController;

    @Autowired
    private ThemeRepo themeRepo;

    @Test
    public void testAdd() {
        String name = "example-name";

        themeRestController.add(name);

        // Проверяем, что объект был успешно добавлен в базу данных
        // Метод `.count()` возвращает только количество записей в таблице, то есть количество строк
        // в таблице. Он не учитывает количество столбцов, которые заполнены в каждой строке таблицы.
        assertEquals(themeRepo.count(), 1);
        Theme savedTheme = themeRepo.findAll().get(0);

        assertEquals(savedTheme.getName(), name);
    }

    @Test
    public void testEdit() {
        String name = "example-name";

        // добавляем объект в базу данных
        Theme theme = new Theme();
        theme.setName(name);
        themeRepo.save(theme);

        // вызываем метод редактирования объекта
        long id = theme.getId();
        String newName = "updated-name";
        themeRestController.edit(id, newName);

        // проверяем, что объект был успешно отредактирован в базе данных
        Theme savedTheme = themeRepo.getById(id);
        assertEquals(savedTheme.getName(), newName);
    }

    @Test
    public void testDelete() {
        String name = "example-name";

        // добавляем объект в базу данных
        Theme theme = new Theme();
        theme.setName(name);
        themeRepo.save(theme);

        // вызываем метод удаления объекта
        long id = theme.getId();
        themeRestController.delete(id);

        // проверяем, что Тема была успешна удалённа в базе данных
        // Данная строка проверяет, существует ли объект в базе данных с id, указанным в переменной id.
        assertFalse(themeRepo.existsById(id));
    }
}
