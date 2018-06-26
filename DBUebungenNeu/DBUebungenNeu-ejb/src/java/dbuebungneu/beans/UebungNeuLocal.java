/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbuebungneu.beans;

import dbuebungneu.dtos.TransportDtO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface UebungNeuLocal {
    public List<TransportDtO> getData();
    public List<TransportDtO> getSalary();
}
