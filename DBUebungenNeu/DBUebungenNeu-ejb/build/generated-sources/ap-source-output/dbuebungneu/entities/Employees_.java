package dbuebungneu.entities;

import dbuebungneu.entities.Employees;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-19T11:56:42")
@StaticMetamodel(Employees.class)
public class Employees_ { 

    public static volatile CollectionAttribute<Employees, Employees> employeesCollection;
    public static volatile SingularAttribute<Employees, String> lastName;
    public static volatile SingularAttribute<Employees, String> firstName;
    public static volatile SingularAttribute<Employees, String> jobId;
    public static volatile SingularAttribute<Employees, Date> hireDate;
    public static volatile SingularAttribute<Employees, String> phoneNumber;
    public static volatile SingularAttribute<Employees, Short> departmentId;
    public static volatile SingularAttribute<Employees, Integer> employeeId;
    public static volatile SingularAttribute<Employees, Double> salary;
    public static volatile SingularAttribute<Employees, Employees> employees;
    public static volatile SingularAttribute<Employees, String> email;
    public static volatile SingularAttribute<Employees, Double> commissionPct;

}