
package jpql.dtos;

import java.io.Serializable;

public class Beispiel4DTO implements Serializable{
    
    private String jobId;
    private String jobTitle;
    private Integer minSalary;

    public Beispiel4DTO() {
    }
    
    public Beispiel4DTO(String jobId, String jobTitle, Integer minSalary) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }
}
