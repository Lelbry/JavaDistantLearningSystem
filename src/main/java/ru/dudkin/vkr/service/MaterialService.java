package ru.dudkin.vkr.service;

import org.springframework.stereotype.Service;
import ru.dudkin.vkr.model.Material;
import ru.dudkin.vkr.repo.MaterialRepo;

import javax.transaction.Transactional;

@Service
public class MaterialService {
    private final MaterialRepo materialRepo;

    public MaterialService(MaterialRepo materialRepo){
        this.materialRepo = materialRepo;
    }

    public void remove (long id){
        materialRepo.deleteById(id);
    }

    @Transactional
    public void add(long id, Material materials){
        Material materials1 = materialRepo.getById(id);
        materials1.setMainTxt(materials.getMainTxt());
    }
}
