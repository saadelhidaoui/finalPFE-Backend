package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "tache")
public class Tache   {

@Id
    @SequenceGenerator(name="tache_seq",sequenceName="tache_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="tache_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateTache ;
            @Column(length = 500)
            private String description;

    @ManyToOne
    private EtatTache etatTache ;
    @ManyToOne
    private Moderateur moderateur ;


public Tache(){
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
            public Date getDateTache(){
            return this.dateTache;
            }
            public void setDateTache(Date dateTache){
            this.dateTache = dateTache;
            }
            public String getDescription(){
            return this.description;
            }
            public void setDescription(String description){
            this.description = description;
            }
            public EtatTache getEtatTache(){
            return this.etatTache;
            }
            public void setEtatTache(EtatTache etatTache){
            this.etatTache = etatTache;
            }
            public Moderateur getModerateur(){
            return this.moderateur;
            }
            public void setModerateur(Moderateur moderateur){
            this.moderateur = moderateur;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tache tache = (Tache) o;
        return id != null && id.equals(tache.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

