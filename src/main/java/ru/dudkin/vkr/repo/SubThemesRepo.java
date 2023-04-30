package ru.dudkin.vkr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dudkin.vkr.model.SubTheme;

@Repository
public interface SubThemesRepo extends JpaRepository<SubTheme, Long> {
}
