package ru.portal.onlearn.repo.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.portal.onlearn.model.User;

public final class UserSpecification {

    public static Specification<User> byId(long id){
        return (root, criteriaQuery, cb) -> cb.equal(root.get("id"), id);
    }

    public static Specification<User> byLogin(String login){
        return (root, criteriaQuery, cb) -> cb.equal(root.get("login"), login);
    }

}
