package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class GestionReclamationVo {

    private String id ;
    private String reference ;
    private String dateTraitement ;


            private String dateTraitementMax ;
            private String dateTraitementMin ;

        private ModerateurVo moderateurVo ;
        private ReclamationVo reclamationVo ;


    public GestionReclamationVo(){
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
        public String getDateTraitement(){
        return this.dateTraitement;
        }

        public void setDateTraitement(String dateTraitement){
        this.dateTraitement = dateTraitement;
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


        public ModerateurVo getModerateurVo(){
        return this.moderateurVo;
        }

        public void setModerateurVo(ModerateurVo moderateurVo){
        this.moderateurVo = moderateurVo;
        }
        public ReclamationVo getReclamationVo(){
        return this.reclamationVo;
        }

        public void setReclamationVo(ReclamationVo reclamationVo){
        this.reclamationVo = reclamationVo;
        }


            }
