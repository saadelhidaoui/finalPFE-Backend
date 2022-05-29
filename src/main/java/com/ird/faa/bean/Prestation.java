package com.ird.faa.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "prestation")
public class Prestation implements Archivable {

    @Id
    @SequenceGenerator(name = "prestation_seq", sequenceName = "prestation_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prestation_seq")
    private Long id;

    @Column(length = 500)
    private String reference;
    @Column(length = 500)
    private String numArrivee;
    @Column(columnDefinition = "boolean default false")
    private Boolean envoye = false;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateEnvoi;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateTraitement;
    @Column(length = 500)
    private String chargeCas;
    @Column(columnDefinition = "boolean default false")
    private Boolean resultat = false;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String notes;
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
    private EtatPrestation etatPrestation;
    @ManyToOne
    private NiveauImportance niveauImportance;
    @ManyToOne
    private TypePrestation typePrestation;
    @ManyToOne
    private Adherent adherent;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "prestation")
    private List<PieceJointePrestation> pieceJointePrestations;

    public Prestation() {
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

    public String getNumArrivee() {
        return this.numArrivee;
    }

    public void setNumArrivee(String numArrivee) {
        this.numArrivee = numArrivee;
    }

    public Boolean getEnvoye() {
        return this.envoye;
    }

    public void setEnvoye(Boolean envoye) {
        this.envoye = envoye;
    }

    public Date getDateEnvoi() {
        return this.dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public EtatPrestation getEtatPrestation() {
        return this.etatPrestation;
    }

    public void setEtatPrestation(EtatPrestation etatPrestation) {
        this.etatPrestation = etatPrestation;
    }

    public Date getDateTraitement() {
        return this.dateTraitement;
    }

    public void setDateTraitement(Date dateTraitement) {
        this.dateTraitement = dateTraitement;
    }

    public String getChargeCas() {
        return this.chargeCas;
    }

    public void setChargeCas(String chargeCas) {
        this.chargeCas = chargeCas;
    }

    public NiveauImportance getNiveauImportance() {
        return this.niveauImportance;
    }

    public void setNiveauImportance(NiveauImportance niveauImportance) {
        this.niveauImportance = niveauImportance;
    }

    public TypePrestation getTypePrestation() {
        return this.typePrestation;
    }

    public void setTypePrestation(TypePrestation typePrestation) {
        this.typePrestation = typePrestation;
    }

    public Boolean getResultat() {
        return this.resultat;
    }

    public void setResultat(Boolean resultat) {
        this.resultat = resultat;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Adherent getAdherent() {
        return this.adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public List<PieceJointePrestation> getPieceJointePrestations() {
        return this.pieceJointePrestations;
    }

    public void setPieceJointePrestations(List<PieceJointePrestation> pieceJointePrestations) {
        this.pieceJointePrestations = pieceJointePrestations;
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
        Prestation prestation = (Prestation) o;
        return id != null && id.equals(prestation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

