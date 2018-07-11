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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author stea1th
 */
@Embeddable
public class FehltagPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_id")
    private int tId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "block_id")
    private int blockId;

    public FehltagPK() {
    }

    public FehltagPK(Date datum, int tId, int blockId) {
        this.datum = datum;
        this.tId = tId;
        this.blockId = blockId;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getTId() {
        return tId;
    }

    public void setTId(int tId) {
        this.tId = tId;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datum != null ? datum.hashCode() : 0);
        hash += (int) tId;
        hash += (int) blockId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FehltagPK)) {
            return false;
        }
        FehltagPK other = (FehltagPK) object;
        if ((this.datum == null && other.datum != null) || (this.datum != null && !this.datum.equals(other.datum))) {
            return false;
        }
        if (this.tId != other.tId) {
            return false;
        }
        if (this.blockId != other.blockId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FehltagPK[ datum=" + datum + ", tId=" + tId + ", blockId=" + blockId + " ]";
    }
    
}
