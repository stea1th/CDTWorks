/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dto.TeilnehmerDTO;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface FehlTageBeanLocal {
    
    List<TeilnehmerDTO> abfrage1(String name, String vorname, String massnahme) throws ClassNotFoundException, SQLException;
    List<TeilnehmerDTO> abfrage2(String name, String vorname, String massnahme) throws ClassNotFoundException, SQLException;
    List<TeilnehmerDTO> abfrage3(String name, String vorname, String massnahme, String baustein) throws ClassNotFoundException, SQLException;
    List<TeilnehmerDTO> abfrage4(String massnahme)throws ClassNotFoundException, SQLException;
    List<TeilnehmerDTO> abfrage5(String massnahme, String baustein) throws ClassNotFoundException, SQLException;
    List<TeilnehmerDTO> abfrage6() throws ClassNotFoundException, SQLException;
    
    
    
    
}
