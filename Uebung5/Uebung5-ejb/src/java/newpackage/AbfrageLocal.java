/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface AbfrageLocal {
    
    List<TestDataDTO> getData(int id);
    List<TestDataDTO> getAllEmpl(int id);
}
