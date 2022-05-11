package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "centre_estivage")
public class CentreEstivage   {

@Id
    @SequenceGenerator(name="centre_estivage_seq",sequenceName="centre_estivage_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="centre_estivage_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            private Long capacite ;
            @Column(length = 500)
            private String libelle;
            @Column(columnDefinition = "boolean default false")
                 private Boolean vip = false;

            @ManyToOne
            private Ville ville ;


            public CentreEstivage(){
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
            public Long getCapacite(){
            return this.capacite;
            }
            public void setCapacite(Long capacite){
            this.capacite = capacite;
            }
            public String getLibelle(){
            return this.libelle;
            }
            public void setLibelle(String libelle){
            this.libelle = libelle;
            }
            public Ville getVille(){
            return this.ville;
            }
            public void setVille(Ville ville){
            this.ville = ville;
            }
            public Boolean  getVip(){
        return this.vip;
        }
            public void setVip(Boolean vip){
        this.vip = vip;
        }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                CentreEstivage centreEstivage = (CentreEstivage) o;
                return id != null && id.equals(centreEstivage.id);
            }

            @Override
            public int hashCode() {
        return Objects.hash(id);
        }

}

