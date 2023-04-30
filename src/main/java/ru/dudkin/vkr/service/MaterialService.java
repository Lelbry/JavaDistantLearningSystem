package ru.dudkin.vkr.service;

import org.springframework.stereotype.Service;
import ru.dudkin.vkr.model.Material;
import ru.dudkin.vkr.repo.MaterialsRepo;

import javax.transaction.Transactional;

@Service
public class MaterialService {
    private final MaterialsRepo materialsRepo;

    public MaterialService(MaterialsRepo materialsRepo){
        this.materialsRepo = materialsRepo;
    }

    public void remove (long id){
        materialsRepo.deleteById(id);
    }

    @Transactional
    public void add(long id, Material materials){
        Material materials1 = materialsRepo.getById(id);
        materials1.setMainTxt(materials.getMainTxt());
    }
}
