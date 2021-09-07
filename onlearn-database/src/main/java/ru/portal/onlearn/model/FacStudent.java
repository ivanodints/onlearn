package ru.portal.onlearn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "fac_student")
@SecondaryTables(value = {
        @SecondaryTable(name = "faculty",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "fac_id", referencedColumnName = "id")),
        @SecondaryTable(name = "student",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "student_id", referencedColumnName = "id"))})
public class FacStudent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fac_id", nullable = false)
    private Long facId;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    public FacStudent() {
    }

    public FacStudent(Long facId, Long studentId, LocalDate fromDate, LocalDate toDate) {
        this.facId = facId;
        this.studentId = studentId;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFacId() {
        return facId;
    }

    public void setFacId(Long facId) {
        this.facId = facId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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
}
