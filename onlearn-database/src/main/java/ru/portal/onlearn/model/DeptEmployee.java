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
//@Table(name = "dept_employee")
//@SecondaryTables(value = {
//        @SecondaryTable(name = "departments",
//                pkJoinColumns = @PrimaryKeyJoinColumn(name = "dept_id", referencedColumnName = "id")),
//        @SecondaryTable(name = "employee",
//                pkJoinColumns = @PrimaryKeyJoinColumn(name = "empl_id", referencedColumnName = "id"))})
//@Getter
//@Setter
//@NoArgsConstructor
//public class DeptEmployee implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "dept_id", nullable = false)
//    private Long deptId;
//
//    @Column(name = "empl_id", nullable =  false)
//    private Long emplId;
//
//    @Column(name = "from_date", nullable = false)
//    private LocalDate fromDate;
//
//    @Column(name = "to_date")
//    private LocalDate toDate;
//
//    @ManyToOne(targetEntity = Departments.class)
//    private Departments departments;
//
//    @ManyToOne(targetEntity = Employee.class)
//    private Employee employee;
//
//
//    public DeptEmployee(Long deptId, Long emplId, LocalDate fromDate, LocalDate toDate) {
//        this.deptId = deptId;
//        this.emplId = emplId;
//        this.fromDate = fromDate;
//        this.toDate = toDate;
//    }
//
//}
