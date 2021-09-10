package ru.portal.onlearn.repo;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.portal.onlearn.model.SphereOfActivities;

import java.util.Optional;

public interface SphereOfActivitiesRepository extends JpaRepository<SphereOfActivities, Long> {

}
