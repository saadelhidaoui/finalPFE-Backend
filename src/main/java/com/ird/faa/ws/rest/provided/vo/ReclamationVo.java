package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;
    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class ReclamationVo {

    private String id ;
    private String reference ;
    private String libelle ;
    private String description ;
    private String dateReclamation ;
    private Boolean archive ;
    private String dateArchivage ;
    private String dateCreation ;
    private Boolean admin ;
    private Boolean visible ;
    private String username ;


            private String dateReclamationMax ;
            private String dateReclamationMin ;
            private String pieceJointeReclamationsMax ;
            private String pieceJointeReclamationsMin ;
            private String dateArchivageMax ;
            private String dateArchivageMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;

        private AdherentVo adherentVo ;
        private EtatReclamationVo etatReclamationVo ;

    private List<PieceJointeReclamationVo> pieceJointeReclamationsVo ;

    public ReclamationVo(){
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
        public String getDateReclamation(){
        return this.dateReclamation;
        }

        public void setDateReclamation(String dateReclamation){
        this.dateReclamation = dateReclamation;
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


            public String getDateReclamationMax(){
            return this.dateReclamationMax;
            }

            public String getDateReclamationMin(){
            return this.dateReclamationMin;
            }

            public void setDateReclamationMax(String dateReclamationMax){
            this.dateReclamationMax = dateReclamationMax;
            }

            public void setDateReclamationMin(String dateReclamationMin){
            this.dateReclamationMin = dateReclamationMin;
            }

            public String getPieceJointeReclamationsMax(){
            return this.pieceJointeReclamationsMax;
            }

            public String getPieceJointeReclamationsMin(){
            return this.pieceJointeReclamationsMin;
            }

            public void setPieceJointeReclamationsMax(String pieceJointeReclamationsMax){
            this.pieceJointeReclamationsMax = pieceJointeReclamationsMax;
            }

            public void setPieceJointeReclamationsMin(String pieceJointeReclamationsMin){
            this.pieceJointeReclamationsMin = pieceJointeReclamationsMin;
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


        public AdherentVo getAdherentVo(){
        return this.adherentVo;
        }

        public void setAdherentVo(AdherentVo adherentVo){
        this.adherentVo = adherentVo;
        }
        public EtatReclamationVo getEtatReclamationVo(){
        return this.etatReclamationVo;
        }

        public void setEtatReclamationVo(EtatReclamationVo etatReclamationVo){
        this.etatReclamationVo = etatReclamationVo;
        }


        public List<PieceJointeReclamationVo> getPieceJointeReclamationsVo(){
        return this.pieceJointeReclamationsVo;
        }

        public void setPieceJointeReclamationsVo(List<PieceJointeReclamationVo> pieceJointeReclamationsVo){
            this.pieceJointeReclamationsVo = pieceJointeReclamationsVo;
            }

            }
