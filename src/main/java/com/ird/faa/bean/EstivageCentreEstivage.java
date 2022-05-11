package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "estivage_centre_estivage")
public class EstivageCentreEstivage   {

@Id
    @SequenceGenerator(name="estivage_centre_estivage_seq",sequenceName="estivage_centre_estivage_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="estivage_centre_estivage_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            private Long ordre ;

    @ManyToOne
    private CentreEstivage centreEstivage ;
    @ManyToOne
    private Estivage estivage ;


public EstivageCentreEstivage(){
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
            public Estivage getEstivage(){
            return this.estivage;
            }
            public void setEstivage(Estivage estivage){
            this.estivage = estivage;
            }
            public Long getOrdre(){
            return this.ordre;
            }
            public void setOrdre(Long ordre){
            this.ordre = ordre;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstivageCentreEstivage estivageCentreEstivage = (EstivageCentreEstivage) o;
        return id != null && id.equals(estivageCentreEstivage.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

