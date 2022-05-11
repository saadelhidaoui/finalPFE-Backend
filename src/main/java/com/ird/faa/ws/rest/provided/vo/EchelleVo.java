package  com.ird.faa.ws.rest.provided.vo;


public class EchelleVo {

    private String id ;
    private String reference ;
    private String libelle ;



        private EchelonVo echelonVo ;


    public EchelleVo(){
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



        public EchelonVo getEchelonVo(){
        return this.echelonVo;
        }

        public void setEchelonVo(EchelonVo echelonVo){
        this.echelonVo = echelonVo;
        }


            }
