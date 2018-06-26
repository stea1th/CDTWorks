/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbuebungneu.dtos;

/**
 *
 * @author stea1th
 */
public class TransportDtO {
     private String dName;
     private double average;
     private String lastName;
     private double salary;

    public TransportDtO(String dName, double average) {
        this.dName = dName;
        this.average = average;
    }

    public TransportDtO(String dName, String lastName, double salary) {
        this.dName = dName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getdName() {
        return dName;
    }

    public double getAverage() {
        return average;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }
     
     
}
