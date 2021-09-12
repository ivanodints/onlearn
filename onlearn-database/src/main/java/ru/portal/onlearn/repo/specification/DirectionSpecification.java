package ru.portal.onlearn.repo.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.portal.onlearn.model.Direction;

public final class DirectionSpecification {

    public static Specification<Direction> byId (long id){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<Direction> byTitle (String title){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), title);
    }

    public static Specification<Direction> equalByDirection(long directionId){
        return (root, query, cb) -> cb.equal(root.get("direction").get("id"),directionId);
    }

    public static Specification<Direction> equalByFaculty(long facultyId){
        return (root, query, cb) -> cb.equal(root.get("direction").get("id"),facultyId);
    }

}
