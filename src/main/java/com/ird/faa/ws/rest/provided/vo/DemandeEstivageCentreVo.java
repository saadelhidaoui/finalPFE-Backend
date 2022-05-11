package  com.ird.faa.ws.rest.provided.vo;


public class DemandeEstivageCentreVo {

    private String id ;
    private String reference ;



        private DemandeEstivageVo demandeEstivageVo ;
        private CentreEstivageVo centreEstivageVo ;


    public DemandeEstivageCentreVo(){
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



        public DemandeEstivageVo getDemandeEstivageVo(){
        return this.demandeEstivageVo;
        }

        public void setDemandeEstivageVo(DemandeEstivageVo demandeEstivageVo){
        this.demandeEstivageVo = demandeEstivageVo;
        }
        public CentreEstivageVo getCentreEstivageVo(){
        return this.centreEstivageVo;
        }

        public void setCentreEstivageVo(CentreEstivageVo CentreEstivageVo){
        this.centreEstivageVo = CentreEstivageVo;
        }


            }
