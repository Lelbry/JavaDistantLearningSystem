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
    @Transactional
    public void add(long themeId, SubTheme subTheme){
        try {
            Theme theme = themeRepo.findById(themeId).orElseThrow(Exception::new);
            subTheme.setTheme(theme);
        } catch (Exception e) {
            e.printStackTrace();
        }

        subThemeRepo.save(subTheme);
    }
    //Вытащить тему по Айдишнику из темы и передать
    public void edit(long id,SubTheme subTheme, Long themeId){
        SubTheme subTheme1 = subThemeRepo.getById(id);
        subTheme1.copy(subTheme);
        try {
            Theme theme = themeRepo.findById(themeId).orElseThrow(Exception::new);
            subTheme1.setTheme(theme);
        } catch (Exception e) {
            e.printStackTrace();
        }
        subThemeRepo.save(subTheme1);
    }

//    @Transactional
//    public void add(SubTheme subTheme, Long themeId) {
//        Theme theme = themeRepo.getById(themeId);
//        subTheme.setTheme(theme);
//        subThemeRepo.save(subTheme);
//    }
}
