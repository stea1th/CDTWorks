/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stea1th
 */
@Entity
@Table(name = "Mass_Klasse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MassKlasse.findAll", query = "SELECT m FROM MassKlasse m")})
public class MassKlasse implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MassKlassePK massKlassePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bis")
    @Temporal(TemporalType.DATE)
    private Date bis;
    @JoinColumn(name = "k_id", referencedColumnName = "k_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Klasse klasse;
    @JoinColumn(name = "m_id", referencedColumnName = "m_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Massnahme massnahme;

    public MassKlasse() {
    }

    public MassKlasse(MassKlassePK massKlassePK) {
        this.massKlassePK = massKlassePK;
    }

    public MassKlasse(MassKlassePK massKlassePK, Date bis) {
        this.massKlassePK = massKlassePK;
        this.bis = bis;
    }

    public MassKlasse(Date von, String kId, String mId) {
        this.massKlassePK = new MassKlassePK(von, kId, mId);
    }

    public MassKlassePK getMassKlassePK() {
        return massKlassePK;
    }

    public void setMassKlassePK(MassKlassePK massKlassePK) {
        this.massKlassePK = massKlassePK;
    }

    public Date getBis() {
        return bis;
    }

    public void setBis(Date bis) {
        this.bis = bis;
    }

    public Klasse getKlasse() {
        return klasse;
    }

    public void setKlasse(Klasse klasse) {
        this.klasse = klasse;
    }

    public Massnahme getMassnahme() {
        return massnahme;
    }

    public void setMassnahme(Massnahme massnahme) {
        this.massnahme = massnahme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (massKlassePK != null ? massKlassePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MassKlasse)) {
            return false;
        }
        MassKlasse other = (MassKlasse) object;
        if ((this.massKlassePK == null && other.massKlassePK != null) || (this.massKlassePK != null && !this.massKlassePK.equals(other.massKlassePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MassKlasse[ massKlassePK=" + massKlassePK + " ]";
    }
    
}
