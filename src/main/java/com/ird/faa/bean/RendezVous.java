package com.ird.faa.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "rendez_vous")
public class RendezVous implements Archivable {

    @Id
    @SequenceGenerator(name = "rendez_vous_seq", sequenceName = "rendez_vous_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rendez_vous_seq")
    private Long id;

    @Column(length = 500)
    private String reference;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String pv;
    @Column(columnDefinition = "boolean default false")
    private Boolean archive = false;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateArchivage;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Column(columnDefinition = "boolean default false")
    private Boolean admin = false;
    @Column(columnDefinition = "boolean default false")
    private Boolean visible = false;
    @Column(length = 500)
    private String username;


    @OneToMany(mappedBy = "rendezVous")
    private List<PieceJointeRendezVous> pieceJointeRendezVouss;

    public RendezVous() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return this.dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getPv() {
        return this.pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    public List<PieceJointeRendezVous> getPieceJointeRendezVouss() {
        return this.pieceJointeRendezVouss;
    }

    public void setPieceJointeRendezVouss(List<PieceJointeRendezVous> pieceJointeRendezVouss) {
        this.pieceJointeRendezVouss = pieceJointeRendezVouss;
    }

    public Boolean getArchive() {
        return this.archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public Date getDateArchivage() {
        return this.dateArchivage;
    }

    public void setDateArchivage(Date dateArchivage) {
        this.dateArchivage = dateArchivage;
    }

    public Date getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getVisible() {
        return this.visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendezVous rendezVous = (RendezVous) o;
        return id != null && id.equals(rendezVous.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

