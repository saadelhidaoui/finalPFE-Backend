package com.ird.faa.ws.rest.provided.vo;

import java.util.List;

public class AdherentVo {

    private String id;
    private String numAdhesion;
    private String cin;
    private String nom;
    private String prenom;
    private String origine;
    private String telephone;
    private String adresse;
    private String ppr;
    private String dateNaissance;
    private String dateArrivee;
    private String dateReception;
    private String numeroMatricule;
    private String emailPrincipale;
    private Boolean credentialsNonExpired = false;
    private Boolean enabled = true;
    private Boolean accountNonExpired = false;
    private Boolean accountNonLocked = false;
    private Boolean passwordChanged = false;
    private String createdAt;
    private String updatedAt;
    private String username;
    private String password;
    private String role;
    private Boolean archive;
    private String dateArchivage;
    private String dateCreation;
    private Boolean admin;
    private Boolean visible;
    private String dateNaissanceMax;
    private String dateNaissanceMin;
    private String dateArriveeMax;
    private String dateArriveeMin;
    private String dateReceptionMax;
    private String dateReceptionMin;
    private String conjointsMax;
    private String conjointsMin;
    private String pieceJointeAdherentsMax;
    private String pieceJointeAdherentsMin;
    private String createdAtMax;
    private String createdAtMin;
    private String updatedAtMax;
    private String updatedAtMin;
    private String dateArchivageMax;
    private String dateArchivageMin;
    private String dateCreationMax;
    private String dateCreationMin;

    private VilleVo villeVo;
    private QualiteVo qualiteVo;
    private EtatCarteVo etatCarteVo;
    private StatutVo statutVo;
    private FonctionVo fonctionVo;

    private List<ConjointVo> conjointsVo;
    private List<EnfantVo> enfantsVo;
    private List<PieceJointeAdherentVo> pieceJointeAdherentsVo;

    public AdherentVo() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumAdhesion() {
        return this.numAdhesion;
    }

    public void setNumAdhesion(String numAdhesion) {
        this.numAdhesion = numAdhesion;
    }

    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getOrigine() {
        return this.origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPpr() {
        return this.ppr;
    }

    public void setPpr(String ppr) {
        this.ppr = ppr;
    }

    public String getDateNaissance() {
        return this.dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getDateArrivee() {
        return this.dateArrivee;
    }

    public void setDateArrivee(String dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public String getDateReception() {
        return this.dateReception;
    }

    public void setDateReception(String dateReception) {
        this.dateReception = dateReception;
    }

    public String getNumeroMatricule() {
        return this.numeroMatricule;
    }

    public void setNumeroMatricule(String numeroMatricule) {
        this.numeroMatricule = numeroMatricule;
    }

    public String getEmailPrincipale() {
        return this.emailPrincipale;
    }

    public void setEmailPrincipale(String emailPrincipale) {
        this.emailPrincipale = emailPrincipale;
    }

    public Boolean getCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getAccountNonExpired() {
        return this.accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return this.accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getPasswordChanged() {
        return this.passwordChanged;
    }

    public void setPasswordChanged(Boolean passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getArchive() {
        return this.archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public String getDateArchivage() {
        return this.dateArchivage;
    }

    public void setDateArchivage(String dateArchivage) {
        this.dateArchivage = dateArchivage;
    }

    public String getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getVisible() {
        return this.visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getDateNaissanceMax() {
        return this.dateNaissanceMax;
    }

    public String getDateNaissanceMin() {
        return this.dateNaissanceMin;
    }

    public void setDateNaissanceMax(String dateNaissanceMax) {
        this.dateNaissanceMax = dateNaissanceMax;
    }

    public void setDateNaissanceMin(String dateNaissanceMin) {
        this.dateNaissanceMin = dateNaissanceMin;
    }

    public String getDateArriveeMax() {
        return this.dateArriveeMax;
    }

    public String getDateArriveeMin() {
        return this.dateArriveeMin;
    }

    public void setDateArriveeMax(String dateArriveeMax) {
        this.dateArriveeMax = dateArriveeMax;
    }

    public void setDateArriveeMin(String dateArriveeMin) {
        this.dateArriveeMin = dateArriveeMin;
    }

    public String getDateReceptionMax() {
        return this.dateReceptionMax;
    }

    public String getDateReceptionMin() {
        return this.dateReceptionMin;
    }

    public void setDateReceptionMax(String dateReceptionMax) {
        this.dateReceptionMax = dateReceptionMax;
    }

    public void setDateReceptionMin(String dateReceptionMin) {
        this.dateReceptionMin = dateReceptionMin;
    }

    public String getConjointsMax() {
        return this.conjointsMax;
    }

    public String getConjointsMin() {
        return this.conjointsMin;
    }

    public void setConjointsMax(String conjointsMax) {
        this.conjointsMax = conjointsMax;
    }

    public void setConjointsMin(String conjointsMin) {
        this.conjointsMin = conjointsMin;
    }

    public String getPieceJointeAdherentsMax() {
        return this.pieceJointeAdherentsMax;
    }

    public String getPieceJointeAdherentsMin() {
        return this.pieceJointeAdherentsMin;
    }

    public void setPieceJointeAdherentsMax(String pieceJointeAdherentsMax) {
        this.pieceJointeAdherentsMax = pieceJointeAdherentsMax;
    }

    public void setPieceJointeAdherentsMin(String pieceJointeAdherentsMin) {
        this.pieceJointeAdherentsMin = pieceJointeAdherentsMin;
    }

    public String getCreatedAtMax() {
        return this.createdAtMax;
    }

    public String getCreatedAtMin() {
        return this.createdAtMin;
    }

    public void setCreatedAtMax(String createdAtMax) {
        this.createdAtMax = createdAtMax;
    }

    public void setCreatedAtMin(String createdAtMin) {
        this.createdAtMin = createdAtMin;
    }

    public String getUpdatedAtMax() {
        return this.updatedAtMax;
    }

    public String getUpdatedAtMin() {
        return this.updatedAtMin;
    }

    public void setUpdatedAtMax(String updatedAtMax) {
        this.updatedAtMax = updatedAtMax;
    }

    public void setUpdatedAtMin(String updatedAtMin) {
        this.updatedAtMin = updatedAtMin;
    }

    public String getDateArchivageMax() {
        return this.dateArchivageMax;
    }

    public String getDateArchivageMin() {
        return this.dateArchivageMin;
    }

    public void setDateArchivageMax(String dateArchivageMax) {
        this.dateArchivageMax = dateArchivageMax;
    }

    public void setDateArchivageMin(String dateArchivageMin) {
        this.dateArchivageMin = dateArchivageMin;
    }

    public String getDateCreationMax() {
        return this.dateCreationMax;
    }

    public String getDateCreationMin() {
        return this.dateCreationMin;
    }

    public void setDateCreationMax(String dateCreationMax) {
        this.dateCreationMax = dateCreationMax;
    }

    public void setDateCreationMin(String dateCreationMin) {
        this.dateCreationMin = dateCreationMin;
    }


    public VilleVo getVilleVo() {
        return this.villeVo;
    }

    public void setVilleVo(VilleVo villeVo) {
        this.villeVo = villeVo;
    }

    public QualiteVo getQualiteVo() {
        return this.qualiteVo;
    }

    public void setQualiteVo(QualiteVo qualiteVo) {
        this.qualiteVo = qualiteVo;
    }

    public EtatCarteVo getEtatCarteVo() {
        return this.etatCarteVo;
    }

    public void setEtatCarteVo(EtatCarteVo etatCarteVo) {
        this.etatCarteVo = etatCarteVo;
    }

    public StatutVo getStatutVo() {
        return this.statutVo;
    }

    public void setStatutVo(StatutVo statutVo) {
        this.statutVo = statutVo;
    }

    public FonctionVo getFonctionVo() {
        return this.fonctionVo;
    }

    public void setFonctionVo(FonctionVo fonctionVo) {
        this.fonctionVo = fonctionVo;
    }


    public List<ConjointVo> getConjointsVo() {
        return this.conjointsVo;
    }

    public void setConjointsVo(List<ConjointVo> conjointsVo) {
        this.conjointsVo = conjointsVo;
    }

    public List<EnfantVo> getEnfantsVo() {
        return this.enfantsVo;
    }

    public void setEnfantsVo(List<EnfantVo> enfantsVo) {
        this.enfantsVo = enfantsVo;
    }

    public List<PieceJointeAdherentVo> getPieceJointeAdherentsVo() {
        return this.pieceJointeAdherentsVo;
    }

    public void setPieceJointeAdherentsVo(List<PieceJointeAdherentVo> pieceJointeAdherentsVo) {
        this.pieceJointeAdherentsVo = pieceJointeAdherentsVo;
    }


}
