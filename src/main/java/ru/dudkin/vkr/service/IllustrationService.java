package ru.dudkin.vkr.service;

import org.springframework.stereotype.Service;
import ru.dudkin.vkr.model.Illustration;
import ru.dudkin.vkr.repo.IllustrationRepo;
import ru.dudkin.vkr.repo.MaterialRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IllustrationService {
    private  final IllustrationRepo illustrationRepo;

    public IllustrationService(IllustrationRepo illustrationRepo) {
        this.illustrationRepo = illustrationRepo;
    }

    @Transactional
    public void add(String link, String subtitleRefer){
        Illustration illustration = new Illustration();
        illustration.setLink(link);
        illustration.setSubtitleTextRefer(subtitleRefer);
        illustrationRepo.save(illustration);
    }

    public List<Illustration> getList(){return illustrationRepo.findAll();}

    public void remove (long id){illustrationRepo.deleteById(id);}
}
