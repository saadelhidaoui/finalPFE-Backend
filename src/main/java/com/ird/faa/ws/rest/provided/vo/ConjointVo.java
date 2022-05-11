package  com.ird.faa.ws.rest.provided.vo;


public class ConjointVo {

    private String id ;
    private String cin ;
    private String nom ;
    private String prenom ;
    private String origin ;
    private String email ;
    private String telephone ;



        private QualiteVo qualiteVo ;
        private AdherentVo adherentVo ;


    public ConjointVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getCin(){
        return this.cin;
        }

        public void setCin(String cin){
        this.cin = cin;
        }
        public String getNom(){
        return this.nom;
        }

        public void setNom(String nom){
        this.nom = nom;
        }
        public String getPrenom(){
        return this.prenom;
        }

        public void setPrenom(String prenom){
        this.prenom = prenom;
        }
        public String getOrigin(){
        return this.origin;
        }

        public void setOrigin(String origin){
        this.origin = origin;
        }
        public String getEmail(){
        return this.email;
        }

        public void setEmail(String email){
        this.email = email;
        }
        public String getTelephone(){
        return this.telephone;
        }

        public void setTelephone(String telephone){
        this.telephone = telephone;
        }



        public QualiteVo getQualiteVo(){
        return this.qualiteVo;
        }

        public void setQualiteVo(QualiteVo qualiteVo){
        this.qualiteVo = qualiteVo;
        }
        public AdherentVo getAdherentVo(){
        return this.adherentVo;
        }

        public void setAdherentVo(AdherentVo adherentVo){
        this.adherentVo = adherentVo;
        }


            }
