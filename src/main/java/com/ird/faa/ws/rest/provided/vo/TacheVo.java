package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class TacheVo {

    private String id ;
    private String reference ;
    private String dateTache ;
    private String description ;


            private String dateTacheMax ;
            private String dateTacheMin ;

        private EtatTacheVo etatTacheVo ;
        private ModerateurVo moderateurVo ;


    public TacheVo(){
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
        public String getDateTache(){
        return this.dateTache;
        }

        public void setDateTache(String dateTache){
        this.dateTache = dateTache;
        }
        public String getDescription(){
        return this.description;
        }

        public void setDescription(String description){
        this.description = description;
        }


            public String getDateTacheMax(){
            return this.dateTacheMax;
            }

            public String getDateTacheMin(){
            return this.dateTacheMin;
            }

            public void setDateTacheMax(String dateTacheMax){
            this.dateTacheMax = dateTacheMax;
            }

            public void setDateTacheMin(String dateTacheMin){
            this.dateTacheMin = dateTacheMin;
            }


        public EtatTacheVo getEtatTacheVo(){
        return this.etatTacheVo;
        }

        public void setEtatTacheVo(EtatTacheVo etatTacheVo){
        this.etatTacheVo = etatTacheVo;
        }
        public ModerateurVo getModerateurVo(){
        return this.moderateurVo;
        }

        public void setModerateurVo(ModerateurVo moderateurVo){
        this.moderateurVo = moderateurVo;
        }


            }
