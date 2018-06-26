/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcinsbserver;

import java.util.List;
import javax.ejb.Local;
import jdbcinsbdtos.DeptSalDTO;

/**
 *
 * @author stea1th
 */
@Local
public interface DBVermittlerLocal {
    List<DeptSalDTO> dbLesenUndAbliefern();
}
