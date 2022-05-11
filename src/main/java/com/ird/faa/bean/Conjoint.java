package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "conjoint")
public class Conjoint   {

@Id
    @SequenceGenerator(name="conjoint_seq",sequenceName="conjoint_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="conjoint_seq")
private Long id;

            @Column(length = 500)
            private String cin;
            @Column(length = 500)
            private String nom;
            @Column(length = 500)
            private String prenom;
            @Column(length = 500)
            private String origin;
            @Column(length = 500)
            private String email;
            @Column(length = 500)
            private String telephone;

    @ManyToOne
    private Qualite qualite ;
    @ManyToOne
    private Adherent adherent ;


public Conjoint(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getCin(){
            return this.cin;
            }
            public void setCin(String cin){
            this.cin = cin;
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
            public String getOrigin(){
            return this.origin;
            }
            public void setOrigin(String origin){
            this.origin = origin;
            }
            public String getEmail(){
            return this.email;
            }
            public void setEmail(String email){
            this.email = email;
            }
            public String getTelephone(){
            return this.telephone;
            }
            public void setTelephone(String telephone){
            this.telephone = telephone;
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

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conjoint conjoint = (Conjoint) o;
        return id != null && id.equals(conjoint.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

