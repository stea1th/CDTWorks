/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ArtikelDTO;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface ModelLocal {
    public List<ArtikelDTO> getAllArtikels() throws SQLException, ClassNotFoundException;
    public void saveToDb(int id, int menge) throws ClassNotFoundException, SQLException;
}
