package ru.dudkin.vkr.service;

import org.springframework.stereotype.Service;
import ru.dudkin.vkr.model.SubTheme;
import ru.dudkin.vkr.model.Theme;
import ru.dudkin.vkr.repo.SubThemeRepo;
import ru.dudkin.vkr.repo.ThemeRepo;

import javax.transaction.Transactional;

@Service
public class SubThemeService {
    private final SubThemeRepo subThemeRepo;
    public final ThemeRepo themeRepo;

    public SubThemeService(SubThemeRepo subThemeRepo, ThemeRepo themeRepo) {
        this.subThemeRepo = subThemeRepo;
        this.themeRepo = themeRepo;
    }

    public void remove(Long id){
        subThemeRepo.deleteById(id);
    }

    //При добавлении нужно указывать Тему из таблицы в бд Theme, и название Раздел
    /*@Transactional
    public void add(Theme themeId, SubTheme subTheme){
        subThemeRepo.save(themeId, subTheme);
    }*/

    public void edit(long id,SubTheme subTheme, Long themeId){
        SubTheme subTheme1 = subThemeRepo.getById(id);
        subTheme1.copy(subTheme);
        subTheme1.setTheme_id(subTheme1);
        subThemeRepo.save(subTheme1);
    }

    @Transactional
    public void add(SubTheme subTheme, Long themeId) {
        Theme theme = themeRepo.getById(themeId);
        subTheme.setTheme_id(theme);
        subThemeRepo.save(subTheme);
    }
}
