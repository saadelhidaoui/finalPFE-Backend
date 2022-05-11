package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;
    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class MissionVo {

    private String id ;
    private String reference ;
    private String dateDebut ;
    private String dateFin ;
    private String moyenDeTransport ;
    private String distance ;
    private String pv ;
    private Boolean archive ;
    private String dateArchivage ;
    private String dateCreation ;
    private Boolean admin ;
    private Boolean visible ;
    private String username ;


            private String dateDebutMax ;
            private String dateDebutMin ;
            private String dateFinMax ;
            private String dateFinMin ;
            private String distanceMax ;
            private String distanceMin ;
            private String pieceJointeMissionsMax ;
            private String pieceJointeMissionsMin ;
            private String dateArchivageMax ;
            private String dateArchivageMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;

        private VilleVo villeDestinationVo ;
        private ModerateurVo moderateurVo ;

    private List<PieceJointeMissionVo> pieceJointeMissionsVo ;

    public MissionVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getReference(){
        return this.reference;
        }

        public void setReference(String reference){
        this.reference = reference;
        }
        public String getDateDebut(){
        return this.dateDebut;
        }

        public void setDateDebut(String dateDebut){
        this.dateDebut = dateDebut;
        }
        public String getDateFin(){
        return this.dateFin;
        }

        public void setDateFin(String dateFin){
        this.dateFin = dateFin;
        }
        public String getMoyenDeTransport(){
        return this.moyenDeTransport;
        }

        public void setMoyenDeTransport(String moyenDeTransport){
        this.moyenDeTransport = moyenDeTransport;
        }
        public String getDistance(){
        return this.distance;
        }

        public void setDistance(String distance){
        this.distance = distance;
        }
        public String getPv(){
        return this.pv;
        }

        public void setPv(String pv){
        this.pv = pv;
        }

        public Boolean getArchive(){
        return this.archive;
        }

        public void setArchive(Boolean archive){
        this.archive = archive;
        }
        public String getDateArchivage(){
        return this.dateArchivage;
        }

        public void setDateArchivage(String dateArchivage){
        this.dateArchivage = dateArchivage;
        }
        public String getDateCreation(){
        return this.dateCreation;
        }

        public void setDateCreation(String dateCreation){
        this.dateCreation = dateCreation;
        }
        public Boolean getAdmin(){
        return this.admin;
        }

        public void setAdmin(Boolean admin){
        this.admin = admin;
        }
        public Boolean getVisible(){
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


            public String getDateDebutMax(){
            return this.dateDebutMax;
            }

            public String getDateDebutMin(){
            return this.dateDebutMin;
            }

            public void setDateDebutMax(String dateDebutMax){
            this.dateDebutMax = dateDebutMax;
            }

            public void setDateDebutMin(String dateDebutMin){
            this.dateDebutMin = dateDebutMin;
            }

            public String getDateFinMax(){
            return this.dateFinMax;
            }

            public String getDateFinMin(){
            return this.dateFinMin;
            }

            public void setDateFinMax(String dateFinMax){
            this.dateFinMax = dateFinMax;
            }

            public void setDateFinMin(String dateFinMin){
            this.dateFinMin = dateFinMin;
            }

            public String getDistanceMax(){
            return this.distanceMax;
            }

            public String getDistanceMin(){
            return this.distanceMin;
            }

            public void setDistanceMax(String distanceMax){
            this.distanceMax = distanceMax;
            }

            public void setDistanceMin(String distanceMin){
            this.distanceMin = distanceMin;
            }

            public String getPieceJointeMissionsMax(){
            return this.pieceJointeMissionsMax;
            }

            public String getPieceJointeMissionsMin(){
            return this.pieceJointeMissionsMin;
            }

            public void setPieceJointeMissionsMax(String pieceJointeMissionsMax){
            this.pieceJointeMissionsMax = pieceJointeMissionsMax;
            }

            public void setPieceJointeMissionsMin(String pieceJointeMissionsMin){
            this.pieceJointeMissionsMin = pieceJointeMissionsMin;
            }

            public String getDateArchivageMax(){
            return this.dateArchivageMax;
            }

            public String getDateArchivageMin(){
            return this.dateArchivageMin;
            }

            public void setDateArchivageMax(String dateArchivageMax){
            this.dateArchivageMax = dateArchivageMax;
            }

            public void setDateArchivageMin(String dateArchivageMin){
            this.dateArchivageMin = dateArchivageMin;
            }

            public String getDateCreationMax(){
            return this.dateCreationMax;
            }

            public String getDateCreationMin(){
            return this.dateCreationMin;
            }

            public void setDateCreationMax(String dateCreationMax){
            this.dateCreationMax = dateCreationMax;
            }

            public void setDateCreationMin(String dateCreationMin){
            this.dateCreationMin = dateCreationMin;
            }


        public VilleVo getVilleDestinationVo(){
        return this.villeDestinationVo;
        }

        public void setVilleDestinationVo(VilleVo villeDestinationVo){
        this.villeDestinationVo = villeDestinationVo;
        }
        public ModerateurVo getModerateurVo(){
        return this.moderateurVo;
        }

        public void setModerateurVo(ModerateurVo moderateurVo){
        this.moderateurVo = moderateurVo;
        }


        public List<PieceJointeMissionVo> getPieceJointeMissionsVo(){
        return this.pieceJointeMissionsVo;
        }

        public void setPieceJointeMissionsVo(List<PieceJointeMissionVo> pieceJointeMissionsVo){
            this.pieceJointeMissionsVo = pieceJointeMissionsVo;
            }

            }
