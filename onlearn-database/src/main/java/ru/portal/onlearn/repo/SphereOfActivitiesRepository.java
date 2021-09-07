package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.portal.onlearn.model.SphereOfActivities;

import java.util.Optional;

public interface SphereOfActivitiesRepository extends JpaRepository<SphereOfActivities, Long> {

    Optional<SphereOfActivities> findSphereOfActivitiesByTitle (String title);
}
