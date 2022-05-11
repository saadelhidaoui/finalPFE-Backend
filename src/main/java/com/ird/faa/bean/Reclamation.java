package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "reclamation")
public class Reclamation    implements Archivable  {

@Id
    @SequenceGenerator(name="reclamation_seq",sequenceName="reclamation_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="reclamation_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String libelle;
            @Lob
            @Column(columnDefinition="TEXT")
            private String description;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateReclamation ;
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
    private Adherent adherent ;
    @ManyToOne
    private EtatReclamation etatReclamation ;

                @OneToMany(mappedBy = "reclamation")
            private List<PieceJointeReclamation> pieceJointeReclamations ;

public Reclamation(){
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
            public String getLibelle(){
            return this.libelle;
            }
            public void setLibelle(String libelle){
            this.libelle = libelle;
            }
            public String getDescription(){
            return this.description;
            }
            public void setDescription(String description){
            this.description = description;
            }
            public Adherent getAdherent(){
            return this.adherent;
            }
            public void setAdherent(Adherent adherent){
            this.adherent = adherent;
            }
            public EtatReclamation getEtatReclamation(){
            return this.etatReclamation;
            }
            public void setEtatReclamation(EtatReclamation etatReclamation){
            this.etatReclamation = etatReclamation;
            }
            public Date getDateReclamation(){
            return this.dateReclamation;
            }
            public void setDateReclamation(Date dateReclamation){
            this.dateReclamation = dateReclamation;
            }
            public List<PieceJointeReclamation> getPieceJointeReclamations(){
            return this.pieceJointeReclamations;
            }
            public void setPieceJointeReclamations(List<PieceJointeReclamation> pieceJointeReclamations){
            this.pieceJointeReclamations = pieceJointeReclamations;
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
        Reclamation reclamation = (Reclamation) o;
        return id != null && id.equals(reclamation.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

