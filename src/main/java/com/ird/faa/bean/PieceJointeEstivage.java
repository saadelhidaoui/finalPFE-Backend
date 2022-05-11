package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "piece_jointe_estivage")
public class PieceJointeEstivage    implements Archivable  {

@Id
    @SequenceGenerator(name="piece_jointe_estivage_seq",sequenceName="piece_jointe_estivage_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="piece_jointe_estivage_seq")
private Long id;

            @Column(length = 500)
            private String path;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateAjout ;
            @Column(length = 500)
            private String libelle;
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
    private Estivage estivage ;
    @ManyToOne
    private DemandeEstivage demandeEstivage;


    public PieceJointeEstivage(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getPath(){
            return this.path;
            }
            public void setPath(String path){
            this.path = path;
            }
            public Estivage getEstivage(){
            return this.estivage;
            }
            public void setEstivage(Estivage estivage){
            this.estivage = estivage;
            }
            public Date getDateAjout(){
            return this.dateAjout;
            }
            public void setDateAjout(Date dateAjout){
            this.dateAjout = dateAjout;
            }
            public String getLibelle(){
            return this.libelle;
            }
            public void setLibelle(String libelle){
            this.libelle = libelle;
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
        PieceJointeEstivage pieceJointeEstivage = (PieceJointeEstivage) o;
        return id != null && id.equals(pieceJointeEstivage.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

    public void setDemandeEstivage(DemandeEstivage demandeEstivage) {
        this.demandeEstivage = demandeEstivage;
    }
}

