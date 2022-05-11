package  com.ird.faa.ws.rest.provided.vo;


public class OrganismeVo {

    private String id ;
    private String reference ;
    private String libelle ;
    private String telephone ;
    private String email ;
    private String fix ;
    private String fax ;



        private VilleVo villeVo ;


    public OrganismeVo(){
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
        public String getTelephone(){
        return this.telephone;
        }

        public void setTelephone(String telephone){
        this.telephone = telephone;
        }
        public String getEmail(){
        return this.email;
        }

        public void setEmail(String email){
        this.email = email;
        }
        public String getFix(){
        return this.fix;
        }

        public void setFix(String fix){
        this.fix = fix;
        }
        public String getFax(){
        return this.fax;
        }

        public void setFax(String fax){
        this.fax = fax;
        }



        public VilleVo getVilleVo(){
        return this.villeVo;
        }

        public void setVilleVo(VilleVo villeVo){
        this.villeVo = villeVo;
        }


            }
