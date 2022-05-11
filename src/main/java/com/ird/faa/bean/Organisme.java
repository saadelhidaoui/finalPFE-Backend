package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "organisme")
public class Organisme   {

@Id
    @SequenceGenerator(name="organisme_seq",sequenceName="organisme_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="organisme_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String libelle;
            @Column(length = 500)
            private String telephone;
            @Column(length = 500)
            private String email;
            @Column(length = 500)
            private String fix;
            @Column(length = 500)
            private String fax;

    @ManyToOne
    private Ville ville ;


public Organisme(){
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
            public String getTelephone(){
            return this.telephone;
            }
            public void setTelephone(String telephone){
            this.telephone = telephone;
            }
            public String getEmail(){
            return this.email;
            }
            public void setEmail(String email){
            this.email = email;
            }
            public String getFix(){
            return this.fix;
            }
            public void setFix(String fix){
            this.fix = fix;
            }
            public String getFax(){
            return this.fax;
            }
            public void setFax(String fax){
            this.fax = fax;
            }
            public Ville getVille(){
            return this.ville;
            }
            public void setVille(Ville ville){
            this.ville = ville;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organisme organisme = (Organisme) o;
        return id != null && id.equals(organisme.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

