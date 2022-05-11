package  com.ird.faa.ws.rest.provided.vo;


public class EstivageCentreEstivageVo {

    private String id ;
    private String reference ;
    private String ordre ;


            private String ordreMax ;
            private String ordreMin ;

        private CentreEstivageVo centreEstivageVo ;
        private EstivageVo estivageVo ;


    public EstivageCentreEstivageVo(){
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
        public String getOrdre(){
        return this.ordre;
        }

        public void setOrdre(String ordre){
        this.ordre = ordre;
        }


            public String getOrdreMax(){
            return this.ordreMax;
            }

            public String getOrdreMin(){
            return this.ordreMin;
            }

            public void setOrdreMax(String ordreMax){
            this.ordreMax = ordreMax;
            }

            public void setOrdreMin(String ordreMin){
            this.ordreMin = ordreMin;
            }


        public CentreEstivageVo getCentreEstivageVo(){
        return this.centreEstivageVo;
        }

        public void setCentreEstivageVo(CentreEstivageVo centreEstivageVo){
        this.centreEstivageVo = centreEstivageVo;
        }
        public EstivageVo getEstivageVo(){
        return this.estivageVo;
        }

        public void setEstivageVo(EstivageVo estivageVo){
        this.estivageVo = estivageVo;
        }


            }
