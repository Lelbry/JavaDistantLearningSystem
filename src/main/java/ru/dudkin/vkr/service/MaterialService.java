package ru.dudkin.vkr.service;

import org.springframework.stereotype.Service;
import ru.dudkin.vkr.model.Material;
import ru.dudkin.vkr.model.SubTheme;
import ru.dudkin.vkr.model.Theme;
import ru.dudkin.vkr.repo.MaterialRepo;
import ru.dudkin.vkr.repo.SubThemeRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MaterialService {
    private final MaterialRepo materialRepo;
    private final SubThemeRepo subThemeRepo;

    public void remove (long id){
        materialRepo.deleteById(id);
    }

    public List<Material> getList(){return materialRepo.findAll();}

    public MaterialService(MaterialRepo materialRepo, SubThemeRepo subThemeRepo) {
        this.materialRepo = materialRepo;
        this.subThemeRepo = subThemeRepo;
    }

    @Transactional
    public void add(String number_Subtitle_Text_Refer, String main_Txt){
        Material material = new Material();
        material.setNumberSubtitleTextRefer(number_Subtitle_Text_Refer);
        material.setMainTxt(main_Txt);
        materialRepo.save(material);
    }

    @Transactional
    public void edit(long id, String number_Subtitle_Text_Refer, String main_Txt){
        Material material = materialRepo.getById(id);
        material.setNumberSubtitleTextRefer(number_Subtitle_Text_Refer);
        material.setMainTxt(main_Txt);
        materialRepo.save(material);
    }
}
