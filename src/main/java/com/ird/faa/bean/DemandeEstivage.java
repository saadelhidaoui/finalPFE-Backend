package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "demande_estivage")
public class DemandeEstivage   {

@Id
    @SequenceGenerator(name="demande_estivage_seq",sequenceName="demande_estivage_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="demande_estivage_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateDebutEstivage ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateFinEstivage ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateTraitement ;

    @ManyToOne
    private DemandeEstivageCentre demandeEstivageCentre ;
    @ManyToOne
    private Adherent adherent ;
    @ManyToOne
    private EtatDemandeEstivage etatDemandeEstivage ;
    @ManyToOne
    private EstivageCentreEstivage estivageCentreEstivage ;

                @OneToMany
            private List<PieceJointeEstivage> pieceJointeEstivages ;

public DemandeEstivage(){
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
            public DemandeEstivageCentre getDemandeEstivageCentre(){
            return this.demandeEstivageCentre;
            }
            public void setDemandeEstivageCentre(DemandeEstivageCentre demandeEstivageCentre){
            this.demandeEstivageCentre = demandeEstivageCentre;
            }
            public Date getDateDebutEstivage(){
            return this.dateDebutEstivage;
            }
            public void setDateDebutEstivage(Date dateDebutEstivage){
            this.dateDebutEstivage = dateDebutEstivage;
            }
            public Date getDateFinEstivage(){
            return this.dateFinEstivage;
            }
            public void setDateFinEstivage(Date dateFinEstivage){
            this.dateFinEstivage = dateFinEstivage;
            }
            public Adherent getAdherent(){
            return this.adherent;
            }
            public void setAdherent(Adherent adherent){
            this.adherent = adherent;
            }
            public EtatDemandeEstivage getEtatDemandeEstivage(){
            return this.etatDemandeEstivage;
            }
            public void setEtatDemandeEstivage(EtatDemandeEstivage etatDemandeEstivage){
            this.etatDemandeEstivage = etatDemandeEstivage;
            }
            public Date getDateTraitement(){
            return this.dateTraitement;
            }
            public void setDateTraitement(Date dateTraitement){
            this.dateTraitement = dateTraitement;
            }
            public EstivageCentreEstivage getEstivageCentreEstivage(){
            return this.estivageCentreEstivage;
            }
            public void setEstivageCentreEstivage(EstivageCentreEstivage estivageCentreEstivage){
            this.estivageCentreEstivage = estivageCentreEstivage;
            }
            public List<PieceJointeEstivage> getPieceJointeEstivages(){
            return this.pieceJointeEstivages;
            }
            public void setPieceJointeEstivages(List<PieceJointeEstivage> pieceJointeEstivages){
            this.pieceJointeEstivages = pieceJointeEstivages;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemandeEstivage demandeEstivage = (DemandeEstivage) o;
        return id != null && id.equals(demandeEstivage.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

