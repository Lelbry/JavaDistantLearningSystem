package ru.dudkin.vkr.service;

import org.springframework.stereotype.Service;
import ru.dudkin.vkr.model.Theme;
import ru.dudkin.vkr.repo.ThemeRepo;
import javax.transaction.Transactional;
import java.util.List;


@Service
public class ThemeService {

    public final ThemeRepo themeRepo;

    public ThemeService(ThemeRepo themeRepo) {
        this.themeRepo = themeRepo;
    }

    public List<Theme> getList(){return themeRepo.findAll(); }

    @Transactional
    public void add(Theme theme) {
        themeRepo.save(theme);
    }

    public void remove (long id){
        themeRepo.deleteById(id);
    }

    @Transactional
    public void edit(long id, Theme theme){
        Theme theme1 = themeRepo.getById(id);
        theme1.copy(theme);
        themeRepo.save(theme1);
    }

}
