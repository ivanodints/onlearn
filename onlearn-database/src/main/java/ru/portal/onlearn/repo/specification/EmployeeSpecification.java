package ru.portal.onlearn.repo.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.portal.onlearn.model.Employee;

public final class EmployeeSpecification {

    public static Specification<Employee> byId(long id){
        return (root, criteriaQuery, cb) -> cb.equal(root.get("id"), id);
    }

    public static Specification<Employee> bySurname(String surname){
        return (root, criteriaQuery, cb) -> cb.equal(root.get("surname"), surname);
    }

    public static Specification<Employee> bySex (String sex){
        return (root, criteriaQuery, cb) -> cb.equal(root.get("sex"), sex);
    }

}
