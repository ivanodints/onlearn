package ru.portal.onlearn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "dept_employee")
@SecondaryTables(value = {
        @SecondaryTable(name = "departments",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "dept_id", referencedColumnName = "id")),
        @SecondaryTable(name = "employee",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "empl_id", referencedColumnName = "id"))})
public class DeptEmployee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dept_id", nullable = false)
    private Long deptId;

    @Column(name = "empl_id", nullable =  false)
    private Long emplId;

    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @ManyToOne(targetEntity = Departments.class)
    private Departments departments;

    @ManyToOne(targetEntity = Employee.class)
    private Employee employee;

    public DeptEmployee() {
    }

    public DeptEmployee(Long deptId, Long emplId, LocalDate fromDate, LocalDate toDate) {
        this.deptId = deptId;
        this.emplId = emplId;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getEmplId() {
        return emplId;
    }

    public void setEmplId(Long emplId) {
        this.emplId = emplId;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Departments getDepartments() { return departments; }

    public void setDepartments(Departments departments) { this.departments = departments; }

    public Employee getEmployee() { return employee; }

    public void setEmployee(Employee employee) { this.employee = employee; }
}
