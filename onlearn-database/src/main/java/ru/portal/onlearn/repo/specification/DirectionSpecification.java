package ru.portal.onlearn.repo.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.portal.onlearn.model.Direction;

public class DirectionSpecification {
    public static Specification<Direction> titleLike (String title){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), title));
    }
}
