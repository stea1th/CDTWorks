package cmruebung.entities;

import cmruebung.entities.Employees;
import cmruebung.entities.Locations;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-21T15:28:40")
@StaticMetamodel(Departments.class)
public class Departments_ { 

    public static volatile SingularAttribute<Departments, String> departmentName;
    public static volatile ListAttribute<Departments, Employees> employeesList;
    public static volatile SingularAttribute<Departments, Short> departmentId;
    public static volatile SingularAttribute<Departments, Locations> locations;
    public static volatile SingularAttribute<Departments, Employees> employees;

}