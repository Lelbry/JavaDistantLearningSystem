package ru.dudkin.vkr.service;

import org.springframework.stereotype.Service;
import ru.dudkin.vkr.repo.IllustrationRepo;
import ru.dudkin.vkr.repo.MaterialRepo;

@Service
public class IllustrationService {
    private  final IllustrationRepo illustrationRepo;

    public IllustrationService(IllustrationRepo illustrationRepo) {
        this.illustrationRepo = illustrationRepo;
    }

    public void add(){

    }
}
