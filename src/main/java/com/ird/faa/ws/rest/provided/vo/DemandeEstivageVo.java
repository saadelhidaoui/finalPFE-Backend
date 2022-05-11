package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;
    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class DemandeEstivageVo {

    private String id ;
    private String reference ;
    private String dateDebutEstivage ;
    private String dateFinEstivage ;
    private String dateTraitement ;


            private String dateDebutEstivageMax ;
            private String dateDebutEstivageMin ;
            private String dateFinEstivageMax ;
            private String dateFinEstivageMin ;
            private String dateTraitementMax ;
            private String dateTraitementMin ;
            private String pieceJointeEstivagesMax ;
            private String pieceJointeEstivagesMin ;

        private DemandeEstivageCentreVo demandeEstivageCentreVo ;
        private AdherentVo adherentVo ;
        private EtatDemandeEstivageVo etatDemandeEstivageVo ;
        private EstivageCentreEstivageVo estivageCentreEstivageVo ;

    private List<PieceJointeEstivageVo> pieceJointeEstivagesVo ;

    public DemandeEstivageVo(){
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
        public String getDateDebutEstivage(){
        return this.dateDebutEstivage;
        }

        public void setDateDebutEstivage(String dateDebutEstivage){
        this.dateDebutEstivage = dateDebutEstivage;
        }
        public String getDateFinEstivage(){
        return this.dateFinEstivage;
        }

        public void setDateFinEstivage(String dateFinEstivage){
        this.dateFinEstivage = dateFinEstivage;
        }
        public String getDateTraitement(){
        return this.dateTraitement;
        }

        public void setDateTraitement(String dateTraitement){
        this.dateTraitement = dateTraitement;
        }



            public String getDateDebutEstivageMax(){
            return this.dateDebutEstivageMax;
            }

            public String getDateDebutEstivageMin(){
            return this.dateDebutEstivageMin;
            }

            public void setDateDebutEstivageMax(String dateDebutEstivageMax){
            this.dateDebutEstivageMax = dateDebutEstivageMax;
            }

            public void setDateDebutEstivageMin(String dateDebutEstivageMin){
            this.dateDebutEstivageMin = dateDebutEstivageMin;
            }

            public String getDateFinEstivageMax(){
            return this.dateFinEstivageMax;
            }

            public String getDateFinEstivageMin(){
            return this.dateFinEstivageMin;
            }

            public void setDateFinEstivageMax(String dateFinEstivageMax){
            this.dateFinEstivageMax = dateFinEstivageMax;
            }

            public void setDateFinEstivageMin(String dateFinEstivageMin){
            this.dateFinEstivageMin = dateFinEstivageMin;
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

            public String getPieceJointeEstivagesMax(){
            return this.pieceJointeEstivagesMax;
            }

            public String getPieceJointeEstivagesMin(){
            return this.pieceJointeEstivagesMin;
            }

            public void setPieceJointeEstivagesMax(String pieceJointeEstivagesMax){
            this.pieceJointeEstivagesMax = pieceJointeEstivagesMax;
            }

            public void setPieceJointeEstivagesMin(String pieceJointeEstivagesMin){
            this.pieceJointeEstivagesMin = pieceJointeEstivagesMin;
            }


        public DemandeEstivageCentreVo getDemandeEstivageCentreVo(){
        return this.demandeEstivageCentreVo;
        }

        public void setDemandeEstivageCentreVo(DemandeEstivageCentreVo demandeEstivageCentreVo){
        this.demandeEstivageCentreVo = demandeEstivageCentreVo;
        }
        public AdherentVo getAdherentVo(){
        return this.adherentVo;
        }

        public void setAdherentVo(AdherentVo adherentVo){
        this.adherentVo = adherentVo;
        }
        public EtatDemandeEstivageVo getEtatDemandeEstivageVo(){
        return this.etatDemandeEstivageVo;
        }

        public void setEtatDemandeEstivageVo(EtatDemandeEstivageVo etatDemandeEstivageVo){
        this.etatDemandeEstivageVo = etatDemandeEstivageVo;
        }
        public EstivageCentreEstivageVo getEstivageCentreEstivageVo(){
        return this.estivageCentreEstivageVo;
        }

        public void setEstivageCentreEstivageVo(EstivageCentreEstivageVo estivageCentreEstivageVo){
        this.estivageCentreEstivageVo = estivageCentreEstivageVo;
        }


        public List<PieceJointeEstivageVo> getPieceJointeEstivagesVo(){
        return this.pieceJointeEstivagesVo;
        }

        public void setPieceJointeEstivagesVo(List<PieceJointeEstivageVo> pieceJointeEstivagesVo){
            this.pieceJointeEstivagesVo = pieceJointeEstivagesVo;
            }

            }
