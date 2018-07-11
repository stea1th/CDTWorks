/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stea1th
 */
@Entity
@Table(name = "Massnahme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Massnahme.findAll", query = "SELECT m FROM Massnahme m")})
public class Massnahme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "m_id")
    private String mId;
    @Size(max = 50)
    @Column(name = "bez")
    private String bez;
    @JoinTable(name = "Teil_Mass", joinColumns = {
        @JoinColumn(name = "m_id", referencedColumnName = "m_id")}, inverseJoinColumns = {
        @JoinColumn(name = "t_id", referencedColumnName = "t_id")})
    @ManyToMany
    private List<Teilnehmer> teilnehmerList;
    @ManyToMany(mappedBy = "massnahmeList")
    private List<Baustein> bausteinList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "massnahme")
    private List<MassKlasse> massKlasseList;

    public Massnahme() {
    }

    public Massnahme(String mId) {
        this.mId = mId;
    }

    public String getMId() {
        return mId;
    }

    public void setMId(String mId) {
        this.mId = mId;
    }

    public String getBez() {
        return bez;
    }

    public void setBez(String bez) {
        this.bez = bez;
    }

    @XmlTransient
    public List<Teilnehmer> getTeilnehmerList() {
        return teilnehmerList;
    }

    public void setTeilnehmerList(List<Teilnehmer> teilnehmerList) {
        this.teilnehmerList = teilnehmerList;
    }

    @XmlTransient
    public List<Baustein> getBausteinList() {
        return bausteinList;
    }

    public void setBausteinList(List<Baustein> bausteinList) {
        this.bausteinList = bausteinList;
    }

    @XmlTransient
    public List<MassKlasse> getMassKlasseList() {
        return massKlasseList;
    }

    public void setMassKlasseList(List<MassKlasse> massKlasseList) {
        this.massKlasseList = massKlasseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mId != null ? mId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Massnahme)) {
            return false;
        }
        Massnahme other = (Massnahme) object;
        if ((this.mId == null && other.mId != null) || (this.mId != null && !this.mId.equals(other.mId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Massnahme[ mId=" + mId + " ]";
    }
    
}
