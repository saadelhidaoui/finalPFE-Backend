package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "enfant")
public class Enfant    implements Archivable  {

@Id
    @SequenceGenerator(name="enfant_seq",sequenceName="enfant_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="enfant_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String nom;
            @Column(length = 500)
            private String prenom;
            private Long age ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateNaissance ;
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
    private Qualite qualite ;
    @ManyToOne
    private Adherent adherent ;


public Enfant(){
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
            public String getNom(){
            return this.nom;
            }
            public void setNom(String nom){
            this.nom = nom;
            }
            public String getPrenom(){
            return this.prenom;
            }
            public void setPrenom(String prenom){
            this.prenom = prenom;
            }
            public Long getAge(){
            return this.age;
            }
            public void setAge(Long age){
            this.age = age;
            }
            public Date getDateNaissance(){
            return this.dateNaissance;
            }
            public void setDateNaissance(Date dateNaissance){
            this.dateNaissance = dateNaissance;
            }
            public Qualite getQualite(){
            return this.qualite;
            }
            public void setQualite(Qualite qualite){
            this.qualite = qualite;
            }
            public Adherent getAdherent(){
            return this.adherent;
            }
            public void setAdherent(Adherent adherent){
            this.adherent = adherent;
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
        Enfant enfant = (Enfant) o;
        return id != null && id.equals(enfant.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

