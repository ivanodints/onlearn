package ru.portal.onlearn.repo.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.portal.onlearn.model.Faculty;

public final class FacultySpecification {

    public static Specification<Faculty> byId (long id){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<Faculty> byTitle(String title) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), title);
    }

    public static Specification<Faculty> byDirection(long directionId) {
        return (root, query, builder) -> builder.equal(root.get("direction").get("id"), directionId);
    }
}
