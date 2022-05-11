package  com.ird.faa.ws.rest.provided.vo;


public class VilleVo {

    private String id ;
    private String reference ;
    private String libelle ;



        private RegionVo regionVo ;


    public VilleVo(){
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



        public RegionVo getRegionVo(){
        return this.regionVo;
        }

        public void setRegionVo(RegionVo regionVo){
        this.regionVo = regionVo;
        }


            }
