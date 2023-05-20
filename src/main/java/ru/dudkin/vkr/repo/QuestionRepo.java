package ru.dudkin.vkr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dudkin.vkr.model.Material;
import ru.dudkin.vkr.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {
}
