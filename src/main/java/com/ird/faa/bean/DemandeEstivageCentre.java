package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "demande_estivage_centre")
public class DemandeEstivageCentre   {

@Id
    @SequenceGenerator(name="demande_estivage_centre_seq",sequenceName="demande_estivage_centre_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="demande_estivage_centre_seq")
private Long id;

            @Column(length = 500)
            private String reference;

    @ManyToOne
    private DemandeEstivage demandeEstivage ;
    @ManyToOne
    private CentreEstivage centreEstivage ;


public DemandeEstivageCentre(){
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
            public DemandeEstivage getDemandeEstivage(){
            return this.demandeEstivage;
            }
            public void setDemandeEstivage(DemandeEstivage demandeEstivage){
            this.demandeEstivage = demandeEstivage;
            }
            public CentreEstivage getCentreEstivage(){
            return this.centreEstivage;
            }
            public void setCentreEstivage(CentreEstivage centreEstivage){
            this.centreEstivage = centreEstivage;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemandeEstivageCentre demandeEstivageCentre = (DemandeEstivageCentre) o;
        return id != null && id.equals(demandeEstivageCentre.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

