package ru.dudkin.vkr.service;

import org.springframework.stereotype.Service;
import ru.dudkin.vkr.model.SubTheme;
import ru.dudkin.vkr.model.Theme;
import ru.dudkin.vkr.repo.SubThemeRepo;
import ru.dudkin.vkr.repo.ThemeRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubThemeService {
    private final SubThemeRepo subThemeRepo;
    public final ThemeRepo themeRepo;

    public List<SubTheme> getList(){return subThemeRepo.findAll();}

    public SubThemeService(SubThemeRepo subThemeRepo, ThemeRepo themeRepo) {
        this.subThemeRepo = subThemeRepo;
        this.themeRepo = themeRepo;
    }

    public void remove(Long id){
        subThemeRepo.deleteById(id);
    }

    @Transactional
    public void add(String subThemeName, Long themeId){
        SubTheme subTheme = new SubTheme();
        try {
            Theme theme = themeRepo.findById(themeId).orElseThrow(Exception::new);
            subTheme.setTheme(theme);
        } catch (Exception e) {
            e.printStackTrace();
        }
        subTheme.setName_SbThemes(subThemeName);
        subThemeRepo.save(subTheme);
    }

    public void edit(long id,String subThemeNew, Long themeId){
        SubTheme subTheme1 = subThemeRepo.getById(id);
        subTheme1.setName_SbThemes(subThemeNew);
        try {
            Theme theme = themeRepo.findById(themeId).orElseThrow(Exception::new);
            theme.setId(themeId);
            subTheme1.setTheme(theme);
        } catch (Exception e) {
            e.printStackTrace();
        }
        subThemeRepo.save(subTheme1);
    }

}