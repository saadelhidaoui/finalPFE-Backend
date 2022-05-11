package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;
    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class ProjetVo {

    private String id ;
    private String reference ;
    private String description ;
    private String dateDebut ;
    private String pv ;
    private Boolean archive ;
    private String dateArchivage ;
    private String dateCreation ;
    private Boolean admin ;
    private Boolean visible ;
    private String username ;


            private String dateDebutMax ;
            private String dateDebutMin ;
            private String pieceJointeProjetsMax ;
            private String pieceJointeProjetsMin ;
            private String dateArchivageMax ;
            private String dateArchivageMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;

        private EtatProjetVo etatProjetVo ;

    private List<PieceJointeProjetVo> pieceJointeProjetsVo ;

    public ProjetVo(){
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
        public String getDescription(){
        return this.description;
        }

        public void setDescription(String description){
        this.description = description;
        }
        public String getDateDebut(){
        return this.dateDebut;
        }

        public void setDateDebut(String dateDebut){
        this.dateDebut = dateDebut;
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

            public String getPieceJointeProjetsMax(){
            return this.pieceJointeProjetsMax;
            }

            public String getPieceJointeProjetsMin(){
            return this.pieceJointeProjetsMin;
            }

            public void setPieceJointeProjetsMax(String pieceJointeProjetsMax){
            this.pieceJointeProjetsMax = pieceJointeProjetsMax;
            }

            public void setPieceJointeProjetsMin(String pieceJointeProjetsMin){
            this.pieceJointeProjetsMin = pieceJointeProjetsMin;
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


        public EtatProjetVo getEtatProjetVo(){
        return this.etatProjetVo;
        }

        public void setEtatProjetVo(EtatProjetVo etatProjetVo){
        this.etatProjetVo = etatProjetVo;
        }


        public List<PieceJointeProjetVo> getPieceJointeProjetsVo(){
        return this.pieceJointeProjetsVo;
        }

        public void setPieceJointeProjetsVo(List<PieceJointeProjetVo> pieceJointeProjetsVo){
            this.pieceJointeProjetsVo = pieceJointeProjetsVo;
            }

            }
