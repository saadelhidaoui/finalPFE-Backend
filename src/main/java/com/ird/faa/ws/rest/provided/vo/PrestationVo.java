package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;

    import com.ird.faa.bean.PieceJointePrestation;

public class PrestationVo {

    private String id ;
    private String reference ;
    private String numArrivee ;
    private Boolean envoye ;
    private String dateEnvoi ;
    private String dateTraitement ;
    private String chargeCas ;
    private Boolean resultat ;
    private String notes ;
    private Boolean archive ;
    private String dateArchivage ;
    private String dateCreation ;
    private Boolean admin ;
    private Boolean visible ;
    private String username ;


            private String dateEnvoiMax ;
            private String dateEnvoiMin ;
            private String dateTraitementMax ;
            private String dateTraitementMin ;
            private String pieceJointePrestationsMax ;
            private String pieceJointePrestationsMin ;
            private String dateArchivageMax ;
            private String dateArchivageMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;

        private EtatPrestationVo etatPrestationVo ;
        private NiveauImportanceVo niveauImportanceVo ;
        private TypePrestationVo typePrestationVo ;
        private AdherentVo adherentVo ;

    private List<PieceJointePrestationVo> pieceJointePrestationsVo ;

    public PrestationVo(){
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
        public String getNumArrivee(){
        return this.numArrivee;
        }

        public void setNumArrivee(String numArrivee){
        this.numArrivee = numArrivee;
        }
        public Boolean getEnvoye(){
        return this.envoye;
        }

        public void setEnvoye(Boolean envoye){
        this.envoye = envoye;
        }
        public String getDateEnvoi(){
        return this.dateEnvoi;
        }

        public void setDateEnvoi(String dateEnvoi){
        this.dateEnvoi = dateEnvoi;
        }
        public String getDateTraitement(){
        return this.dateTraitement;
        }

        public void setDateTraitement(String dateTraitement){
        this.dateTraitement = dateTraitement;
        }
        public String getChargeCas(){
        return this.chargeCas;
        }

        public void setChargeCas(String chargeCas){
        this.chargeCas = chargeCas;
        }
        public Boolean getResultat(){
        return this.resultat;
        }

        public void setResultat(Boolean resultat){
        this.resultat = resultat;
        }
        public String getNotes(){
        return this.notes;
        }

        public void setNotes(String notes){
        this.notes = notes;
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


            public String getDateEnvoiMax(){
            return this.dateEnvoiMax;
            }

            public String getDateEnvoiMin(){
            return this.dateEnvoiMin;
            }

            public void setDateEnvoiMax(String dateEnvoiMax){
            this.dateEnvoiMax = dateEnvoiMax;
            }

            public void setDateEnvoiMin(String dateEnvoiMin){
            this.dateEnvoiMin = dateEnvoiMin;
            }

            public String getDateTraitementMax(){
            return this.dateTraitementMax;
            }

            public String getDateTraitementMin(){
            return this.dateTraitementMin;
            }

            public void setDateTraitementMax(String dateTraitementMax){
            this.dateTraitementMax = dateTraitementMax;
            }

            public void setDateTraitementMin(String dateTraitementMin){
            this.dateTraitementMin = dateTraitementMin;
            }

            public String getPieceJointePrestationsMax(){
            return this.pieceJointePrestationsMax;
            }

            public String getPieceJointePrestationsMin(){
            return this.pieceJointePrestationsMin;
            }

            public void setPieceJointePrestationsMax(String pieceJointePrestationsMax){
            this.pieceJointePrestationsMax = pieceJointePrestationsMax;
            }

            public void setPieceJointePrestationsMin(String pieceJointePrestationsMin){
            this.pieceJointePrestationsMin = pieceJointePrestationsMin;
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


        public EtatPrestationVo getEtatPrestationVo(){
        return this.etatPrestationVo;
        }

        public void setEtatPrestationVo(EtatPrestationVo etatPrestationVo){
        this.etatPrestationVo = etatPrestationVo;
        }
        public NiveauImportanceVo getNiveauImportanceVo(){
        return this.niveauImportanceVo;
        }

        public void setNiveauImportanceVo(NiveauImportanceVo niveauImportanceVo){
        this.niveauImportanceVo = niveauImportanceVo;
        }
        public TypePrestationVo getTypePrestationVo(){
        return this.typePrestationVo;
        }

        public void setTypePrestationVo(TypePrestationVo typePrestationVo){
        this.typePrestationVo = typePrestationVo;
        }
        public AdherentVo getAdherentVo(){
        return this.adherentVo;
        }

        public void setAdherentVo(AdherentVo adherentVo){
        this.adherentVo = adherentVo;
        }


        public List<PieceJointePrestationVo> getPieceJointePrestationsVo(){
        return this.pieceJointePrestationsVo;
        }

        public void setPieceJointePrestationsVo(List<PieceJointePrestationVo> pieceJointePrestationsVo){
            this.pieceJointePrestationsVo = pieceJointePrestationsVo;
            }

            }
