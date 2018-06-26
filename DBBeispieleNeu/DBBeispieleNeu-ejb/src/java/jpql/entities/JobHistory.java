/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpql.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stea1th
 */
@Entity
@Table(name = "job_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobHistory.findAll", query = "SELECT j FROM JobHistory j")})
public class JobHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JobHistoryPK jobHistoryPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "department_id")
    private Short departmentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "employee_id")
    private int employeeId1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "job_id")
    private String jobId;

    public JobHistory() {
    }

    public JobHistory(JobHistoryPK jobHistoryPK) {
        this.jobHistoryPK = jobHistoryPK;
    }

    public JobHistory(JobHistoryPK jobHistoryPK, Date endDate, int employeeId1, String jobId) {
        this.jobHistoryPK = jobHistoryPK;
        this.endDate = endDate;
        this.employeeId1 = employeeId1;
        this.jobId = jobId;
    }

    public JobHistory(int employeeId, Date startDate) {
        this.jobHistoryPK = new JobHistoryPK(employeeId, startDate);
    }

    public JobHistoryPK getJobHistoryPK() {
        return jobHistoryPK;
    }

    public void setJobHistoryPK(JobHistoryPK jobHistoryPK) {
        this.jobHistoryPK = jobHistoryPK;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Short getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Short departmentId) {
        this.departmentId = departmentId;
    }

    public int getEmployeeId1() {
        return employeeId1;
    }

    public void setEmployeeId1(int employeeId1) {
        this.employeeId1 = employeeId1;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobHistoryPK != null ? jobHistoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobHistory)) {
            return false;
        }
        JobHistory other = (JobHistory) object;
        if ((this.jobHistoryPK == null && other.jobHistoryPK != null) || (this.jobHistoryPK != null && !this.jobHistoryPK.equals(other.jobHistoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpql.entities.JobHistory[ jobHistoryPK=" + jobHistoryPK + " ]";
    }
    
}
