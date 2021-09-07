package ru.portal.onlearn.repo.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.portal.onlearn.model.SphereFac;

public final class SphereFacSpecification {

    public static Specification<SphereFac> byId(long id){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

}
