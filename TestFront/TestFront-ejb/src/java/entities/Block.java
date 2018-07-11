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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stea1th
 */
@Entity
@Table(name = "Block")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Block.findAll", query = "SELECT b FROM Block b")})
public class Block implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "block_id")
    private Integer blockId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "von")
    @Temporal(TemporalType.DATE)
    private Date von;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bis")
    @Temporal(TemporalType.DATE)
    private Date bis;
    @JoinColumn(name = "baustein_id", referencedColumnName = "baustein_id")
    @ManyToOne(optional = false)
    private Baustein baustein;
    @JoinColumn(name = "k_id", referencedColumnName = "k_id")
    @ManyToOne(optional = false)
    private Klasse klasse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "block")
    private List<Fehltag> fehltagList;

    public Block() {
    }

    public Block(Integer blockId) {
        this.blockId = blockId;
    }

    public Block(Integer blockId, Date von, Date bis) {
        this.blockId = blockId;
        this.von = von;
        this.bis = bis;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Date getVon() {
        return von;
    }

    public void setVon(Date von) {
        this.von = von;
    }

    public Date getBis() {
        return bis;
    }

    public void setBis(Date bis) {
        this.bis = bis;
    }

    public Baustein getBaustein() {
        return baustein;
    }

    public void setBaustein(Baustein baustein) {
        this.baustein = baustein;
    }

    public Klasse getKlasse() {
        return klasse;
    }

    public void setKlasse(Klasse klasse) {
        this.klasse = klasse;
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
        hash += (blockId != null ? blockId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Block)) {
            return false;
        }
        Block other = (Block) object;
        if ((this.blockId == null && other.blockId != null) || (this.blockId != null && !this.blockId.equals(other.blockId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Block[ blockId=" + blockId + " ]";
    }
    
}
