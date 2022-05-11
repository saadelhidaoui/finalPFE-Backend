package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "type_prestation")
public class TypePrestation   {

@Id
    @SequenceGenerator(name="type_prestation_seq",sequenceName="type_prestation_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="type_prestation_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String libelle;



public TypePrestation(){
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

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypePrestation typePrestation = (TypePrestation) o;
        return id != null && id.equals(typePrestation.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

