package ru.dudkin.vkr.service;

import org.springframework.stereotype.Service;
import ru.dudkin.vkr.model.SubTheme;
import ru.dudkin.vkr.model.Theme;
import ru.dudkin.vkr.repo.SubThemeRepo;

import javax.transaction.Transactional;

@Service
public class SubThemeService {
    private final SubThemeRepo subThemeRepo;

    public SubThemeService(SubThemeRepo subThemeRepo) {
        this.subThemeRepo = subThemeRepo;
    }

    public void remove(Long id){
        subThemeRepo.deleteById(id);
    }

    //При добавлении нужно указывать Тему из таблицы в бд Theme, и название Раздел
    @Transactional
    public void add(Theme themeId, SubTheme subTheme){
        subThemeRepo.save(themeId, subTheme);
    }

    public void edit(long id,SubTheme subTheme){
        SubTheme subTheme1 = subThemeRepo.getById(id);
        subTheme1.copy(subTheme);
        subThemeRepo.save(subTheme1);
    }
}
