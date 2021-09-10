//package ru.portal.onlearn.model;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "fac_student")
//@SecondaryTables(value = {
//        @SecondaryTable(name = "faculty",
//                pkJoinColumns = @PrimaryKeyJoinColumn(name = "fac_id", referencedColumnName = "id")),
//        @SecondaryTable(name = "student",
//                pkJoinColumns = @PrimaryKeyJoinColumn(name = "student_id", referencedColumnName = "id"))})
//@Getter
//@Setter
//@NoArgsConstructor
//public class FacStudent implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "fac_id", nullable = false)
//    private Long facId;
//
//    @Column(name = "student_id", nullable = false)
//    private Long studentId;
//
//    @Column(name = "from_date", nullable = false)
//    private LocalDate fromDate;
//
//    @Column(name = "to_date")
//    private LocalDate toDate;
//
//    @ManyToOne(targetEntity = Faculty.class)
//    private Faculty faculty;
//
//    @ManyToOne(targetEntity = Student.class)
//    private Student student;
//
//    public FacStudent(Long facId, Long studentId, LocalDate fromDate, LocalDate toDate) {
//        this.facId = facId;
//        this.studentId = studentId;
//        this.fromDate = fromDate;
//        this.toDate = toDate;
//    }
//
//}
