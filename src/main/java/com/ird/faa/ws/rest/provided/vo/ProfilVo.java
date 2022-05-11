package  com.ird.faa.ws.rest.provided.vo;


public class ProfilVo {

    private String id ;
    private String reference ;
    private String libelle ;



        private GradeVo gradeVo ;
        private EchelleVo echelleVo ;


    public ProfilVo(){
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



        public GradeVo getGradeVo(){
        return this.gradeVo;
        }

        public void setGradeVo(GradeVo gradeVo){
        this.gradeVo = gradeVo;
        }
        public EchelleVo getEchelleVo(){
        return this.echelleVo;
        }

        public void setEchelleVo(EchelleVo echelleVo){
        this.echelleVo = echelleVo;
        }


            }
