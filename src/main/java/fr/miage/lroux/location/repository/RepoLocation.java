package fr.miage.lroux.location.repository;

import fr.miage.lroux.location.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoLocation extends CrudRepository<Location,Long> {
}
