package ru.dudkin.vkr;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.dudkin.vkr.model.Illustration;
import ru.dudkin.vkr.repo.IllustrationRepo;
import ru.dudkin.vkr.service.IllustrationService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest

@Transactional
public class IllustrationTests {

    @Autowired
    private IllustrationService illustrationService;

    @Autowired
    private IllustrationRestController illustrationRestController;

    @Autowired
    private IllustrationRepo illustrationRepository;

    @Test
    public void testAdd() {
        String link = "example-link";
        String subtitle_Text_Refer = "example-subtitle-text-refer";

        illustrationRestController.add(link, subtitle_Text_Refer);

        // Проверяем, что иллюстрация была успешно добавлена в базу данных
        assertEquals(illustrationRepository.count(), 1);
        Illustration savedIllustration = illustrationRepository.findAll().get(0);

        assertEquals(savedIllustration.getLink(), link);
        assertEquals(savedIllustration.getSubtitleTextRefer(), subtitle_Text_Refer);
    }

    @Test
    public void testEdit() {
        String link = "example-link";
        String subtitle_Text_Refer = "example-subtitle-text-refer";

        // добавляем иллюстрацию в базу данных
        Illustration illustration = new Illustration();
        illustration.setLink(link);
        illustration.setSubtitleTextRefer(subtitle_Text_Refer);
        illustrationRepository.save(illustration);

        // вызываем метод редактирования иллюстрации
        long id = illustration.getId();
        String updatedLink = "updated-link";
        String updatedSubtitle_Text_Refer = "updated-subtitle";
        illustrationRestController.edit(id, updatedLink, updatedSubtitle_Text_Refer);

        // проверяем, что иллюстрация была успешно отредактирована в базе данных
        Illustration savedIllustration = illustrationRepository.getById(id);
        assertEquals(savedIllustration.getLink(), updatedLink);
        assertEquals(savedIllustration.getSubtitleTextRefer(), updatedSubtitle_Text_Refer);
    }
    @Test
    public void testDelete() {
        String link = "example-link";
        String subtitle_Text_Refer = "example-subtitle-text-refer";

        // добавляем иллюстрацию в базу данных
        Illustration illustration = new Illustration();
        illustration.setLink(link);
        illustration.setSubtitleTextRefer(subtitle_Text_Refer);
        illustrationRepository.save(illustration);

        // вызываем метод удаления иллюстрации
        long id = illustration.getId();
        illustrationRestController.delete(id);

        // проверяем, что иллюстрация была успешно удалена в базе данных
        assertFalse(illustrationRepository.existsById(id));
    }
}
