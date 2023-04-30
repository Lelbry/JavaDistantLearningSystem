package ru.dudkin.vkr.service;

import org.springframework.stereotype.Service;
import ru.dudkin.vkr.model.Theme;
import ru.dudkin.vkr.repo.ThemesRepo;


@Service
public class ThemeService {

    public final ThemesRepo themesRepo;

    public ThemeService(ThemesRepo themesRepo) {
        this.themesRepo = themesRepo;
    }

    public void add(Theme theme) {
        themesRepo.save(theme);
    }
}
