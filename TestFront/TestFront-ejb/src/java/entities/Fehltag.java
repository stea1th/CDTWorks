/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stea1th
 */
@Entity
@Table(name = "Fehltag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fehltag.findAll", query = "SELECT f FROM Fehltag f")})
public class Fehltag implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FehltagPK fehltagPK;
    @Size(max = 100)
    @Column(name = "grund")
    private String grund;
    @JoinColumn(name = "block_id", referencedColumnName = "block_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Block block;
    @JoinColumn(name = "t_id", referencedColumnName = "t_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Teilnehmer teilnehmer;

    public Fehltag() {
    }

    public Fehltag(FehltagPK fehltagPK) {
        this.fehltagPK = fehltagPK;
    }

    public Fehltag(Date datum, int tId, int blockId) {
        this.fehltagPK = new FehltagPK(datum, tId, blockId);
    }

    public FehltagPK getFehltagPK() {
        return fehltagPK;
    }

    public void setFehltagPK(FehltagPK fehltagPK) {
        this.fehltagPK = fehltagPK;
    }

    public String getGrund() {
        return grund;
    }

    public void setGrund(String grund) {
        this.grund = grund;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public Teilnehmer getTeilnehmer() {
        return teilnehmer;
    }

    public void setTeilnehmer(Teilnehmer teilnehmer) {
        this.teilnehmer = teilnehmer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fehltagPK != null ? fehltagPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fehltag)) {
            return false;
        }
        Fehltag other = (Fehltag) object;
        if ((this.fehltagPK == null && other.fehltagPK != null) || (this.fehltagPK != null && !this.fehltagPK.equals(other.fehltagPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Fehltag[ fehltagPK=" + fehltagPK + " ]";
    }
    
}
