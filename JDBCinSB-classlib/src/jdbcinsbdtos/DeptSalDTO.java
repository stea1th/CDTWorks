/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcinsbdtos;

import java.io.Serializable;

/**
 *
 * @author stea1th
 */
public class DeptSalDTO implements Serializable{
    
    private int deptId;
    private String deptName;
    private double deptSalSum;

    public DeptSalDTO(int deptId, String deptName, double deptSalSum) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptSalSum = deptSalSum;
    }

    public DeptSalDTO() {
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public double getDeptSalSum() {
        return deptSalSum;
    }

    public void setDeptSalSum(double deptSalSum) {
        this.deptSalSum = deptSalSum;
    }
    
    
}
