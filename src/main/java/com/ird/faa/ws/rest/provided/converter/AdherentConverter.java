package com.ird.faa.ws.rest.provided.converter;

import com.ird.faa.bean.Adherent;
import com.ird.faa.service.util.DateUtil;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.NumberUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.AdherentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdherentConverter extends AbstractConverter<Adherent, AdherentVo> {

    @Autowired
    private StatutConverter statutConverter;
    @Autowired
    private QualiteConverter qualiteConverter;
    @Autowired
    private EtatCarteConverter etatCarteConverter;
    @Autowired
    private FonctionConverter fonctionConverter;
    @Autowired
    private EnfantConverter enfantConverter;
    @Autowired
    private ConjointConverter conjointConverter;
    @Autowired
    private VilleConverter villeConverter;
    @Autowired
    private PieceJointeAdherentConverter pieceJointeAdherentConverter;
    private Boolean ville;
    private Boolean qualite;
    private Boolean etatCarte;
    private Boolean statut;
    private Boolean fonction;
    private Boolean conjoints;
    private Boolean enfants;
    private Boolean pieceJointeAdherents;

    public AdherentConverter() {
        init(true);
    }

    @Override
    public Adherent toItem(AdherentVo vo) {
        if (vo == null) {
            return null;
        } else {
            Adherent item = new Adherent();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getNumAdhesion()))
                item.setNumAdhesion(vo.getNumAdhesion());
            if (StringUtil.isNotEmpty(vo.getCin()))
                item.setCin(vo.getCin());
            if (StringUtil.isNotEmpty(vo.getNom()))
                item.setNom(vo.getNom());
            if (StringUtil.isNotEmpty(vo.getPrenom()))
                item.setPrenom(vo.getPrenom());
            if (StringUtil.isNotEmpty(vo.getOrigine()))
                item.setOrigine(vo.getOrigine());
            if (StringUtil.isNotEmpty(vo.getTelephone()))
                item.setTelephone(vo.getTelephone());
            if (StringUtil.isNotEmpty(vo.getAdresse()))
                item.setAdresse(vo.getAdresse());
            if (StringUtil.isNotEmpty(vo.getPpr()))
                item.setPpr(vo.getPpr());
            if (StringUtil.isNotEmpty(vo.getDateNaissance()))
                item.setDateNaissance(DateUtil.parse(vo.getDateNaissance()));
            if (StringUtil.isNotEmpty(vo.getDateArrivee()))
                item.setDateArrivee(DateUtil.parse(vo.getDateArrivee()));
            if (StringUtil.isNotEmpty(vo.getDateReception()))
                item.setDateReception(DateUtil.parse(vo.getDateReception()));
            if (StringUtil.isNotEmpty(vo.getNumeroMatricule()))
                item.setNumeroMatricule(vo.getNumeroMatricule());
            if (StringUtil.isNotEmpty(vo.getEmailPrincipale()))
                item.setEmailPrincipale(vo.getEmailPrincipale());

            item.setCredentialsNonExpired(vo.getCredentialsNonExpired());
            item.setEnabled(vo.getEnabled());
            item.setAccountNonExpired(vo.getAccountNonExpired());
            item.setAccountNonLocked(vo.getAccountNonLocked());
            item.setPasswordChanged(vo.getPasswordChanged());

            if (StringUtil.isNotEmpty(vo.getCreatedAt()))
                item.setCreatedAt(DateUtil.parse(vo.getCreatedAt()));
            if (StringUtil.isNotEmpty(vo.getUpdatedAt()))
                item.setUpdatedAt(DateUtil.parse(vo.getUpdatedAt()));
            if (StringUtil.isNotEmpty(vo.getUsername()))
                item.setUsername(vo.getUsername());
            if (StringUtil.isNotEmpty(vo.getPassword()))
                item.setPassword(vo.getPassword());
            if (StringUtil.isNotEmpty(vo.getRole()))
                item.setRole(vo.getRole());
            if (vo.getArchive() != null)
                item.setArchive(vo.getArchive());
            if (StringUtil.isNotEmpty(vo.getDateArchivage()))
                item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
            if (StringUtil.isNotEmpty(vo.getDateCreation()))
                item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
            if (vo.getAdmin() != null)
                item.setAdmin(vo.getAdmin());
            if (vo.getVisible() != null)
                item.setVisible(vo.getVisible());
            if (StringUtil.isNotEmpty(vo.getUsername()))
                item.setUsername(vo.getUsername());
            if (vo.getVilleVo() != null && this.ville)
                item.setVille(villeConverter.toItem(vo.getVilleVo()));
            if (vo.getQualiteVo() != null && this.qualite)
                item.setQualite(qualiteConverter.toItem(vo.getQualiteVo()));
            if (vo.getEtatCarteVo() != null && this.etatCarte)
                item.setEtatCarte(etatCarteConverter.toItem(vo.getEtatCarteVo()));
            if (vo.getStatutVo() != null && this.statut)
                item.setStatut(statutConverter.toItem(vo.getStatutVo()));
            if (vo.getFonctionVo() != null && this.fonction)
                item.setFonction(fonctionConverter.toItem(vo.getFonctionVo()));

            if (ListUtil.isNotEmpty(vo.getConjointsVo()) && this.conjoints)
                item.setConjoints(conjointConverter.toItem(vo.getConjointsVo()));
            if (ListUtil.isNotEmpty(vo.getEnfantsVo()) && this.enfants)
                item.setEnfants(enfantConverter.toItem(vo.getEnfantsVo()));
            if (ListUtil.isNotEmpty(vo.getPieceJointeAdherentsVo()) && this.pieceJointeAdherents)
                item.setPieceJointeAdherents(pieceJointeAdherentConverter.toItem(vo.getPieceJointeAdherentsVo()));

            return item;
        }
    }

    @Override
    public AdherentVo toVo(Adherent item) {
        if (item == null) {
            return null;
        } else {
            AdherentVo vo = new AdherentVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getNumAdhesion()))
                vo.setNumAdhesion(item.getNumAdhesion());

            if (StringUtil.isNotEmpty(item.getCin()))
                vo.setCin(item.getCin());

            if (StringUtil.isNotEmpty(item.getNom()))
                vo.setNom(item.getNom());

            if (StringUtil.isNotEmpty(item.getPrenom()))
                vo.setPrenom(item.getPrenom());

            if (StringUtil.isNotEmpty(item.getOrigine()))
                vo.setOrigine(item.getOrigine());

            if (StringUtil.isNotEmpty(item.getTelephone()))
                vo.setTelephone(item.getTelephone());

            if (StringUtil.isNotEmpty(item.getAdresse()))
                vo.setAdresse(item.getAdresse());

            if (StringUtil.isNotEmpty(item.getPpr()))
                vo.setPpr(item.getPpr());

            if (item.getDateNaissance() != null)
                vo.setDateNaissance(DateUtil.formateDate(item.getDateNaissance()));
            if (item.getDateArrivee() != null)
                vo.setDateArrivee(DateUtil.formateDate(item.getDateArrivee()));
            if (item.getDateReception() != null)
                vo.setDateReception(DateUtil.formateDate(item.getDateReception()));

            if (StringUtil.isNotEmpty(item.getNumeroMatricule()))
                vo.setNumeroMatricule(item.getNumeroMatricule());

            if (StringUtil.isNotEmpty(item.getEmailPrincipale()))
                vo.setEmailPrincipale(item.getEmailPrincipale());

            vo.setCredentialsNonExpired(item.getCredentialsNonExpired());
            vo.setEnabled(item.getEnabled());
            vo.setAccountNonExpired(item.getAccountNonExpired());
            vo.setAccountNonLocked(item.getAccountNonLocked());
            vo.setPasswordChanged(item.getPasswordChanged());
            if (item.getCreatedAt() != null)
                vo.setCreatedAt(DateUtil.formateDate(item.getCreatedAt()));
            if (item.getUpdatedAt() != null)
                vo.setUpdatedAt(DateUtil.formateDate(item.getUpdatedAt()));
            if (StringUtil.isNotEmpty(item.getUsername()))
                vo.setUsername(item.getUsername());

            if (StringUtil.isNotEmpty(item.getPassword()))
                vo.setPassword(item.getPassword());

            if (StringUtil.isNotEmpty(item.getRole()))
                vo.setRole(item.getRole());

            if (item.getArchive() != null)
                vo.setArchive(item.getArchive());
            if (item.getDateArchivage() != null)
                vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
            if (item.getDateCreation() != null)
                vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
            if (item.getAdmin() != null)
                vo.setAdmin(item.getAdmin());
            if (item.getVisible() != null)
                vo.setVisible(item.getVisible());
            if (StringUtil.isNotEmpty(item.getUsername()))
                vo.setUsername(item.getUsername());

            if (item.getVille() != null && this.ville) {
                vo.setVilleVo(villeConverter.toVo(item.getVille()));
            }
            if (item.getQualite() != null && this.qualite) {
                vo.setQualiteVo(qualiteConverter.toVo(item.getQualite()));
            }
            if (item.getEtatCarte() != null && this.etatCarte) {
                vo.setEtatCarteVo(etatCarteConverter.toVo(item.getEtatCarte()));
            }
            if (item.getStatut() != null && this.statut) {
                vo.setStatutVo(statutConverter.toVo(item.getStatut()));
            }
            if (item.getFonction() != null && this.fonction) {
                vo.setFonctionVo(fonctionConverter.toVo(item.getFonction()));
            }
            if (ListUtil.isNotEmpty(item.getConjoints()) && this.conjoints) {
                conjointConverter.init(true);
                conjointConverter.setAdherent(false);
                vo.setConjointsVo(conjointConverter.toVo(item.getConjoints()));
                conjointConverter.setAdherent(true);
            }
            if (ListUtil.isNotEmpty(item.getEnfants()) && this.enfants) {
                enfantConverter.init(true);
                enfantConverter.setAdherent(false);
                vo.setEnfantsVo(enfantConverter.toVo(item.getEnfants()));
                enfantConverter.setAdherent(true);
            }
            if (ListUtil.isNotEmpty(item.getPieceJointeAdherents()) && this.pieceJointeAdherents) {
                pieceJointeAdherentConverter.init(true);
                pieceJointeAdherentConverter.setAdherent(false);
                vo.setPieceJointeAdherentsVo(pieceJointeAdherentConverter.toVo(item.getPieceJointeAdherents()));
                pieceJointeAdherentConverter.setAdherent(true);
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        ville = value;
        qualite = value;
        etatCarte = value;
        statut = value;
        fonction = value;
        conjoints = value;
        enfants = value;
        pieceJointeAdherents = value;
    }


    public StatutConverter getStatutConverter() {
        return this.statutConverter;
    }

    public void setStatutConverter(StatutConverter statutConverter) {
        this.statutConverter = statutConverter;
    }

    public QualiteConverter getQualiteConverter() {
        return this.qualiteConverter;
    }

    public void setQualiteConverter(QualiteConverter qualiteConverter) {
        this.qualiteConverter = qualiteConverter;
    }

    public EtatCarteConverter getEtatCarteConverter() {
        return this.etatCarteConverter;
    }

    public void setEtatCarteConverter(EtatCarteConverter etatCarteConverter) {
        this.etatCarteConverter = etatCarteConverter;
    }

    public FonctionConverter getFonctionConverter() {
        return this.fonctionConverter;
    }

    public void setFonctionConverter(FonctionConverter fonctionConverter) {
        this.fonctionConverter = fonctionConverter;
    }

    public EnfantConverter getEnfantConverter() {
        return this.enfantConverter;
    }

    public void setEnfantConverter(EnfantConverter enfantConverter) {
        this.enfantConverter = enfantConverter;
    }

    public ConjointConverter getConjointConverter() {
        return this.conjointConverter;
    }

    public void setConjointConverter(ConjointConverter conjointConverter) {
        this.conjointConverter = conjointConverter;
    }

    public VilleConverter getVilleConverter() {
        return this.villeConverter;
    }

    public void setVilleConverter(VilleConverter villeConverter) {
        this.villeConverter = villeConverter;
    }

    public PieceJointeAdherentConverter getPieceJointeAdherentConverter() {
        return this.pieceJointeAdherentConverter;
    }

    public void setPieceJointeAdherentConverter(PieceJointeAdherentConverter pieceJointeAdherentConverter) {
        this.pieceJointeAdherentConverter = pieceJointeAdherentConverter;
    }

    public boolean isVille() {
        return this.ville;
    }

    public void setVille(boolean ville) {
        this.ville = ville;
    }

    public boolean isQualite() {
        return this.qualite;
    }

    public void setQualite(boolean qualite) {
        this.qualite = qualite;
    }

    public boolean isEtatCarte() {
        return this.etatCarte;
    }

    public void setEtatCarte(boolean etatCarte) {
        this.etatCarte = etatCarte;
    }

    public boolean isStatut() {
        return this.statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public boolean isFonction() {
        return this.fonction;
    }

    public void setFonction(boolean fonction) {
        this.fonction = fonction;
    }


    public Boolean isConjoints() {
        return this.conjoints;
    }

    public void setConjoints(Boolean conjoints) {
        this.conjoints = conjoints;
    }


    public Boolean isEnfants() {
        return this.enfants;
    }

    public void setEnfants(Boolean enfants) {
        this.enfants = enfants;
    }


    public Boolean isPieceJointeAdherents() {
        return this.pieceJointeAdherents;
    }

    public void setPieceJointeAdherents(Boolean pieceJointeAdherents) {
        this.pieceJointeAdherents = pieceJointeAdherents;
    }


}
