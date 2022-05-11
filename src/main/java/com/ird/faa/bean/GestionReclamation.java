package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "gestion_reclamation")
public class GestionReclamation   {

@Id
    @SequenceGenerator(name="gestion_reclamation_seq",sequenceName="gestion_reclamation_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="gestion_reclamation_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateTraitement ;

    @ManyToOne
    private Moderateur moderateur ;
    @ManyToOne
    private Reclamation reclamation ;


public GestionReclamation(){
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
            public Moderateur getModerateur(){
            return this.moderateur;
            }
            public void setModerateur(Moderateur moderateur){
            this.moderateur = moderateur;
            }
            public Reclamation getReclamation(){
            return this.reclamation;
            }
            public void setReclamation(Reclamation reclamation){
            this.reclamation = reclamation;
            }
            public Date getDateTraitement(){
            return this.dateTraitement;
            }
            public void setDateTraitement(Date dateTraitement){
            this.dateTraitement = dateTraitement;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GestionReclamation gestionReclamation = (GestionReclamation) o;
        return id != null && id.equals(gestionReclamation.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

