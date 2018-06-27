package cmruebung.entities;

import cmruebung.entities.Employees;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-27T11:55:25")
@StaticMetamodel(Jobs.class)
public class Jobs_ { 

    public static volatile SingularAttribute<Jobs, String> jobId;
    public static volatile SingularAttribute<Jobs, Integer> maxSalary;
    public static volatile ListAttribute<Jobs, Employees> employeesList;
    public static volatile SingularAttribute<Jobs, String> jobTitle;
    public static volatile SingularAttribute<Jobs, Integer> minSalary;

}