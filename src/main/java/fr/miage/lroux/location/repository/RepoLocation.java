package fr.miage.lroux.location.repository;

import fr.miage.lroux.location.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepoLocation extends CrudRepository<Location,Long> {

    Iterable<Location> findByUserId(Long userId);
    Iterable<Location> findByCarId(Long voitureId);

}
