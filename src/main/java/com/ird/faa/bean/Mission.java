package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "mission")
public class Mission    implements Archivable  {

@Id
    @SequenceGenerator(name="mission_seq",sequenceName="mission_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="mission_seq")
private Long id;

            @Column(length = 500)
            private String reference;

            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateDebut ;

            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateFin ;

            @Column(length = 500)
            private String moyenDeTransport;
            private Long distance ;

            @Lob
            @Column(columnDefinition="TEXT")
            private String pv;

            @Column(columnDefinition = "boolean default false")
            private Boolean archive = false;

            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateArchivage ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateCreation ;
            @Column(columnDefinition = "boolean default false")
            private Boolean admin = false;
            @Column(columnDefinition = "boolean default false")
            private Boolean visible = false;
            @Column(length = 500)
            private String username;

    @ManyToOne
    private Ville ville ;
    @ManyToOne
    private Moderateur moderateur ;

                @OneToMany(mappedBy = "mission")
            private List<PieceJointeMission> pieceJointeMissions ;

public Mission(){
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
            public Date getDateDebut(){
            return this.dateDebut;
            }
            public void setDateDebut(Date dateDebut){
            this.dateDebut = dateDebut;
            }
            public Date getDateFin(){
            return this.dateFin;
            }
            public void setDateFin(Date dateFin){
            this.dateFin = dateFin;
            }
            public Ville getVilleDestination(){
            return this.ville;
            }
            public void setVilleDestination(Ville ville){
            this.ville = ville;
            }
            public String getMoyenDeTransport(){
            return this.moyenDeTransport;
            }
            public void setMoyenDeTransport(String moyenDeTransport){
            this.moyenDeTransport = moyenDeTransport;
            }
            public Long getDistance(){
            return this.distance;
            }
            public void setDistance(Long distance){
            this.distance = distance;
            }
            public Moderateur getModerateur(){
            return this.moderateur;
            }
            public void setModerateur(Moderateur moderateur){
            this.moderateur = moderateur;
            }
            public String getPv(){
            return this.pv;
            }
            public void setPv(String pv){
            this.pv = pv;
            }
            public List<PieceJointeMission> getPieceJointeMissions(){
            return this.pieceJointeMissions;
            }
            public void setPieceJointeMissions(List<PieceJointeMission> pieceJointeMissions){
            this.pieceJointeMissions = pieceJointeMissions;
            }
        public Boolean  getArchive(){
        return this.archive;
        }
        public void setArchive(Boolean archive){
        this.archive = archive;
        }
            public Date getDateArchivage(){
            return this.dateArchivage;
            }
            public void setDateArchivage(Date dateArchivage){
            this.dateArchivage = dateArchivage;
            }
            public Date getDateCreation(){
            return this.dateCreation;
            }
            public void setDateCreation(Date dateCreation){
            this.dateCreation = dateCreation;
            }
        public Boolean  getAdmin(){
        return this.admin;
        }
        public void setAdmin(Boolean admin){
        this.admin = admin;
        }
        public Boolean  getVisible(){
        return this.visible;
        }
        public void setVisible(Boolean visible){
        this.visible = visible;
        }
            public String getUsername(){
            return this.username;
            }
            public void setUsername(String username){
            this.username = username;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mission mission = (Mission) o;
        return id != null && id.equals(mission.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

