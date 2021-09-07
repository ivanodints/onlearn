package ru.portal.onlearn.repo.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.portal.onlearn.model.SphereOfActivities;

public final class SphereOfActivitiesSpecification {

    public static Specification<SphereOfActivities> byId (long id){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<SphereOfActivities> byTitle (String title){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), title);
    }

}
