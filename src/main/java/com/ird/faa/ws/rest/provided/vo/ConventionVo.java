package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;

    import com.ird.faa.bean.PieceJointeConvention;

public class ConventionVo {

    private String id ;
    private String reference ;
    private String libelle ;
    private String description ;
    private String dateDebut ;
    private Boolean archive ;
    private String dateArchivage ;
    private String dateCreation ;
    private Boolean admin ;
    private Boolean visible ;
    private String username ;


            private String dateDebutMax ;
            private String dateDebutMin ;
            private String pieceJointeConventionsMax ;
            private String pieceJointeConventionsMin ;
            private String dateArchivageMax ;
            private String dateArchivageMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;

        private OrganismeVo organismeVo ;

    private List<PieceJointeConventionVo> pieceJointeConventionsVo ;

    public ConventionVo(){
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
        public String getLibelle(){
        return this.libelle;
        }

        public void setLibelle(String libelle){
        this.libelle = libelle;
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

            public String getPieceJointeConventionsMax(){
            return this.pieceJointeConventionsMax;
            }

            public String getPieceJointeConventionsMin(){
            return this.pieceJointeConventionsMin;
            }

            public void setPieceJointeConventionsMax(String pieceJointeConventionsMax){
            this.pieceJointeConventionsMax = pieceJointeConventionsMax;
            }

            public void setPieceJointeConventionsMin(String pieceJointeConventionsMin){
            this.pieceJointeConventionsMin = pieceJointeConventionsMin;
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


        public OrganismeVo getOrganismeVo(){
        return this.organismeVo;
        }

        public void setOrganismeVo(OrganismeVo organismeVo){
        this.organismeVo = organismeVo;
        }


        public List<PieceJointeConventionVo> getPieceJointeConventionsVo(){
        return this.pieceJointeConventionsVo;
        }

        public void setPieceJointeConventionsVo(List<PieceJointeConventionVo> pieceJointeConventionsVo){
            this.pieceJointeConventionsVo = pieceJointeConventionsVo;
            }

            }
