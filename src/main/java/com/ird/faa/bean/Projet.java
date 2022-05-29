package com.ird.faa.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "projet")
public class Projet implements Archivable {

    @Id
    @SequenceGenerator(name = "projet_seq", sequenceName = "projet_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projet_seq")
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

    @ManyToOne
    private EtatProjet etatProjet;

    @OneToMany(mappedBy = "projet")
    private List<PieceJointeProjet> pieceJointeProjets;


    public Projet() {
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

    public EtatProjet getEtatProjet() {
        return this.etatProjet;
    }

    public void setEtatProjet(EtatProjet etatProjet) {
        this.etatProjet = etatProjet;
    }

    public String getPv() {
        return this.pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    public List<PieceJointeProjet> getPieceJointeProjets() {
        return this.pieceJointeProjets;
    }

    public void setPieceJointeProjets(List<PieceJointeProjet> pieceJointeProjets) {
        this.pieceJointeProjets = pieceJointeProjets;
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
        Projet projet = (Projet) o;
        return id != null && id.equals(projet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

