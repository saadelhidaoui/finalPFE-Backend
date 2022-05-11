package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;
    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class ProduitVo {

    private String id ;
    private String reference ;
    private String libelle ;
    private String dateArrivee ;
    private String quantite ;
    private Boolean archive ;
    private String dateArchivage ;
    private String dateCreation ;
    private Boolean admin ;
    private Boolean visible ;
    private String username ;


            private String dateArriveeMax ;
            private String dateArriveeMin ;
            private String quantiteMax ;
            private String quantiteMin ;
            private String pieceJointeProduitsMax ;
            private String pieceJointeProduitsMin ;
            private String dateArchivageMax ;
            private String dateArchivageMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;


    private List<PieceJointeProduitVo> pieceJointeProduitsVo ;

    public ProduitVo(){
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
        public String getDateArrivee(){
        return this.dateArrivee;
        }

        public void setDateArrivee(String dateArrivee){
        this.dateArrivee = dateArrivee;
        }
        public String getQuantite(){
        return this.quantite;
        }

        public void setQuantite(String quantite){
        this.quantite = quantite;
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


            public String getDateArriveeMax(){
            return this.dateArriveeMax;
            }

            public String getDateArriveeMin(){
            return this.dateArriveeMin;
            }

            public void setDateArriveeMax(String dateArriveeMax){
            this.dateArriveeMax = dateArriveeMax;
            }

            public void setDateArriveeMin(String dateArriveeMin){
            this.dateArriveeMin = dateArriveeMin;
            }

            public String getQuantiteMax(){
            return this.quantiteMax;
            }

            public String getQuantiteMin(){
            return this.quantiteMin;
            }

            public void setQuantiteMax(String quantiteMax){
            this.quantiteMax = quantiteMax;
            }

            public void setQuantiteMin(String quantiteMin){
            this.quantiteMin = quantiteMin;
            }

            public String getPieceJointeProduitsMax(){
            return this.pieceJointeProduitsMax;
            }

            public String getPieceJointeProduitsMin(){
            return this.pieceJointeProduitsMin;
            }

            public void setPieceJointeProduitsMax(String pieceJointeProduitsMax){
            this.pieceJointeProduitsMax = pieceJointeProduitsMax;
            }

            public void setPieceJointeProduitsMin(String pieceJointeProduitsMin){
            this.pieceJointeProduitsMin = pieceJointeProduitsMin;
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




        public List<PieceJointeProduitVo> getPieceJointeProduitsVo(){
        return this.pieceJointeProduitsVo;
        }

        public void setPieceJointeProduitsVo(List<PieceJointeProduitVo> pieceJointeProduitsVo){
            this.pieceJointeProduitsVo = pieceJointeProduitsVo;
            }

            }
