/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stea1th
 */
@Entity
@Table(name = "Teilnehmer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teilnehmer.findAll", query = "SELECT t FROM Teilnehmer t")})
public class Teilnehmer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_id")
    private Integer tId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    @Size(max = 30)
    @Column(name = "vorname")
    private String vorname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eintritt")
    @Temporal(TemporalType.DATE)
    private Date eintritt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "austritt")
    @Temporal(TemporalType.DATE)
    private Date austritt;
    @ManyToMany(mappedBy = "teilnehmerList")
    private List<Massnahme> massnahmeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teilnehmer")
    private List<Fehltag> fehltagList;

    public Teilnehmer() {
    }

    public Teilnehmer(Integer tId) {
        this.tId = tId;
    }

    public Teilnehmer(Integer tId, String name, Date eintritt, Date austritt) {
        this.tId = tId;
        this.name = name;
        this.eintritt = eintritt;
        this.austritt = austritt;
    }

    public Integer getTId() {
        return tId;
    }

    public void setTId(Integer tId) {
        this.tId = tId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Date getEintritt() {
        return eintritt;
    }

    public void setEintritt(Date eintritt) {
        this.eintritt = eintritt;
    }

    public Date getAustritt() {
        return austritt;
    }

    public void setAustritt(Date austritt) {
        this.austritt = austritt;
    }

    @XmlTransient
    public List<Massnahme> getMassnahmeList() {
        return massnahmeList;
    }

    public void setMassnahmeList(List<Massnahme> massnahmeList) {
        this.massnahmeList = massnahmeList;
    }

    @XmlTransient
    public List<Fehltag> getFehltagList() {
        return fehltagList;
    }

    public void setFehltagList(List<Fehltag> fehltagList) {
        this.fehltagList = fehltagList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tId != null ? tId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teilnehmer)) {
            return false;
        }
        Teilnehmer other = (Teilnehmer) object;
        if ((this.tId == null && other.tId != null) || (this.tId != null && !this.tId.equals(other.tId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Teilnehmer[ tId=" + tId + " ]";
    }
    
}
