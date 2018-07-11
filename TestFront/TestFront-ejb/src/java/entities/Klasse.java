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
@Table(name = "Klasse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klasse.findAll", query = "SELECT k FROM Klasse k")})
public class Klasse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "k_id")
    private String kId;
    @Size(max = 50)
    @Column(name = "bez")
    private String bez;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klasse")
    private List<Block> blockList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klasse")
    private List<MassKlasse> massKlasseList;

    public Klasse() {
    }

    public Klasse(String kId) {
        this.kId = kId;
    }

    public String getKId() {
        return kId;
    }

    public void setKId(String kId) {
        this.kId = kId;
    }

    public String getBez() {
        return bez;
    }

    public void setBez(String bez) {
        this.bez = bez;
    }

    @XmlTransient
    public List<Block> getBlockList() {
        return blockList;
    }

    public void setBlockList(List<Block> blockList) {
        this.blockList = blockList;
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
        hash += (kId != null ? kId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klasse)) {
            return false;
        }
        Klasse other = (Klasse) object;
        if ((this.kId == null && other.kId != null) || (this.kId != null && !this.kId.equals(other.kId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Klasse[ kId=" + kId + " ]";
    }
    
}
