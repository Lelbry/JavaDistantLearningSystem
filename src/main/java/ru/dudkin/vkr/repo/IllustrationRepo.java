package ru.dudkin.vkr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dudkin.vkr.model.Illustration;

@Repository
public interface IllustrationRepo extends JpaRepository<Illustration, Long> {

}
