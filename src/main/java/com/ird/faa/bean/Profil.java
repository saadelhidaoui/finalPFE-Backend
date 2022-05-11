package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "profil")
public class Profil   {

@Id
    @SequenceGenerator(name="profil_seq",sequenceName="profil_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="profil_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String libelle;

    @ManyToOne
    private Grade grade ;
    @ManyToOne
    private Echelle echelle ;


public Profil(){
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
            public Grade getGrade(){
            return this.grade;
            }
            public void setGrade(Grade grade){
            this.grade = grade;
            }
            public Echelle getEchelle(){
            return this.echelle;
            }
            public void setEchelle(Echelle echelle){
            this.echelle = echelle;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profil profil = (Profil) o;
        return id != null && id.equals(profil.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

