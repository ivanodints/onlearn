package ru.portal.onlearn.repo.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.portal.onlearn.model.Direction;

public final class SphereOfActivitiesSpecification {

    public static Specification<Direction> byId (long id){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<Direction> byTitle (String title){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), title);
    }

    public static Specification<Direction> equalBySphereOfActivities(long sphereOfActivitiesId){
        return (root, query, cb) -> cb.equal(root.get("sphereOfActivities").get("id"),sphereOfActivitiesId);
    }

    public static Specification<Direction> equalByFaculty(long facultyId){
        return (root, query, cb) -> cb.equal(root.get("sphereOfActivities").get("id"),facultyId);
    }

}
