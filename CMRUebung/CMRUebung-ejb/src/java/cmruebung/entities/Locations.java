/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmruebung.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "locations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locations.findAll", query = "SELECT l FROM Locations l")})
public class Locations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "location_id")
    private Short locationId;
    @Size(max = 40)
    @Column(name = "street_address")
    private String streetAddress;
    @Size(max = 12)
    @Column(name = "postal_code")
    private String postalCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "city")
    private String city;
    @Size(max = 25)
    @Column(name = "state_province")
    private String stateProvince;
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne
    private Countries countries;
    @OneToMany(mappedBy = "locations")
    private List<Departments> departmentsList;

    public Locations() {
    }

    public Locations(Short locationId) {
        this.locationId = locationId;
    }

    public Locations(Short locationId, String city) {
        this.locationId = locationId;
        this.city = city;
    }

    public Short getLocationId() {
        return locationId;
    }

    public void setLocationId(Short locationId) {
        this.locationId = locationId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    @XmlTransient
    public List<Departments> getDepartmentsList() {
        return departmentsList;
    }

    public void setDepartmentsList(List<Departments> departmentsList) {
        this.departmentsList = departmentsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locations)) {
            return false;
        }
        Locations other = (Locations) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cmruebung.entities.Locations[ locationId=" + locationId + " ]";
    }
    
}
