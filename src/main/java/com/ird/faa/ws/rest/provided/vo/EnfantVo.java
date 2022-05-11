package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class EnfantVo {

    private String id ;
    private String reference ;
    private String nom ;
    private String prenom ;
    private String age ;
    private String dateNaissance ;
    private Boolean archive ;
    private String dateArchivage ;
    private String dateCreation ;
    private Boolean admin ;
    private Boolean visible ;
    private String username ;


            private String ageMax ;
            private String ageMin ;
            private String dateNaissanceMax ;
            private String dateNaissanceMin ;
            private String dateArchivageMax ;
            private String dateArchivageMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;

        private QualiteVo qualiteVo ;
        private AdherentVo adherentVo ;


    public EnfantVo(){
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
        public String getAge(){
        return this.age;
        }

        public void setAge(String age){
        this.age = age;
        }
        public String getDateNaissance(){
        return this.dateNaissance;
        }

        public void setDateNaissance(String dateNaissance){
        this.dateNaissance = dateNaissance;
        }
        public Boolean getArchive(){
        return this.archive;
        }

        public void setArchive(Boolean archive){
        this.archive = archive;
        }
        public String getDateArchivage(){
        return this.dateArchivage;
        }

        public void setDateArchivage(String dateArchivage){
        this.dateArchivage = dateArchivage;
        }
        public String getDateCreation(){
        return this.dateCreation;
        }

        public void setDateCreation(String dateCreation){
        this.dateCreation = dateCreation;
        }
        public Boolean getAdmin(){
        return this.admin;
        }

        public void setAdmin(Boolean admin){
        this.admin = admin;
        }
        public Boolean getVisible(){
        return this.visible;
        }

        public void setVisible(Boolean visible){
        this.visible = visible;
        }
        public String getUsername(){
        return this.username;
        }

        public void setUsername(String username){
        this.username = username;
        }


            public String getAgeMax(){
            return this.ageMax;
            }

            public String getAgeMin(){
            return this.ageMin;
            }

            public void setAgeMax(String ageMax){
            this.ageMax = ageMax;
            }

            public void setAgeMin(String ageMin){
            this.ageMin = ageMin;
            }

            public String getDateNaissanceMax(){
            return this.dateNaissanceMax;
            }

            public String getDateNaissanceMin(){
            return this.dateNaissanceMin;
            }

            public void setDateNaissanceMax(String dateNaissanceMax){
            this.dateNaissanceMax = dateNaissanceMax;
            }

            public void setDateNaissanceMin(String dateNaissanceMin){
            this.dateNaissanceMin = dateNaissanceMin;
            }

            public String getDateArchivageMax(){
            return this.dateArchivageMax;
            }

            public String getDateArchivageMin(){
            return this.dateArchivageMin;
            }

            public void setDateArchivageMax(String dateArchivageMax){
            this.dateArchivageMax = dateArchivageMax;
            }

            public void setDateArchivageMin(String dateArchivageMin){
            this.dateArchivageMin = dateArchivageMin;
            }

            public String getDateCreationMax(){
            return this.dateCreationMax;
            }

            public String getDateCreationMin(){
            return this.dateCreationMin;
            }

            public void setDateCreationMax(String dateCreationMax){
            this.dateCreationMax = dateCreationMax;
            }

            public void setDateCreationMin(String dateCreationMin){
            this.dateCreationMin = dateCreationMin;
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
