package ru.portal.onlearn.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sphere_fac")
@SecondaryTables(value = {
        @SecondaryTable(name = "sphere_of_activities",
                    pkJoinColumns = @PrimaryKeyJoinColumn(name = "sphere_id", referencedColumnName = "id")),
        @SecondaryTable(name = "faculty",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "fac_id", referencedColumnName = "id"))})
public class SphereFac implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sphere_id", nullable = false)
    private Long sphereId;

    @Column(name = "fac_id", nullable =  false)
    private Long facId;

    public SphereFac() {
    }

    public SphereFac(Long id, Long sphereId, Long facId) {
        this.id = id;
        this.sphereId = sphereId;
        this.facId = facId;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getSphereId() { return sphereId; }

    public void setSphereId(Long sphereId) { this.sphereId = sphereId; }

    public Long getFacId() { return facId; }

    public void setFacId(Long facId) { this.facId = facId; }
}
