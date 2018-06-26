/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcinsbserver;

import java.util.List;
import javax.ejb.Remote;
import jdbcinsbdtos.DeptSalDTO;

/**
 *
 * @author stea1th
 */
@Remote
public interface DBVermittlerRemote {
    String dbLesenUndAnzeigen();
    List<DeptSalDTO> dbLesenUndAbliefern();
}
