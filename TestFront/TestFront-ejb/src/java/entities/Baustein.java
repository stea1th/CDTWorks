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
@Table(name = "Baustein")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Baustein.findAll", query = "SELECT b FROM Baustein b")})
public class Baustein implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "baustein_id")
    private String bausteinId;
    @Size(max = 50)
    @Column(name = "bez")
    private String bez;
    @JoinTable(name = "Mass_Bau", joinColumns = {
        @JoinColumn(name = "baustein_id", referencedColumnName = "baustein_id")}, inverseJoinColumns = {
        @JoinColumn(name = "m_id", referencedColumnName = "m_id")})
    @ManyToMany
    private List<Massnahme> massnahmeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baustein")
    private List<Block> blockList;

    public Baustein() {
    }

    public Baustein(String bausteinId) {
        this.bausteinId = bausteinId;
    }

    public String getBausteinId() {
        return bausteinId;
    }

    public void setBausteinId(String bausteinId) {
        this.bausteinId = bausteinId;
    }

    public String getBez() {
        return bez;
    }

    public void setBez(String bez) {
        this.bez = bez;
    }

    @XmlTransient
    public List<Massnahme> getMassnahmeList() {
        return massnahmeList;
    }

    public void setMassnahmeList(List<Massnahme> massnahmeList) {
        this.massnahmeList = massnahmeList;
    }

    @XmlTransient
    public List<Block> getBlockList() {
        return blockList;
    }

    public void setBlockList(List<Block> blockList) {
        this.blockList = blockList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bausteinId != null ? bausteinId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Baustein)) {
            return false;
        }
        Baustein other = (Baustein) object;
        if ((this.bausteinId == null && other.bausteinId != null) || (this.bausteinId != null && !this.bausteinId.equals(other.bausteinId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Baustein[ bausteinId=" + bausteinId + " ]";
    }
    
}
