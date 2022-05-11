package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "estivage")
public class Estivage    implements Archivable  {

@Id
    @SequenceGenerator(name="estivage_seq",sequenceName="estivage_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="estivage_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String numArrivee;
            @Column(columnDefinition = "boolean default false")
                 private Boolean envoye = false;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateEnvoi ;
            @Column(length = 500)
            private String notes;
            @Column(length = 500)
            private String chargeCas;
            @Column(columnDefinition = "boolean default false")
                 private Boolean resultat = false;
            @Column(columnDefinition = "boolean default false")
                 private Boolean archive = false;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateArchivage ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateCreation ;
            @Column(columnDefinition = "boolean default false")
                 private Boolean admin = false;
            @Column(columnDefinition = "boolean default false")
                 private Boolean visible = false;
            @Column(length = 500)
            private String username;

    @ManyToOne
    private CentreEstivage centreEstivage ;
    @ManyToOne
    private NiveauImportance niveauImportance ;


public Estivage(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getReference(){
            return this.reference;
            }
            public void setReference(String reference){
            this.reference = reference;
            }
            public CentreEstivage getCentreEstivage(){
            return this.centreEstivage;
            }
            public void setCentreEstivage(CentreEstivage centreEstivage){
            this.centreEstivage = centreEstivage;
            }
            public String getNumArrivee(){
            return this.numArrivee;
            }
            public void setNumArrivee(String numArrivee){
            this.numArrivee = numArrivee;
            }
        public Boolean  getEnvoye(){
        return this.envoye;
        }
        public void setEnvoye(Boolean envoye){
        this.envoye = envoye;
        }
            public Date getDateEnvoi(){
            return this.dateEnvoi;
            }
            public void setDateEnvoi(Date dateEnvoi){
            this.dateEnvoi = dateEnvoi;
            }
            public String getNotes(){
            return this.notes;
            }
            public void setNotes(String notes){
            this.notes = notes;
            }
            public String getChargeCas(){
            return this.chargeCas;
            }
            public void setChargeCas(String chargeCas){
            this.chargeCas = chargeCas;
            }
            public NiveauImportance getNiveauImportance(){
            return this.niveauImportance;
            }
            public void setNiveauImportance(NiveauImportance niveauImportance){
            this.niveauImportance = niveauImportance;
            }
        public Boolean  getResultat(){
        return this.resultat;
        }
        public void setResultat(Boolean resultat){
        this.resultat = resultat;
        }
        public Boolean  getArchive(){
        return this.archive;
        }
        public void setArchive(Boolean archive){
        this.archive = archive;
        }
            public Date getDateArchivage(){
            return this.dateArchivage;
            }
            public void setDateArchivage(Date dateArchivage){
            this.dateArchivage = dateArchivage;
            }
            public Date getDateCreation(){
            return this.dateCreation;
            }
            public void setDateCreation(Date dateCreation){
            this.dateCreation = dateCreation;
            }
        public Boolean  getAdmin(){
        return this.admin;
        }
        public void setAdmin(Boolean admin){
        this.admin = admin;
        }
        public Boolean  getVisible(){
        return this.visible;
        }
        public void setVisible(Boolean visible){
        this.visible = visible;
        }
            public String getUsername(){
            return this.username;
            }
            public void setUsername(String username){
            this.username = username;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estivage estivage = (Estivage) o;
        return id != null && id.equals(estivage.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

