package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "impression_carte")
public class ImpressionCarte   {

@Id
    @SequenceGenerator(name="impression_carte_seq",sequenceName="impression_carte_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="impression_carte_seq")
private Long id;

            @Column(length = 500)
            private String aff;
            @Column(length = 500)
            private String qualite;
            @Column(length = 500)
            private String nom;
            @Column(length = 500)
            private String prenom;
            @Column(length = 500)
            private String nomprenomar;
            @Column(length = 500)
            private String nomAr;
            @Column(length = 500)
            private String prenomAr;
            @Column(length = 500)
            private String cinn;
            @Column(length = 500)
            private String cin;
            @Column(length = 500)
            private String pprr;
            @Column(length = 500)
            private String ppr;
            @Column(length = 500)
            private String naissance;
            @JsonFormat(pattern="MM-dd-yyyy")
            @Temporal(TemporalType.DATE)
            private Date dateNaissance ;
            @Column(length = 500)
            private String photo;
            @Column(length = 500)
            private String cinnConjoint;
            @Column(length = 500)
            private String cinConjoint;
            @Column(length = 500)
            private String adherent;
            @Column(length = 500)
            private String nomAdherent;
            @Column(length = 500)
            private String prenomAdherent;
            @Column(length = 500)
            private String cinnAdherent;
            @Column(length = 500)
            private String cinAdherent;
            @Column(length = 500)
            private String pprrAdherent;
            @Column(length = 500)
            private String pprAdherent;
            @Column(length = 500)
            private String versocarte;
            @Column(length = 500)
            private String aff1;
            @Column(length = 500)
            private String aff2;
            @Column(length = 500)
            private String nval;
            @Column(length = 500)
            private String dtNaissance;


    public String getDtNaissance() {
        return dtNaissance;
    }

    public void setDtNaissance(String dtNaissance) {
        this.dtNaissance = dtNaissance;
    }

    public ImpressionCarte(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getAff(){
            return this.aff;
            }
            public void setAff(String aff){
            this.aff = aff;
            }
            public String getQualite(){
            return this.qualite;
            }
            public void setQualite(String qualite){
            this.qualite = qualite;
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
            public String getNomprenomar(){
            return this.nomprenomar;
            }
            public void setNomprenomar(String nomprenomar){
            this.nomprenomar = nomprenomar;
            }
            public String getNomAr(){
            return this.nomAr;
            }
            public void setNomAr(String nomAr){
            this.nomAr = nomAr;
            }
            public String getPrenomAr(){
            return this.prenomAr;
            }
            public void setPrenomAr(String prenomAr){
            this.prenomAr = prenomAr;
            }
            public String getCinn(){
            return this.cinn;
            }
            public void setCinn(String cinn){
            this.cinn = cinn;
            }
            public String getCin(){
            return this.cin;
            }
            public void setCin(String cin){
            this.cin = cin;
            }
            public String getPprr(){
            return this.pprr;
            }
            public void setPprr(String pprr){
            this.pprr = pprr;
            }
            public String getPpr(){
            return this.ppr;
            }
            public void setPpr(String ppr){
            this.ppr = ppr;
            }
            public String getNaissance(){
            return this.naissance;
            }
            public void setNaissance(String naissance){
            this.naissance = naissance;
            }
            public Date getDateNaissance(){
            return this.dateNaissance;
            }
            public void setDateNaissance(Date dateNaissance){
            this.dateNaissance = dateNaissance;
            }
            public String getPhoto(){
            return this.photo;
            }
            public void setPhoto(String photo){
            this.photo = photo;
            }
            public String getCinnConjoint(){
            return this.cinnConjoint;
            }
            public void setCinnConjoint(String cinnConjoint){
            this.cinnConjoint = cinnConjoint;
            }
            public String getCinConjoint(){
            return this.cinConjoint;
            }
            public void setCinConjoint(String cinConjoint){
            this.cinConjoint = cinConjoint;
            }
            public String getAdherent(){
            return this.adherent;
            }
            public void setAdherent(String adherent){
            this.adherent = adherent;
            }
            public String getNomAdherent(){
            return this.nomAdherent;
            }
            public void setNomAdherent(String nomAdherent){
            this.nomAdherent = nomAdherent;
            }
            public String getPrenomAdherent(){
            return this.prenomAdherent;
            }
            public void setPrenomAdherent(String prenomAdherent){
            this.prenomAdherent = prenomAdherent;
            }
            public String getCinnAdherent(){
            return this.cinnAdherent;
            }
            public void setCinnAdherent(String cinnAdherent){
            this.cinnAdherent = cinnAdherent;
            }
            public String getCinAdherent(){
            return this.cinAdherent;
            }
            public void setCinAdherent(String cinAdherent){
            this.cinAdherent = cinAdherent;
            }
            public String getPprrAdherent(){
            return this.pprrAdherent;
            }
            public void setPprrAdherent(String pprrAdherent){
            this.pprrAdherent = pprrAdherent;
            }
            public String getPprAdherent(){
            return this.pprAdherent;
            }
            public void setPprAdherent(String pprAdherent){
            this.pprAdherent = pprAdherent;
            }
            public String getVersocarte(){
            return this.versocarte;
            }
            public void setVersocarte(String versocarte){
            this.versocarte = versocarte;
            }
            public String getAff1(){
            return this.aff1;
            }
            public void setAff1(String aff1){
            this.aff1 = aff1;
            }
            public String getAff2(){
            return this.aff2;
            }
            public void setAff2(String aff2){
            this.aff2 = aff2;
            }
            public String getNval(){
            return this.nval;
            }
            public void setNval(String nval){
            this.nval = nval;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImpressionCarte impressionCarte = (ImpressionCarte) o;
        return id != null && id.equals(impressionCarte.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

