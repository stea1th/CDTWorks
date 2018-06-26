/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmrbeispiele.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "abteilung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Abteilung.findAll", query = "SELECT a FROM Abteilung a")})
public class Abteilung implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "abt_nr")
    private String abtNr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "abt_name")
    private String abtName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "stadt")
    private String stadt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "abteilung")
    private List<Mitarbeiter> mitarbeiterList;

    public Abteilung() {
    }

    public Abteilung(String abtNr) {
        this.abtNr = abtNr;
    }

    public Abteilung(String abtNr, String abtName, String stadt) {
        this.abtNr = abtNr;
        this.abtName = abtName;
        this.stadt = stadt;
    }

    public String getAbtNr() {
        return abtNr;
    }

    public void setAbtNr(String abtNr) {
        this.abtNr = abtNr;
    }

    public String getAbtName() {
        return abtName;
    }

    public void setAbtName(String abtName) {
        this.abtName = abtName;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    @XmlTransient
    public List<Mitarbeiter> getMitarbeiterList() {
        return mitarbeiterList;
    }

    public void setMitarbeiterList(List<Mitarbeiter> mitarbeiterList) {
        this.mitarbeiterList = mitarbeiterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (abtNr != null ? abtNr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abteilung)) {
            return false;
        }
        Abteilung other = (Abteilung) object;
        if ((this.abtNr == null && other.abtNr != null) || (this.abtNr != null && !this.abtNr.equals(other.abtNr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cmrbeispiele.entities.Abteilung[ abtNr=" + abtNr + " ]";
    }
    
}
