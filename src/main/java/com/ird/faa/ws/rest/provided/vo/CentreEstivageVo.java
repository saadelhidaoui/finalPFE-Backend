package  com.ird.faa.ws.rest.provided.vo;


public class CentreEstivageVo {

    private String id ;
    private String reference ;
    private String capacite ;
    private String libelle ;
    private Boolean vip ;


            private String capaciteMax ;
            private String capaciteMin ;

        private VilleVo villeVo ;


    public CentreEstivageVo(){
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
        public String getCapacite(){
        return this.capacite;
        }

        public void setCapacite(String capacite){
        this.capacite = capacite;
        }
        public String getLibelle(){
        return this.libelle;
        }

        public void setLibelle(String libelle){
        this.libelle = libelle;
        }
        public Boolean getVip(){
        return this.vip;
        }

        public void setVip(Boolean vip){
        this.vip = vip;
        }


            public String getCapaciteMax(){
            return this.capaciteMax;
            }

            public String getCapaciteMin(){
            return this.capaciteMin;
            }

            public void setCapaciteMax(String capaciteMax){
            this.capaciteMax = capaciteMax;
            }

            public void setCapaciteMin(String capaciteMin){
            this.capaciteMin = capaciteMin;
            }


        public VilleVo getVilleVo(){
        return this.villeVo;
        }

        public void setVilleVo(VilleVo villeVo){
        this.villeVo = villeVo;
        }


            }
