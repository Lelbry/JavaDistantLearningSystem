package ru.dudkin.vkr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dudkin.vkr.model.Theme;

@Repository
public interface ThemeRepo extends JpaRepository<Theme, Long> {
}
