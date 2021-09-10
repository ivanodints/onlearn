//package ru.portal.onlearn.repo.specification;
//
//import org.springframework.data.jpa.domain.Specification;
//import ru.portal.onlearn.model.Student;
//
//public final class StudentSpecification {
//
//    public static Specification<Student> byId (long id){
//        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
//    }
//
//    public static Specification<Student> bySurname(String surname){
//        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("surname"), surname);
//    }
//}
