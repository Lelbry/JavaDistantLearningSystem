package ru.dudkin.vkr.service;

import ru.dudkin.vkr.repo.SubThemesRepo;

public class SubThemeService {
    private final SubThemesRepo subThemesRepo;

    public SubThemeService(SubThemesRepo subThemesRepo) {
        this.subThemesRepo = subThemesRepo;
    }
    public void remove(Long id){
        subThemesRepo.deleteById(id);
    }

}
