package ru.dudkin.vkr;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.dudkin.vkr.model.Material;
import ru.dudkin.vkr.repo.MaterialRepo;
import ru.dudkin.vkr.service.MaterialService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest

    @Transactional
    public class MaterialRestControllerTests {

        @Autowired
        private MaterialService materialService;

        @Autowired
        private MaterialRestController materialRestController;

        @Autowired
        private MaterialRepo materialRepository;

        @Test
        public void testAdd() {
            String numberSubtitleTextRefer = "example-number";
            String mainTxt = "example-main-txt";

            materialRestController.add(numberSubtitleTextRefer, mainTxt);

            // Проверяем, что материал был успешно добавлен в базу данных
            // Метод `.count()` возвращает только количество записей в таблице, то есть количество строк
            // в таблице. Он не учитывает количество столбцов, которые заполнены в каждой строке таблицы.
            assertEquals(materialRepository.count(), 1);
            Material savedMaterial = materialRepository.findAll().get(0);

            assertEquals(savedMaterial.getNumberSubtitleTextRefer(), numberSubtitleTextRefer);
            assertEquals(savedMaterial.getMainTxt(), mainTxt);
    }

    @Test
    public void testEdit() {
        String numberSubtitleTextRefer = "example-number";
        String mainTxt = "example-main-txt";

        // добавляем материал в базу данных
        Material material = new Material();
        material.setNumberSubtitleTextRefer(numberSubtitleTextRefer);
        material.setMainTxt(mainTxt);
        materialRepository.save(material);

        // вызываем метод редактирования материала
        long id = material.getId();
        String updatedNumberSubtitleTextRefer = "updated-number";
        String updatedMainTxt = "updated-txt";
        materialRestController.edit(id, updatedNumberSubtitleTextRefer, updatedMainTxt);

        // проверяем, что материал был успешно отредактирован в базе данных
        Material savedMaterial = materialRepository.getById(id);
        assertEquals(savedMaterial.getNumberSubtitleTextRefer(), updatedNumberSubtitleTextRefer);
        assertEquals(savedMaterial.getMainTxt(), updatedMainTxt);
    }
    @Test
    public void testDelete() {
        String numberSubtitleTextRefer = "example-number";
        String mainTxt = "example-main-txt";

        // добавляем материал в базу данных
        Material material = new Material();
        material.setNumberSubtitleTextRefer(numberSubtitleTextRefer);
        material.setMainTxt(mainTxt);
        materialRepository.save(material);

        // вызываем метод удаления материала
        long id = material.getId();
        materialRestController.delete(id);

        // проверяем, что материал был успешно удалён в базе данных
        //Данная строка проверяет, существует ли объект Material в базе данных с id, указанным в переменной id.
        assertFalse(materialRepository.existsById(id));
    }
    //Тест не дописан, нужно использользовать Мок-объект для имитации реального объекта и проверить
    // сколько раз был вызван метод get
    /*@Test
    public void testGetList(){
            String numberSubtitleTextRefer = "example-number";
            String mainTxt = "example-main-txt";

            Material material = new Material();
            material.setNumberSubtitleTextRefer(numberSubtitleTextRefer);
            material.setMainTxt(mainTxt);
            materialRepository.save(material);

            materialRestController.get();

            verify(materialRestController.get(), times(1)).get();
    }*/
}
