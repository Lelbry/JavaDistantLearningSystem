package ru.dudkin.vkr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dudkin.vkr.model.Material;

@Repository
public interface MaterialsRepo extends JpaRepository<Material, Long> {

}
