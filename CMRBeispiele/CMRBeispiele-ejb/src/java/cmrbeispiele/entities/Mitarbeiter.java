/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmrbeispiele.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stea1th
 */
@Entity
@Table(name = "mitarbeiter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mitarbeiter.findAll", query = "SELECT m FROM Mitarbeiter m")})
public class Mitarbeiter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "m_nr")
    private Integer mNr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "m_name")
    private String mName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "m_vorname")
    private String mVorname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "wohnort")
    private String wohnort;
    @JoinColumn(name = "abt_nr", referencedColumnName = "abt_nr")
    @ManyToOne(optional = false)
    private Abteilung abteilung;

    public Mitarbeiter() {
    }

    public Mitarbeiter(Integer mNr) {
        this.mNr = mNr;
    }

    public Mitarbeiter(Integer mNr, String mName, String mVorname, String wohnort) {
        this.mNr = mNr;
        this.mName = mName;
        this.mVorname = mVorname;
        this.wohnort = wohnort;
    }

    public Integer getMNr() {
        return mNr;
    }

    public void setMNr(Integer mNr) {
        this.mNr = mNr;
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public String getMVorname() {
        return mVorname;
    }

    public void setMVorname(String mVorname) {
        this.mVorname = mVorname;
    }

    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    public Abteilung getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(Abteilung abteilung) {
        this.abteilung = abteilung;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mNr != null ? mNr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mitarbeiter)) {
            return false;
        }
        Mitarbeiter other = (Mitarbeiter) object;
        if ((this.mNr == null && other.mNr != null) || (this.mNr != null && !this.mNr.equals(other.mNr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cmrbeispiele.entities.Mitarbeiter[ mNr=" + mNr + " ]";
    }
    
}
