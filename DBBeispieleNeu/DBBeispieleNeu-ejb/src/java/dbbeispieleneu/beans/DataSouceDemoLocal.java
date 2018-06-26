/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbeispieleneu.beans;

import java.util.List;
import java.util.Set;
import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface DataSouceDemoLocal {
    
    Set<String> leseRegions();
}
