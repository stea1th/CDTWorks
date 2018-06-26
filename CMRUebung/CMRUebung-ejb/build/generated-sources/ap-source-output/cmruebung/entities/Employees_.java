package cmruebung.entities;

import cmruebung.entities.Departments;
import cmruebung.entities.Employees;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-21T15:28:40")
@StaticMetamodel(Employees.class)
public class Employees_ { 

    public static volatile SingularAttribute<Employees, String> lastName;
    public static volatile SingularAttribute<Employees, Date> hireDate;
    public static volatile ListAttribute<Employees, Employees> employeesList;
    public static volatile SingularAttribute<Employees, Integer> employeeId;
    public static volatile SingularAttribute<Employees, Double> salary;
    public static volatile SingularAttribute<Employees, Double> commissionPct;
    public static volatile SingularAttribute<Employees, String> firstName;
    public static volatile SingularAttribute<Employees, String> jobId;
    public static volatile SingularAttribute<Employees, String> phoneNumber;
    public static volatile ListAttribute<Employees, Departments> departmentsList;
    public static volatile SingularAttribute<Employees, Departments> departments;
    public static volatile SingularAttribute<Employees, Employees> employees;
    public static volatile SingularAttribute<Employees, String> email;

}