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
import javax.validation.constraints.Size;

/**
 *
 * @author stea1th
 */
@Embeddable
public class MassKlassePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "von")
    @Temporal(TemporalType.DATE)
    private Date von;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "k_id")
    private String kId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "m_id")
    private String mId;

    public MassKlassePK() {
    }

    public MassKlassePK(Date von, String kId, String mId) {
        this.von = von;
        this.kId = kId;
        this.mId = mId;
    }

    public Date getVon() {
        return von;
    }

    public void setVon(Date von) {
        this.von = von;
    }

    public String getKId() {
        return kId;
    }

    public void setKId(String kId) {
        this.kId = kId;
    }

    public String getMId() {
        return mId;
    }

    public void setMId(String mId) {
        this.mId = mId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (von != null ? von.hashCode() : 0);
        hash += (kId != null ? kId.hashCode() : 0);
        hash += (mId != null ? mId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MassKlassePK)) {
            return false;
        }
        MassKlassePK other = (MassKlassePK) object;
        if ((this.von == null && other.von != null) || (this.von != null && !this.von.equals(other.von))) {
            return false;
        }
        if ((this.kId == null && other.kId != null) || (this.kId != null && !this.kId.equals(other.kId))) {
            return false;
        }
        if ((this.mId == null && other.mId != null) || (this.mId != null && !this.mId.equals(other.mId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MassKlassePK[ von=" + von + ", kId=" + kId + ", mId=" + mId + " ]";
    }
    
}
