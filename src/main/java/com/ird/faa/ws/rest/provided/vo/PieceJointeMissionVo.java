package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class PieceJointeMissionVo {

    private String id ;
    private String path ;
    private String dateAjout ;
    private String libelle ;
    private Boolean archive ;
    private String dateArchivage ;
    private String dateCreation ;
    private Boolean admin ;
    private Boolean visible ;
    private String username ;


            private String dateAjoutMax ;
            private String dateAjoutMin ;
            private String dateArchivageMax ;
            private String dateArchivageMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;

        private MissionVo missionVo ;


    public PieceJointeMissionVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getPath(){
        return this.path;
        }

        public void setPath(String path){
        this.path = path;
        }
        public String getDateAjout(){
        return this.dateAjout;
        }

        public void setDateAjout(String dateAjout){
        this.dateAjout = dateAjout;
        }
        public String getLibelle(){
        return this.libelle;
        }

        public void setLibelle(String libelle){
        this.libelle = libelle;
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


            public String getDateAjoutMax(){
            return this.dateAjoutMax;
            }

            public String getDateAjoutMin(){
            return this.dateAjoutMin;
            }

            public void setDateAjoutMax(String dateAjoutMax){
            this.dateAjoutMax = dateAjoutMax;
            }

            public void setDateAjoutMin(String dateAjoutMin){
            this.dateAjoutMin = dateAjoutMin;
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


        public MissionVo getMissionVo(){
        return this.missionVo;
        }

        public void setMissionVo(MissionVo missionVo){
        this.missionVo = missionVo;
        }


            }
